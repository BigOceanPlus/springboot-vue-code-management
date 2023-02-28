<template>
    <div id="home">
      载体类型
        <div id="id1" style="width:300px; height:300px; background-color:#F0F8FF; margin-top: 50px;"></div>
    </div>
</template>
<script setup lang="ts">
import { onMounted, reactive } from '@vue/runtime-core';
import * as echarts from 'echarts';
import request from "../request";
type EChartsOption = echarts.EChartsOption;
const form = reactive({
  table: [{
    name:"",
    value:0
  }]
})
onMounted(() =>{

    var chartDom = document.getElementById('id1')!;
    var myChart = echarts.init(chartDom);
    var option: EChartsOption;
    request.get("/chart/carrier").then(res => {
      console.log(res)
      form.table = res.data.data
      option = {
      tooltip: {
        trigger: 'item'
      },
      legend: {
        top: '5%',
        left: 'center'
      },
      series: [
        {
          name: '载体数量',
          type: 'pie',
          radius: ['40%', '70%'],
          avoidLabelOverlap: false,
          label: {
            show: false,
            position: 'center'
          },
          emphasis: {
            label: {
              show: true,
              fontSize: 40,
              fontWeight: 'bold'
            }
          },
          labelLine: {
            show: false
          },
          data: form.table
        }
      ]
    };

    option && myChart.setOption(option);
    })
})
</script>
<style>
#home{
    display: flex;
    flex-direction: column;
    height: 90%;
    width: 90%;
    margin: 5px;
    align-items: center;
    /*background-color: aqua;*/
}
.flex{
    display: flex;
    flex-direction: row;
    align-items: center;
}
</style>
