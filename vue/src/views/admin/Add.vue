<template>
  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">新增用户</div>
    <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" style="width: 80%" label-width="150px">
      <el-form-item label="账号" prop="u_username">
        <el-input v-model="form.u_username" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="u_password">
        <el-input v-model="form.u_password" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item label="真实姓名" prop="u_name">
        <el-input v-model="form.u_name" placeholder="真实姓名"></el-input>
      </el-form-item>
      <el-form-item label="身份证号码" prop="u_idCard">
        <el-input v-model="form.u_idCard" placeholder="身份证号码"></el-input>
      </el-form-item>
      <el-form-item label="家庭住址" prop="u_address">
        <el-input v-model="form.u_address" placeholder="家庭住址"></el-input>
      </el-form-item>
      <el-form-item label="手机号码" prop="u_phone">
        <el-input v-model="form.u_phone" placeholder="手机号码"></el-input>
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
  name: 'AddAdmin',
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
      },

      rules: {
        u_username: [
          {required: true, message: '请输入账号', trigger: 'blur'}
        ],
        u_password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 6,max: 18, message: '密码至少6位，至多18位', trigger: 'blur'}
        ],
        u_name: [
          {required: true, message: '请输入真实姓名', trigger: 'blur'}
        ],
        u_idCard: [
          {validator: checkAge, trigger:'blur'},
          {min: 18,max: 18, message: '请输入18位身份证号码', trigger: 'blur'}
        ],
        u_phone:[
          {validator: checkAge, trigger:'blur'},
          {min: 11,max: 11, message: '请输入11位手机号', trigger: 'blur'}
        ],
        u_address:[
          {required: true, message: '请输入地址', trigger: 'blur'},
        ]
      }
    }
  },
  methods:{
    save(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          request.post("/admin/save", this.form).then(res => {
            if (res.code === "200"){
              this.$notify.success('新增成功')
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

