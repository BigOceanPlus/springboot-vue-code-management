<template>
        <el-container style="height: 800px; width: 1600px;">
            <el-header height="10%" id="login_header" style="background-color:#00BFFF">
                <div style="font-size: 40px; margin-top:30px">
                  <el-icon :size="80" style="color:antiquewhite">
                    <Document />
                  </el-icon>
                </div>
                
            </el-header>
            <el-main height="80%" style="background-color:#E6E6FA">
                <div style="margin:auto; margin: 80px;">
                    <el-form :model="form" ref="ruleFormRef" :rules="rules" style="margin-left: 400px">
                        <el-form-item label="解码" placeholder="请输入编码" prop="input" style="margin-bottom: 30px">
                            <el-input v-model="form.input" style="width:400px; text-align:center; "></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit(ruleFormRef)">提交</el-button>
                            <el-button style="margin-left:40px" @click="cancel">清空</el-button>
                        </el-form-item>
                    </el-form>

                    <div style="margin-left: 400px; margin-bottom: 100px;">解码数据JSON：{{result1}}</div>

                    <el-dialog draggable v-model="dialogFormVisible" align-center title="格式输入" width="50%" >
                        <template #header="{ titleId, titleClass }">
                            <div class="my-header">
                                <h3 :id="titleId" :class="titleClass">格式输入</h3>
                            </div>
                        </template>         
                        <el-form ref="ruleFromDialog" :rules="dialogRules" :model="dialogForm">
                            <el-form-item label="地理信息选择">
                                <el-col :span="5">
                                    <el-form-item prop="province">
                                        <el-input v-model="dialogForm.province" placeholder="省" />
                                    </el-form-item>
                                </el-col>
                                <el-col :span="5">
                                    <el-form-item prop="prefecture" >
                                        <el-input v-model="dialogForm.prefecture" placeholder="地级市" />
                                    </el-form-item>
                                </el-col>
                                <el-col :span="5">
                                    <el-form-item prop="county" >
                                        <el-input v-model="dialogForm.county" placeholder="县" />
                                    </el-form-item>
                                </el-col>
                                <el-col :span="5">
                                    <el-form-item prop="street" >
                                        <el-input v-model="dialogForm.street" placeholder="街道" />
                                    </el-form-item>
                                </el-col>
                                <el-col :span="4">
                                    <el-form-item prop="community" >
                                        <el-input v-model="dialogForm.community" placeholder="社区" />
                                    </el-form-item>
                                </el-col>
                            </el-form-item>
                            <el-form-item label="日期时间选择">
                                <el-col :span="11">
                                    <el-date-picker
                                    v-model="dialogForm.data"
                                    type="date"
                                    placeholder="日期"
                                    format="YYYY/MM/DD"
                                    value-format="YYYY-MM-DD"
                                    style="width: 100%"
                                    />
                                </el-col>
                                <el-col :span="2" style="text-align:center;">
                                    <span >----</span>
                                </el-col>
                                <el-col :span="11">
                                    <el-time-picker
                                    v-model="dialogForm.time"
                                    placeholder="时间"
                                    format="hh:mm:ss"
                                    value-format="hh-mm-ss"
                                    style="width: 100%"
                                    />
                                </el-col>
                            </el-form-item>
                            <el-form-item label="来源选择">
                                <el-select v-model="dialogForm.sourceMajor" placeholder="大类选择" @change="optionChange1">
                                    <el-option
                                    v-for="item in options"
                                    :label="item.label"
                                    :value="item.value"
                                    />
                                </el-select>
                                <el-col :span="2" style="text-align:center;">
                                    <span >----</span>
                                </el-col>
                                <el-select v-model="dialogForm.sourceSubclass" placeholder="子类选择" :disabled="flag1" ref="selector1">
                                    <el-option
                                    v-for="item in selectOption1"
                                    :label="item.label"
                                    :value="item.value"
                                    />
                                </el-select>
                            </el-form-item>
                        </el-form>
                        <el-form-item label="载体选择">
                            <el-col :span="16">
                                <el-select v-model="dialogForm.carrier" placeholder="选择">
                                    <el-option
                                    v-for="item in options4"
                                    :label="item.label"
                                    :value="item.value"
                                    />
                                </el-select>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="灾情选择">
                            <el-col :span="10">
                                <el-select v-model="dialogForm.disasterMajor" placeholder="灾情大类" style="width:100%" @change="optionChange2">
                                    <el-option
                                    v-for="item in classoptions"
                                    :label="item.label"
                                    :value="item.value"
                                    />
                                </el-select>
                            </el-col>
                            <el-col :span="2" style="text-align:center;">
                                <span >----</span>
                            </el-col>
                            <el-col :span="6">
                                <el-select v-model="dialogForm.disasterSubclass" placeholder="灾情子类" :disabled="flag2">
                                    <el-option
                                    v-for="item in selectOption2"
                                    :label="item.label"
                                    :value="item.value"
                                    />
                                </el-select>
                            </el-col>
                            <el-col :span="6">
                                <el-select v-model="dialogForm.disasterQuota" placeholder="灾情指标" :disabled="flag2">
                                    <el-option
                                    v-for="item in selectOption3"
                                    :label="item.label"
                                    :value="item.value"
                                    />
                                </el-select>
                            </el-col>
                        </el-form-item>
                        <el-form-item label="备注">
                          <el-input v-model="dialogForm.remark" placeholder="请输入备注" />
                        </el-form-item>
                        <template #footer>
                            <span>
                                <el-button @click="dialogFormVisible = false">取消</el-button>
                                <el-button type="primary" @click="DialogSubmit">确定</el-button>
                            </span>
                        </template>
                    </el-dialog>
                    
                    <div style="margin-left: 400px">
                        编码: <el-button @click="dialogFormVisible = true" style="margin-bottom:10px; margin-left: 20px" >打开表单</el-button><br />
                        新数据ID号: {{result2}}
                    </div>
                </div>
            </el-main>
            <el-footer height="10%" style="background-color: #F5FFFA; color:#87CEEB">
                <span style="text-align:center; font-size:40px; margin-left: 600px;">@Author:BigOcean</span>
            </el-footer>
        </el-container>
