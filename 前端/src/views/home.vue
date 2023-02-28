<template>
    <div id="layout">
        <el-container style="height: 100%; width: 100%;">
            <el-header style="height: 10%; background-color: #F5F5F5;" id="head">
                <img src="../assets/head.png" alt="失败" height="100" width="100" style="margin-right: 50px" />
                <span style="font-size: 35px; opacity: 0.9; color:deepskyblue; margin-right: 1000px">
                    编解码管理系统
                </span>
                <span style="font-size: 35px; color:deepskyblue; margin-right: 30px">
                    欢迎您,用户<span>{{user}}</span>
                </span>
                <img src="../assets/exit.png" alt="失败" height="50" width="50" @click="exit"/>
            </el-header>
            <el-container style="height: 90%;">
                <el-aside style="width: 10%; background-color: #F8F8FF;">
                    <el-menu
                        default-active="1" style="background-color:#F0F8FF">
                        <el-sub-menu index="1">
                            <template #title>
                                <el-icon style="color:#1E90FF"><User /></el-icon>
                                <span style="color:#1E90FF">用户管理</span>
                            </template>
                            <el-menu-item index="1-1" style="background-color:#E0FFFF"><router-link to="/home/user">用户管理</router-link></el-menu-item>
                        </el-sub-menu>
                        <el-sub-menu index="2">
                            <template #title>
                                <el-icon style="color:#1E90FF"><MessageBox /></el-icon>
                                <span style="color:#1E90FF">编码管理</span>
                            </template>
                            <el-menu-item index="2-1" style="background-color:#E0FFFF"><router-link to="/home/code">编码管理</router-link></el-menu-item>
                        </el-sub-menu>
                        <el-sub-menu index="3">
                            <template #title>
                                <el-icon style="color:#1E90FF"><More /></el-icon>
                                <span style="color:#1E90FF">提交编码</span>
                            </template>
                            <el-menu-item index="3-1" style="background-color:#E0FFFF"><router-link to="/home/submit">提交编码</router-link></el-menu-item>
                        </el-sub-menu>
                        <el-sub-menu index="4">
                            <template #title>
                                <el-icon style="color:#1E90FF"><Document /></el-icon>
                                <span style="color:#1E90FF">提交文件</span>
                            </template>
                            <el-menu-item index="4-1" style="background-color:#E0FFFF"><router-link to="/home/file">提交文件</router-link></el-menu-item>
                        </el-sub-menu>
                        <el-sub-menu index="5">
                            <template #title>
                                <el-icon style="color:#1E90FF"><PieChart /></el-icon>
                                <span style="color:#1E90FF">数据可视化</span>
                            </template>
                            <el-menu-item index="5-1" style="background-color:#E0FFFF"><router-link to="/home/view">数据可视化</router-link></el-menu-item>
                        </el-sub-menu>
                    </el-menu>
                </el-aside>
                <el-main style="width: 80%; background-color: #FFFAFA">
                    <router-view />
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script setup lang="ts">
import request from "../request";
import {ElNotification, ElMessage} from 'element-plus'
import { ref,reactive, onMounted} from "vue";
import router from "../router";
import { User,MessageBox,PieChart,More,Document } from '@element-plus/icons-vue'

const exit = (() => {
    router.push("/")
    ElMessage({
        showClose: true,
        message: '退出系统',
    })
})

var user:any = ref(localStorage.getItem("user"))

</script>

<style>
#layout{
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
}
#head{
display: flex; 
  flex-direction: row; 
  align-items: center;
}
</style>
