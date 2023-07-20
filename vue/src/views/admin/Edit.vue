<template>

  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">新增用户</div>
    <el-form :inline="true" :model="form" style="width: 80%" label-width="150px">
      <el-form-item label="id">
        <el-input v-model="form.u_id" disabled></el-input>
      </el-form-item>
      <el-form-item label="uid">
        <el-input v-model="form.u_username" disabled></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.u_password" placeholder="请输入新密码"></el-input>
      </el-form-item>
      <el-form-item label="真实姓名">
        <el-input v-model="form.u_name" placeholder="请输入真实姓名"></el-input>
      </el-form-item>
      <el-form-item label="身份证号码">
        <el-input v-model="form.u_idCard" placeholder="请输入身份证号码"></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="form.u_address" placeholder="请输入地址"></el-input>
      </el-form-item>
      <el-form-item label="手机号码">
        <el-input v-model="form.u_phone" placeholder="请输入手机号码"></el-input>
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
  name: 'EditAdmin',
  data() {
    return {
      form:{}
    }
  },
  created(){
    const u_id = this.$route.query.u_id
    request.get("/admin/" + u_id).then(res =>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.post("/admin/update", this.form).then(res => {
        if (res.code === "200"){
          this.$notify.success('更新成功')
          this.$router.push("adminList")
        }else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>

