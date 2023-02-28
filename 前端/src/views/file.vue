<template>
  <div id="home">
      <el-card style="height:80%; width:80%; margin-top:20px" class="flex">
        <img
          src="../assets/upload.png"
          class="image"/>
        <div style="padding: 14px">
          <el-upload
            action="http://localhost:9090/file/code/upload"
            :limit="1"
            :on-success="success"
            >
            <el-button type="primary" style="width:500px">上传文件</el-button>
            <template #tip>
              <div class="el-upload__tip" style="text-align:center">
                文件名必须为36位数字且可以被正确解码
              </div>
            </template>
          </el-upload> 
        </div>
      </el-card>
   </div>
</template>

<script setup lang="ts">
import request from "../request";
const success = ((res: any) => {
    console.log(res)
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
