<template>
  <div>
    <!-- 搜索表单 -->
    <div style="margin-bottom: 20px;">
      <el-input style="width: 240px;margin-left: 10px;margin-top: 10px;" placeholder="购买人姓名" v-model="params.u_name"></el-input>
      <el-input style="width: 240px; margin-left: 10px;" placeholder="购买人电话" v-model="params.u_phone"></el-input>
      <el-input style="width: 240px; margin-left: 10px;" placeholder="id" v-model="params.id"></el-input>
      <el-button style="margin-left: 15px;margin-top: 10px;" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
      <el-button style="margin-left: 15px;margin-top: 10px;" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>

    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="id" disabled width="50px"></el-table-column>
      <el-table-column prop="m_name" label="药名" disabled width="150px"></el-table-column>
      <el-table-column prop="m_number" label="药编号" width="100px"></el-table-column>
      <el-table-column prop="u_name" label="购买人姓名" width="180px"></el-table-column>
      <el-table-column prop="m_amount" label="购买金额" width="150px"></el-table-column>
      <el-table-column prop="u_phone" label="购买人电话" width="150px"></el-table-column>
      <el-table-column prop="r_createtime" label="购买时间" width="180px"></el-table-column>
      <el-table-column prop="r_number" label="购买数量" width="150px"></el-table-column>
      <el-table-column prop="r_comment" label="备注" width="250px"></el-table-column>


      <el-table-column label="操作">
        <template v-slot="scope">
          <!--scope.row就是当前行数据-->
          <el-button type="primary" @click="$router.push('/editReceipt?id=' + scope.row.id)">编辑</el-button>
          <el-popconfirm title="确定删除吗？" @confirm="del(scope.row.id)">
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
  name: 'Receipt',
  data() {
    return {
      tableData: [],
      total:0,
      params:{
        pageNum: 1,
        pageSize: 10,
        u_name: '',
        u_phone: '',
        id: ''
      }
    }
  },
  created() {
    this.load()
  },
  methods:{
    del(id){
      request.delete("/receipt/del/" + id).then(res=>{
        if (res.code === "200"){
          this.$notify.success("删除成功")
          window.location.href = window.location.href + '?t=' + Date.now()
        }else {
          this.$notify.error(res.msg)
        }
      })
    },
    load(){
      // fetch('http://localhost:9090/user/list').then(res => res.json()).then(res =>{
      //   this.tableData = res
      // })

      request.get('/receipt/page',{
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
        u_name: '',
        u_phone: '',
        id:''
      }
    }
  }
}
</script>
