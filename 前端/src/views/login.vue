<template>
  <div id="layout">
    <el-container style="height: 100%; width: 100%;">
      <el-header style="height: 10%; font-size: 30px; ">
        <el-steps :space="200" :active="1" simple style="opacity: 0.5">
          <el-step title="step1: 进入页面" :icon="Edit" />
          <el-step title="step2: 输入用户密码" :icon="UploadFilled" />
          <el-step title="step3: 点击登录" :icon="Check" />
        </el-steps>
      </el-header>
      <el-main id="el-main">
        <div id="main">
          <h1 style="text-align: center; opacity: 0.6;">登录页面</h1>
          <el-form
            status-icon
            ref="ruleFormRef"
            :model="form"
            label-width="100px"
            style="margin-top: 100px"
            :rules="rules">
            <el-form-item label="用户名" prop="username">
              <el-input v-model="form.username" style="width: 400px"/>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input v-model="form.password" type="password" style="width: 400px"/>
            </el-form-item>
            <el-form-item label="密码确认" prop="confirm">
              <el-input v-model.number="form.confirm" type="password" style="width: 400px"/>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm(ruleFormRef)"
                >登录</el-button>
              <el-button @click="resetForm(ruleFormRef)">清空</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-main>
      <el-main style="height: 10%; font-size: 40px; text-align:center; color:blue; ">
        <span style="margin: 50px">
          @Author:BigOcean
        </span> 
        <span style="margin: 50px">
          @Version:1.0
        </span> 
      </el-main>
    </el-container>
  </div>
</template>

<script setup lang="ts">
import { Edit,UploadFilled,Check } from '@element-plus/icons-vue'
import request from "../request";
import {ElNotification, ElMessage, FormInstance} from 'element-plus'
import { ref,reactive} from "vue";
import router from "../router";

const ruleFormRef = ref<FormInstance>()
const form = reactive({
  username:"",
  password:"",
  confirm:"",
})

const validate1 = (rule: any, value: string, callback: any) => {
  if(value == '') callback(new Error("内容不能为空"))
  callback()
}
const validate2 = (rule: any, value: string, callback: any) => {
  if(value == '') callback(new Error("内容不能为空"))
  else if(value.length < 6 || value.length > 18) callback(new Error("密码长度必须介于6到19之间"))
  callback()
}
const validate3 = (rule: any, value: string, callback: any) => {
  if(value == '') callback(new Error("内容不能为空"))
  else if(value != form.password) callback(new Error("两次密码输入不一致"))
  else callback()
}
const rules = reactive({
  username: [{ validator: validate1, trigger: 'blur' }],
  password: [{ validator: validate2, trigger: 'blur' }],
  confirm: [{ validator: validate3, trigger: 'blur' }],
})
const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      request.post('/user/login',form).then(res => {
        console.log(res)
        if(res.data.code){
          ElMessage({
            type: 'success',
            message: '登录成功',
          })
          localStorage.removeItem("user")
          localStorage.setItem("user",form.username)
          router.push('/home')
        }
        else{
          ElNotification({
            title: "警告",
            type: 'error',
            message: '用户密码错误',
          })
        }
      })
    } 
    else {
      ElNotification({
            title: "警告",
            type: 'error',
            message: '未通过表单校验',
      })
    }
  })
}
const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>

<style>
#layout{
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-size:100% 100%;
  background-repeat: no-repeat;
  background-image: url("../assets/login_bg.jpg");
}
#el-main{
  height: 80%; 
  font-size: 30px; 
  display: flex; 
  flex-direction: column; 
  align-items: center;
}
#main{
  margin: 100px;
  height: 500px;
  width: 600px;
  border: 3px solid white;
  background-color: rgba(220, 230, 230, 0.4);
  /*display: flex; 
  flex-direction: column; 
  align-items: center;*/
}
</style>