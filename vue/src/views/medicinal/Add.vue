<template>
  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">添加药物信息</div>
    <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" style="width: 80%" label-width="150px">
      <el-form-item label="药品编码" prop="m_number">
        <el-input v-model="form.m_number" placeholder="请输入5位药品编码"></el-input>
      </el-form-item>
      <el-form-item label="药名" prop="m_name">
        <el-input v-model="form.m_name" placeholder="请输入药名"></el-input>
      </el-form-item>
      <el-form-item label="数量" prop="m_qty">
        <el-input v-model="form.m_qty" placeholder="请输入数量"></el-input>
      </el-form-item>
      <el-form-item label="净含量" prop="m_content">
        <el-input v-model="form.m_content" placeholder="请输入净含量"></el-input>
      </el-form-item>
      <el-form-item label="单价" prop="m_price">
        <el-input v-model="form.m_price" placeholder="药品单价"></el-input>
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
  name: 'AddMedicinal',
  data() {
    const checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('数量不能为空,如果没有库存应该填0'));
      }

      if (!/^[0-9]+$/.test(value)) {
        callback(new Error('请输入数字'));
      }callback()
    };
    return {
      form:{
      },

      rules: {
        m_number: [
          {required: true, message: '请输入编码', trigger: 'blur'},
          {min: 5,max: 5, message: '请输入5位编码', trigger: 'blur'}
        ],
        m_name: [
          {required: true, message: '请输入药名', trigger: 'blur'}
        ],
        m_qty:[
          {required: true,validator: checkAge, trigger:'blur'}
        ],
        m_content: [
          {required: true, message: '请输入净含量', trigger: 'blur'}
        ],
        m_price:[
          {required: true, message: '请输入单价', trigger: 'blur'},
        ]
      }
    }
  },
  methods:{
    save(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          request.post("/medicinal/save", this.form).then(res => {
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

