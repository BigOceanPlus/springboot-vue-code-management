<template>
    <div id="home">
        <el-card style="height:80%; width:90%; margin-top:50px">
            <template #header>
            <div class="card-header">
                <span>用户管理界面</span>
            </div>
            </template>
            <span class="flex">
                <el-table :data="form.table" stripe border height="500" style="width: 90%; margin-top:30px; border:1px solid #708090">
                    <template #empty><el-empty description="无数据" /></template>
                    <el-table-column prop="username" label="用户名" width="180" />
                    <el-table-column prop="password" label="密码" width="180" />
                    <el-table-column prop="remark" label="备注" />
                    <el-table-column label="操作" width="260">
                        <template #default="scope">
                            <el-button link type="danger" size="small" @click="deleteItem(scope.$index, scope.row.username)"><el-icon><Delete /></el-icon>删除</el-button>
                            <el-button link type="primary" size="small" @click="handler1(scope.row)"><el-icon><Edit /></el-icon>编辑</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-button round type="primary" style="width:200px; margin-top:10px" @click="handler2()">添加用户</el-button>
            </span>
            
            <el-dialog draggable v-model="dialogFormVisible" title="用户表单">
                <h1 style="text-align:center; font-size: 30px;" v-if="form.flag == 1">修改用户</h1>
                <h1 style="text-align:center; font-size: 30px;" v-if="form.flag == 2">添加用户</h1>
                <el-form :model="form.state" :rules="rules" ref="ruleFormRef">              
                <el-form-item label="用户名" :label-width="150" prop="name" v-if="form.flag == 2">
                    <el-input v-model="form.state.username" />
                </el-form-item>
                <el-form-item label="密码" :label-width="150" prop="password">
                    <el-input v-model="form.state.password" />
                </el-form-item>
                <el-form-item label="备注" :label-width="150" prop="type">
                    <el-input v-model="form.state.remark" />
                </el-form-item>
                </el-form>
                <template #footer>
                <span>
                    <el-button @click="dialogFormVisible = false">取消</el-button>
                    <el-button type="primary" @click="Confirm">确定</el-button>
                </span>
                </template>
          </el-dialog>
        </el-card>
    </div>
</template>

<script setup lang="ts">
import { ref,reactive, onMounted} from "vue";
import {ElNotification, ElMessage, FormInstance} from 'element-plus'
import { Delete,Edit } from '@element-plus/icons-vue'
import request from "../request";

const dialogFormVisible = ref(false)
const form = reactive({
    table:[],
    state:{
        username:"",
        password:"",
        remark:"",
    },
    flag:0
})
const rules = ref<FormInstance>()
const handler1 = (row:any) => {
    form.flag = 1
    dialogFormVisible.value = true
    form.state = JSON.parse(JSON.stringify(row))
}
const handler2 = () => {
    form.flag = 2
    dialogFormVisible.value = true
    form.state = {
        username:"",
        password:"",
        remark:"",
    }
}
const deleteItem = ((index:any, row:any) => {
    request.get("/user/" + row).then(res =>{
        form.table.splice(index,1)
        ElMessage.success("删除成功")
    })
})
const load = (() => {
    request.get("/user").then(res => {
        form.table = res.data.data
    })
})
onMounted(() => {
    load()
})
const Confirm = (() => {
    // 修改
    if(form.flag == 1){
        request.post("/user/update",form.state).then(res =>{
            load()
            ElMessage.success("修改成功")
            dialogFormVisible.value = false
        })
    }
    // 添加
    else if(form.flag == 2){
        request.post("/user/insert",form.state).then(res =>{
            load()
            ElMessage.success("添加成功")
            dialogFormVisible.value = false
        })
    }
})
</script>

<style>
#home{
    display: flex;
    flex-direction: column;
    height: 100%;
    width: 100%;
    margin: 5px;
    align-items: center;
    /*background-color: aqua;*/
}
.flex{
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>