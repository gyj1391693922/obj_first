<template>
  <div style="height: 80vh; overflow: hidden">
    <div style="width: 500px;height: 400px;background-color: white;border-radius: 10px;margin: 150px auto;padding:50px 60px">
      <div style="margin-bottom:30px;text-align: center;font-size: 30px;font-weight: bold;color: cornflowerblue">登录</div>
      <el-form :model="admin" ref="ruleForm" :rules="rules">
        <el-form-item prop="u_username">
          <el-input style="width: 380px" placeholder="请输入账号" prefix-icon="el-icon-user" size="medium" v-model="admin.u_username"></el-input>
        </el-form-item>
        <el-form-item prop="u_password">
          <el-input style="width: 380px;margin-top: 20px" show-password placeholder="请输入密码" prefix-icon="el-icon-lock" size="medium" v-model="admin.u_password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%;margin-top:10px" size="medium" type="primary" @click="login">登录</el-button>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" size="medium" type="text"><div @click="register">注册</div></el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Login",
  data(){
    return{
      admin: {},
      rules: {
        u_username: [
          {required: true, message: '请输入账号', trigger: 'blur'}
        ],
        u_password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 6,max: 18, message: '请输入至少6位，至多18位密码', trigger: 'blur'}
        ]
      }
    }
  },
  methods:{
    login(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid){
      request.post('/admin/login',this.admin).then(res => {
        if (res.code === '200'){
          this.$notify.success("登陆成功")
          this.$router.push('home')
        }else {
          this.$notify.error(res.msg)
        }
      })
        }

      })
    },
    register(){
      this.$router.push('register')
    }
  }
}
</script>