</template>

<script setup lang="ts">
import request from "../request";
import {ElNotification, ElMessage, SelectContext, SelectOptionProxy} from 'element-plus'
import { ref,reactive,onMounted } from "vue";
import type { FormInstance, FormRules } from 'element-plus'
import { Document } from '@element-plus/icons-vue'
const dialogFormVisible = ref(false)
const form = reactive({
    input: '',
})
const dialogForm = reactive({
  province:"",
  prefecture:"",
  county:"",
  street:"",
  community:"",
  data:"",
  time:"",
  sourceMajor:"",
  sourceSubclass:"",
  carrier:"",
  disasterMajor:"",
  disasterSubclass:"",
  disasterQuota:"",
  remark:"",
})
const ruleFormRef = ref<FormInstance>()
const dialogRules = reactive<FormRules>({

})
const rules = reactive<FormRules>({
    input: [
    {required: true, message: '输入不能为空', trigger: 'blur'},
    { min: 36, max: 36, message: '长度必须为36', trigger: 'blur' }
  ]
})
const result1 = ref("")
const result2 = ref("")

const options = [
  {
    value: '业务报送数据',
    label: '业务报送数据',
  },
  {
    value: '泛在感知数据',
    label: '泛在感知数据',
  },
  {
    value: '其他数据',
    label: '其他数据',
  },
]

