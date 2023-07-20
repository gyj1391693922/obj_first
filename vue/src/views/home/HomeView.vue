<template>
  <div style="width: 100%;height:100%;background-color:#eee ">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="1">处理中心</el-menu-item>
      <el-submenu index="2">
        <template slot="title">缴费金额明细</template>
        <el-menu-item index="2-1">全部</el-menu-item>
      </el-submenu>
    </el-menu>
    <div style="width: 100%;height:20px;background-color:#eee "></div>

    <div><el-badge class="item" style="margin-top:-30px;padding:25px 35px">数据展示</el-badge></div>
    <div style="width: 97%;height:180px;background-color: white;margin: 0px auto;border-radius: 5px">
      <div style="height: 15px"></div>
      <el-row :gutter="20">
        <el-col :span="6">
          <div>
            <el-statistic group-separator="," :value="value2" :title="title"></el-statistic>
          </div>
        </el-col>
        <el-col :span="6">
        </el-col>
      </el-row>

    </div>
  </div>
</template>

<script>
  export default {
  data() {
  return {
  like: true,
  value2: 2222,
  title: '今年增长',
};
},
};
</script>

