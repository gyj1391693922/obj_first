<template>

  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">修改药单</div>
    <el-form :inline="true" :model="form" style="width: 80%" label-width="150px">
      <el-form-item label="id">
        <el-input v-model="form.id" disabled></el-input>
      </el-form-item>
      <el-form-item label="药名">
        <el-input v-model="form.m_name" disabled></el-input>
      </el-form-item>
      <el-form-item label="药品编码">
        <el-input v-model="form.m_number" disabled></el-input>
      </el-form-item>
      <el-form-item label="购买人姓名">
        <el-input v-model="form.u_name" placeholder="购买人姓名"></el-input>
      </el-form-item>
      <el-form-item label="总金额">
        <el-input v-model="form.m_amount" placeholder="总金额"></el-input>
      </el-form-item>
      <el-form-item label="购买人联系方式">
        <el-input v-model="form.u_phone" placeholder="购买人联系方式"></el-input>
      </el-form-item>
      <el-form-item label="购买数量">
        <el-input v-model="form.r_number" placeholder="购买数量"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="form.r_comment" placeholder="备注"></el-input>
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
  name: 'EditReceipt',
  data() {
    return {
      form:{}
    }
  },
  created(){
    const id = this.$route.query.id
    request.get("/receipt/" + id).then(res =>{
      this.form = res.data
    })
  },
  methods:{
    save(){
      request.post("/receipt/update", this.form).then(res => {
        if (res.code === "200"){
          this.$notify.success('更新成功')
          this.$router.push("receiptList")
        }else {
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>

