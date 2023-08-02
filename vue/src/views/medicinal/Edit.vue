<template>

  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">新增用户</div>
    <el-form :inline="true" :model="form" style="width: 80%" label-width="150px">
      <el-form-item label="id">
        <el-input v-model="form.m_id" disabled></el-input>
      </el-form-item>
      <el-form-item label="uid">
        <el-input v-model="form.m_number" disabled></el-input>
      </el-form-item>
      <el-form-item label="药名">
        <el-input v-model="form.m_name" placeholder="请输入药名"></el-input>
      </el-form-item>
      <el-form-item label="数量">
        <el-input v-model="form.m_qty" placeholder="请输入数量"></el-input>
      </el-form-item>
      <el-form-item label="净含量">
        <el-input v-model="form.m_content" placeholder="净含量"></el-input>
      </el-form-item>
      <el-form-item label="单价">
        <el-input v-model="form.m_price" placeholder="单价"></el-input>
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
  name: 'EditMedicinal',
  data() {
    return {
      form:{}
    }
  },
  created(){
    const m_id = this.$route.query.m_id
    request.get("/medicinal/" + m_id).then(res =>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.post("/medicinal/update", this.form).then(res => {
        if (res.code === "200"){
          this.$notify.success('更新成功')
          this.$router.push("medicinalList")
        }else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>

