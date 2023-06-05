<template>

  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">新增用户</div>
    <el-form :inline="true" :model="form" style="width: 80%" label-width="150px">
      <el-form-item label="id">
        <el-input v-model="form.d_id" disabled></el-input>
      </el-form-item>
      <el-form-item label="uid">
        <el-input v-model="form.d_uid" disabled></el-input>
      </el-form-item>
      <el-form-item label="医生姓名">
        <el-input v-model="form.d_name" placeholder="请输入医生姓名"></el-input>
      </el-form-item>
      <el-form-item label="医生年龄">
        <el-input v-model="form.d_age" placeholder="请输入医生年龄"></el-input>
      </el-form-item>
      <el-form-item label="医生电话">
        <el-input v-model="form.d_phone" placeholder="请输入医生电话"></el-input>
      </el-form-item>
      <el-form-item label="医生薪资">
        <el-input v-model="form.d_money" placeholder="请输入医生薪资"></el-input>
      </el-form-item>
      <el-form-item label="专业方向">
        <el-input v-model="form.d_profession" placeholder="请输入医生专业方向"></el-input>
      </el-form-item>
      <el-form-item label="医生学历">
        <el-input v-model="form.d_educational" placeholder="请输入医生学历"></el-input>
      </el-form-item>
      <el-form-item label="医生等级" prop="d_leve">
        <el-input v-model="form.d_leve" placeholder="医生等级"></el-input>
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
  name: 'EditDoctor',
  data() {
    return {
      form:{}
    }
  },
  created(){
    const d_id = this.$route.query.d_id
    request.get("/doctor/" + d_id).then(res =>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.post("/doctor/update", this.form).then(res => {
        if (res.code === "200"){
          this.$notify.success('更新成功')
          this.$router.push("doctorList")
        }else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>

