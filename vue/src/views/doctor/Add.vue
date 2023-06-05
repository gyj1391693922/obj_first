<template>
  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">添加医生</div>
    <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" style="width: 80%" label-width="150px">
      <el-form-item label="uid" prop="d_uid">
        <el-input v-model="form.d_uid" placeholder="例：10001"></el-input>
      </el-form-item>
      <el-form-item label="医生姓名" prop="d_name">
        <el-input v-model="form.d_name" placeholder="请输入医生姓名"></el-input>
      </el-form-item>
      <el-form-item label="医生年龄" prop="d_age">


        <el-input v-model="form.d_age" placeholder="请输入医生年龄"></el-input>
      </el-form-item>

      <el-form-item label="医生电话" prop="d_phone">
        <el-input v-model="form.d_phone" placeholder="请输入医生电话"></el-input>
      </el-form-item>
      <el-form-item label="医生专业方向" prop="d_profession">
        <el-input v-model="form.d_profession" placeholder="请输入医生专业方向"></el-input>
      </el-form-item>
      <el-form-item label="医生等级" prop="d_leve">
        <el-input v-model="form.d_leve" placeholder="医生等级"></el-input>
      </el-form-item>
      <el-form-item label="当前薪资" prop="d_money">
        <el-input v-model="form.d_money" placeholder="当前薪资"></el-input>
      </el-form-item>
      <el-form-item label="当前学历">
        <el-input v-model="form.d_educational" placeholder="当前学历"></el-input>
      </el-form-item>
      <el-form-item label="医生性别">
        <el-radio v-model="form.d_sex" label="男">男</el-radio>
        <el-radio v-model="form.d_sex" label="女">女</el-radio>
      </el-form-item>
    </el-form>

    <div style="margin: 50px 330px">
      <el-button type="primary" @click="save">提交</el-button>
    </div>

  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: 'AddDoctor',
  data() {
    const checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('年龄不能为空'));
      }

        if (!/^[0-9]+$/.test(value)) {
          callback(new Error('请输入数字值'));
        }callback()
    };

    return {
      form:{
        d_sex:'男'
      },

      rules: {
        d_name: [
          {required: true, message: '请输入医生姓名', trigger: 'blur'}
        ],
        d_profession: [
          {required: true, message: '请输入医生专业方向', trigger: 'blur'}
        ],
        d_money: [
          {required: true, message: '请输入当前薪资', trigger: 'blur'}
        ],
        d_leve: [
          {required: true, message: '请输入医生等级', trigger: 'blur'}
        ],
        d_phone:[
          {required: true, message: '请输入医生手机号', trigger: 'blur'},
          {min: 11,max: 11, message: '请输入11位手机号', trigger: 'blur'}
        ],
        d_uid:[
          {required: true, message: '请输入医生唯一识别号', trigger: 'blur'},
          {min: 5,max: 5, message: '请输入5位识别号', trigger: 'blur'}
        ],
        d_age:[
          {validator: checkAge, trigger:'blur'}
        ]
      }
    }
  },
  methods:{
    save(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          request.post("/doctor/save", this.form).then(res => {
            if (res.code === "200"){
              this.$notify.success('新增成功')
              this.from={d_sex:'男'}
            }else {
              this.$notify.error(res.msg)
            }
          })
        }else{
          alert("数据不合法")
        }
      })

    }
  }
}
</script>

