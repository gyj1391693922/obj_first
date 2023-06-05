<template>
  <div>
    <!-- 搜索表单 -->
    <div style="margin-bottom: 20px;">
      <el-input style="width: 240px;margin-left: 10px;margin-top: 10px;" placeholder="请输入姓名" v-model="params.d_name"></el-input>
      <el-input style="width: 240px; margin-left: 10px;" placeholder="请输入联系方式" v-model="params.d_phone"></el-input>
      <el-input style="width: 240px; margin-left: 10px;" placeholder="请输入职业等级" v-model="params.d_leve"></el-input>
      <el-button style="margin-left: 15px;margin-top: 10px;" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
      <el-button style="margin-left: 15px;margin-top: 10px;" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>

    <el-table :data="tableData" stripe>
      <el-table-column prop="d_id" label="id" disabled width="50px"></el-table-column>
      <el-table-column prop="d_leve" label="职业等级" disabled width="150px"></el-table-column>
      <el-table-column prop="d_name" label="姓名" width="80px"></el-table-column>
      <el-table-column prop="d_age" label="年龄" width="80px"></el-table-column>
      <el-table-column prop="d_sex" label="性别" width="80px"></el-table-column>
      <el-table-column prop="d_phone" label="联系电话" width="150px"></el-table-column>
      <el-table-column prop="d_educational" label="学历" width="120px"></el-table-column>
      <el-table-column prop="d_money" label="当前薪资/月" width="180px"></el-table-column>
      <el-table-column prop="d_profession" label="专业方向" width="180px"></el-table-column>
      <el-table-column prop="d_createTime" label="入职时间" width="180px"></el-table-column>
      <el-table-column prop="d_uid" label="身份识别号" width="180px"></el-table-column>


      <el-table-column label="操作">
        <template v-slot="scope">
          <!--scope.row就是当前行数据-->
          <el-button type="primary" @click="$router.push('/editDoctor?d_id=' + scope.row.d_id)">编辑</el-button>
          <el-popconfirm title="确定删除吗？" @confirm="del(scope.row.d_id)">
            <el-button type="danger" slot="reference" style="margin-left: 10px">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>


    </el-table>
    <!-- 分页 -->
    <div style="margin-top:20px">
      <el-pagination
          :current-page="params.pageNum"
          :page-size="params.pageSize"
          small
          layout="prev, pager, next"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: 'Doctor',
  data() {
    return {
      tableData: [],
      total:0,
      params:{
        pageNum: 1,
        pageSize: 10,
        d_name: '',
        d_phone: '',
        d_leve: ''
      }
    }
  },
  created() {
    this.load()
  },
  methods:{
    del(id){
      request.delete("/doctor/del/" + id).then(res=>{
        if (res.code === "200"){
          this.$notify.success("删除成功")
        }else {
          this.$notify.error(res.msg)
        }
      })
    },
    load(){
      // fetch('http://localhost:9090/user/list').then(res => res.json()).then(res =>{
      //   this.tableData = res
      // })

      request.get('/doctor/page',{
        params: this.params
      }).then(res => {
        if (res.code === '200'){
          this.tableData = res.data.list
          this.total = res.data.total
        }else {
          alert("传输失败")
        }
      })
    },
    reset(){
      this.params = {
        pageNum: 1,
        pageSize: 10,
        d_name: '',
        d_phone: '',
        d_leve: ''
      }
    }
  }
}
</script>
