<template>
  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">新增用户</div>
    <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" style="width: 80%" label-width="150px">
      <el-form-item label="患者姓名" prop="name">
        <el-input v-model="form.name" placeholder="请输入患者姓名"></el-input>
      </el-form-item>
      <el-form-item label="患者年龄" prop="age">
        <el-input v-model="form.age" placeholder="请输入患者年龄"></el-input>
      </el-form-item>
      <el-form-item label="患者性别">
        <el-radio v-model="form.sex" label="男">男</el-radio>
        <el-radio v-model="form.sex" label="女">女</el-radio>
        <el-radio v-model="form.sex" label="武装直升机">武装直升机</el-radio>
      </el-form-item>
      <el-form-item label="患者电话" prop="phone">
        <el-input v-model="form.phone" placeholder="请输入患者电话"></el-input>
      </el-form-item>
      <el-form-item label="患者状态">
        <el-input v-model="form.status" placeholder="请输入患者状态"></el-input>
      </el-form-item>
      <el-form-item label="使用病房">
        <el-input v-model="form.ward" placeholder="当前使用病房，如未使用输入无"></el-input>
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
  name: 'AddUser',
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
        sex:'武装直升机'
      },

      rules: {
        name: [
          {required: true, message: '请输入患者姓名', trigger: 'blur'}
        ],
        phone:[
          {required: true, message: '请输入患者手机号', trigger: 'blur'},
          {min: 11,max: 11, message: '请输入11位手机号', trigger: 'blur'}
        ],
        age:[
          {validator: checkAge, trigger:'blur'}
        ]
      }
    }
  },
  methods:{
    save(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          request.post("/user/save", this.form).then(res => {
            if (res.code === "200"){
              this.$notify.success('新增成功')
              this.from={sex:'武装直升机'}
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

