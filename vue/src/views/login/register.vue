<template>
  <div style="height: 80vh;">
    <div style="width: 500px;height: 700px;background-color: white;border-radius: 10px;margin: 100px auto;padding:50px 60px">
      <div style="margin-bottom:30px;text-align: center;font-size: 30px;font-weight: bold;color: cornflowerblue">注册</div>
      <el-form :model="admin" ref="ruleForm" :rules="rules">
        <el-form-item prop="u_username">
          <el-input style="width: 380px" placeholder="请输入账号" prefix-icon="el-icon-user" size="medium" v-model="admin.u_username"></el-input>
        </el-form-item>
        <el-form-item prop="u_password">
          <el-input style="width: 380px;margin-top: 20px" show-password placeholder="请输入密码" prefix-icon="el-icon-lock" size="medium" v-model="admin.u_password"></el-input>
        </el-form-item>
        <el-form-item prop="u_name">
          <el-input style="width: 380px;margin-top: 20px" placeholder="真实姓名" size="medium" v-model="admin.u_name"></el-input>
        </el-form-item>
        <el-form-item prop="u_idCard">
          <el-input style="width: 380px;margin-top: 20px" placeholder="身份证号" size="medium" v-model="admin.u_idCard"></el-input>
        </el-form-item>
        <el-form-item prop="u_address">
          <el-input style="width: 380px;margin-top: 20px" placeholder="地址" size="medium" v-model="admin.u_address"></el-input>
        </el-form-item>
        <el-form-item prop="u_phone">
          <el-input style="width: 380px;margin-top: 20px" placeholder="手机号码" size="medium" v-model="admin.u_phone"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button style="width: 100%;margin-top:10px" size="medium" type="primary" @click="register">注册</el-button>
        </el-form-item>
        <el-form-item>
          <el-button style="width: 100%" size="medium" type="text" @click="login">返回登陆</el-button>
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
        ],
        u_name: [
          {required: true, message: '请输入真实姓名', trigger: 'blur'}
        ],
        u_idCard: [
          {required: true, message: '请输入身份证号码', trigger: 'blur'},
          {min: 18,max: 18, message: '请输入18位身份证号码', trigger: 'blur'}
        ],
        u_address: [
          {required: true, message: '请输入地址', trigger: 'blur'}
        ],
        u_phone: [
          {required: true, message: '请输入手机号码', trigger: 'blur'},
          {min: 11,max: 11, message: '请输入11位手机号码', trigger: 'blur'}
        ]
      }
    }
  },
  methods:{
    register(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid){
      request.post('/admin/save',this.admin).then(res => {
        if (res.code === '200'){
          this.$notify.success("注册成功")
          this.$router.push('/')
        }else {
          this.$notify.error(res.msg)
        }
      })
        }else{
          alert("数据不合法")
        }

      })
    },
    login(){
      this.$router.push('login')
    }
  }
}
</script>