const options1 = [
  {
    value: '前方地震应急指挥部',
    label: '前方地震应急指挥部',
  },
  {
    value: '后方地震应急指挥部',
    label: '后方地震应急指挥部',
  },
  {
    value: '应急指挥技术系统',
    label: '应急指挥技术系统',
  },
  {
    value: '社会服务工程应急救援系统',
    label: '社会服务工程应急救援系统',
  },
  {
    value: '危险区预评估工作组',
    label: '危险区预评估工作组',
  },
]
const options2 = [
  {
    value: '互联网感知',
    label: '互联网感知',
  },
  {
    value: '通信网感知',
    label: '通信网感知',
  },
  {
    value: '舆情网感知',
    label: '舆情网感知',
  },
  {
    value: '电力系统感知',
    label: '电力系统感知',
  },
  {
    value: '交通系统感知',
    label: '交通系统感知',
  },
]
const options3 = [
  {
    value: '其他数据',
    label: '其他数据',
  },
]
const options4 = [
  {
    value: '文字',
    label: '文字',
  },
  {
    value: '图像',
    label: '图像',
  },
  {
    value: '音频',
    label: '音频',
  },
  {
    value: '视频',
    label: '视频',
  },
  {
    value: '其他',
    label: '其他',
  },
]

const classoptions = [
  {
    value: '震情',
    label: '震情',
  },
  {
    value: '人员伤亡及失踪',
    label: '人员伤亡及失踪',
  },
  {
    value: '房屋破坏',
    label: '房屋破坏',
  },
]

const suboptions1 = [
  {
    value: '震情信息',
    label: '震情信息',
  },
]
const suboptions2 = [
  {
    value: '死亡',
    label: '死亡',
  },
  {
    value: '受伤',
    label: '受伤',
  },
  {
    value: '失踪',
    label: '失踪',
  },
]
const suboptions3 = [
  {
    value: '土木',
    label: '土木',
  },
  {
    value: '砖木',
    label: '砖木',
  },
  {
    value: '砖混',
    label: '砖混',
  },
  {
    value: '框架',
    label: '框架',
  },
  {
    value: '其他',
    label: '其他',
  },
]

const quotaoptions1 = [
  {
    value: '地理位置',
    label: '地理位置',
  },
  {
    value: '时间',
    label: '时间',
  },
  {
    value: '震级',
    label: '震级',
  },
  {
    value: '震源深度',
    label: '震源深度',
  },
  {
    value: '烈度',
    label: '烈度',
  },
]
const quotaoptions2 = [
  {
    value: '受灾人数',
    label: '受灾人数',
  },
  {
    value: '受灾程度',
    label: '受灾程度',
  },
]
const quotaoptions3 = [
  {
    value: '一般损坏面积',
    label: '一般损坏面积',
  },
  {
    value: '严重损坏面积',
    label: '严重损坏面积',
  },
  {
    value: '受灾程度',
    label: '受灾程度',
  },
]

var selectOption1 = options1
var selectOption2 = suboptions1
var selectOption3 = quotaoptions1
var flag1 = ref(true)
var flag2 = ref(true)
var selector1 = ref()

const onSubmit = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
        request.get('/code/decode/insert/json/' + form.input).then(res => {
            result1.value = res.data.data
            ElNotification({
                title: "提示",
                type: 'success',
                message: '提交成功'
            })
        })
    }
    else {
        result1.value = ""
        ElNotification({
            title: "警告",
            type: 'error',
            message: '未通过表单校验'
        })
    }
  })
}

const DialogSubmit = () => {
    request.post('/code/encode/insert/',dialogForm).then(res => {
        result2.value = res.data.data
        
        ElNotification({
            title: "提示",
            type: 'success',
            message: '提交成功'
        })
        dialogFormVisible.value = false
    })
}

const cancel = () => {
    form.input = ''
}

const optionChange1 = (val:string) => {
    flag1.value = false
    if(val=="业务报送数据"){
        selectOption1 = options1
    }
    else if(val=='泛在感知数据'){
        selectOption1 = options2
        
    }
    else if(val=='其他数据'){
        selectOption1 = options3
        
    }
}
const optionChange2 = (val:string) => {
    flag2.value = false
    if(val=="震情"){
        selectOption2 = suboptions1
        selectOption3 = quotaoptions1
    }
    else if(val=='人员伤亡及失踪'){
        selectOption2 = suboptions2
        selectOption3 = quotaoptions2
    }
    else if(val=='房屋破坏'){
        selectOption2 = suboptions3
        selectOption3 = quotaoptions3
    }
}
</script>

<style>
#login_header{
  display: flex;
  flex-direction: column;
  align-items: center;
  /* background: yellow; */
}
.flex{
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>