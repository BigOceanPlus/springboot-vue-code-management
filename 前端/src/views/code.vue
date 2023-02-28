<template>
    <div id="home">
        <el-card style="height:95%; width:100%; margin-top:20px">
            <template #header>
            <div class="card-header">
                <span>用户管理界面</span>
            </div>
            </template>
            <span class="flex">
                <el-table :data="form.table" border height="500" style="width: 95%; margin-top:30px; border:1px solid #708090">
                    <template #empty><el-empty description="无数据" /></template>
                    <el-table-column prop="id" label="ID号" width="180" />
                    <el-table-column prop="code" label="编码" width="180" />
                    <el-table-column prop="geographic" label="地理信息" width="180" />
                    <el-table-column prop="data_time" label="时间日期" width="180" />
                    <el-table-column prop="source" label="来源" width="180" />
                    <el-table-column prop="carrier" label="载体" width="180" />
                    <el-table-column prop="disaster" label="震情" width="180" />
                    <el-table-column prop="remark" label="备注" width="180" />
                    <el-table-column prop="url" label="文件url" width="180" />
                    <el-table-column label="文件操作" width="150" fixed="right">
                        <template #default="scope">
                            <el-upload
                                :action="url"
                                :limit="1"
                            >
                            <el-button link type="primary" size="small" @click="updateUrl(scope.row.id)"><el-icon><Edit /></el-icon>添加文件</el-button>
                            </el-upload>
                        </template>
                    </el-table-column>
                    <el-table-column label="行操作" width="100" fixed="right">
                        <template #default="scope">
                            <el-button link type="primary" size="small" @click="openFile(scope.row.url)"><el-icon><Files /></el-icon>查看文件</el-button>
                            <el-button link type="danger" size="small" @click="deleteItem(scope.$index, scope.row.id)"><el-icon><Delete /></el-icon>删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>
            </span>
            
            
        </el-card>
    </div>
</template>

<script setup lang="ts">
import { ref,reactive, onMounted} from "vue";
import {ElNotification, ElMessage, FormInstance} from 'element-plus'
import { Delete,Edit,Files } from '@element-plus/icons-vue'
import request from "../request";

const dialogFormVisible = ref(false)

const prefix = "http://localhost:9090/file/upload/"
const url = ref("");
const updateUrl = (id:any) => {
    url.value = prefix + id
    console.log(url)
}

const openFile = (url:any) => {
    window.open(url)
}

const form = reactive({
    table:[],
    state:{
        id:"",
        code:"",
        geographic:"",
        data_time:"",
        source:"",
        carrier:"",
        disaster:"",
        remark:"",
        url:"",
    },
    flag:0
})
const rules = ref<FormInstance>()
const handler1 = (row:any) => {
    form.flag = 1
    dialogFormVisible.value = true
    form.state = JSON.parse(JSON.stringify(row))
}

const deleteItem = ((index:any, row:any) => {
    request.get("/code/item/" + row).then(res =>{
        form.table.splice(index,1)
        ElMessage.success("删除成功")
    })
})
const load = (() => {
    request.get("/code/item").then(res => {
        form.table = res.data.data
    })
})
onMounted(() => {
    load()
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