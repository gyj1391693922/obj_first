<template>
  <div style="padding:20px 50px">
    <div style="margin-bottom: 30px">添加药单</div>
    <el-form :inline="true" :model="form" :rules="rules" ref="ruleForm" style="width: 80%" label-width="150px">
      <el-form-item label="药品编号" prop="m_number">
        <el-select v-model="form.m_number" clearable filterable placeholder="请选择" @change="updateMedicineName">
          <el-option
              v-for="item in m_numbers"
              :key="item.id"
              :label="item.m_number + '(' + item.m_name + ')'"
              :value="item.m_number"
          ></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="药品名" prop="m_name">
        <el-input v-model="form.m_name" clearable filterable placeholder="请选择" disabled>
        </el-input>
      </el-form-item>

      <el-form-item label="购买人姓名" prop="u_name">
        <el-input v-model="form.u_name" placeholder="购买人姓名"></el-input>
      </el-form-item>
      <el-form-item label="总金额" prop="m_amount">
        <el-input v-model="form.m_amount" placeholder="总金额"></el-input>
      </el-form-item>
      <el-form-item label="购买人手机号" prop="u_phone">
        <el-input v-model="form.u_phone" placeholder="购买人手机号"></el-input>
      </el-form-item>
      <el-form-item label="数量" prop="r_number">
        <el-input v-model="form.r_number" placeholder="数量"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="r_comment">
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
  computed: {
    filteredMedicineNames() {
      // 根据选择的药品编号过滤药品名列表
      return this.m_numbers.filter(item => item.m_number === this.form.m_number);
    },
  },

  name: 'AddAdmin',
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
      form:{},
      m_names:[],
      m_numbers:[],
      rules: {
        u_name: [
          {required: true, message: '请输入购买人姓名', trigger: 'blur'}
        ],
        r_number:[
          {validator: checkAge, trigger:'blur'}
        ],
        u_phone: [
          {required: true, message: '请输入手机号', trigger: 'blur'},
          {min: 11,max: 11, message: '请输入11位手机号', trigger: 'blur'}
        ],
      }
    }
  },
  created(){
    request.get('/medicinal/list').then(res => {
      this.m_names = res.data
    })

    request.get('/medicinal/list').then(res => {
      this.m_numbers = res.data
    })
  },
  methods:{
    updateMedicineName() {
      // 监听药品编号字段变化，更新药品名字段的值
      const selectedMedicine = this.m_numbers.find(item => item.m_number === this.form.m_number);
      if (selectedMedicine) {
        this.form.m_name = selectedMedicine.m_name;
      } else {
        this.form.m_name = '';

      }
    },
    save(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          request.post("/receipt/save", this.form).then(res => {
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

