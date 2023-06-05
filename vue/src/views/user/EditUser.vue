<template>

  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">新增用户</div>
    <el-form :inline="true" :model="form" style="width: 80%" label-width="150px">
      <el-form-item label="卡号">
        <el-input v-model="form.idCard" disabled></el-input>
      </el-form-item>
      <el-form-item label="id">
        <el-input v-model="form.id" disabled></el-input>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-input v-model="form.createTime" disabled></el-input>
      </el-form-item>
      <el-form-item label="患者姓名">
        <el-input v-model="form.name" placeholder="请输入患者姓名"></el-input>
      </el-form-item>
      <el-form-item label="患者年龄">
        <el-input v-model="form.age" placeholder="请输入患者年龄"></el-input>
      </el-form-item>
      <el-form-item label="患者性别">
        <el-input v-model="form.sex" placeholder="请输入患者性别"></el-input>
      </el-form-item>
      <el-form-item label="患者电话">
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
  name: 'EditUser',
  data() {
    return {
      form:{}
    }
  },
  created(){
    const id = this.$route.query.id
    request.get("/user/" + id).then(res =>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.post("/user/update", this.form).then(res => {
        if (res.code === "200"){
          this.$notify.success('更新成功')
          this.$router.push("userList")
        }else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>

