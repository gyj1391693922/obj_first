<template>
  <div>
    <!--头部栏header-->
    <div style="height: 60px; line-height: 60px; background-color: white; margin-bottom: 3px;display: flex">
      <div>
        <span class="el-icon-tickets" style="margin-left: 30px; font-size: 24px;">医院后台</span>
      </div>
      <div style="flex: 1;text-align: right;padding-right: 35px;">
        <el-dropdown size="medium" trigger="hover">
        <span class="el-dropdown-link">
          管理员<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
          <el-dropdown-menu slot="dropdown" style="width: 120px;margin-top:-5px" >
            <el-dropdown-item  ><div @click="login">退出登录</div></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>

    <!--侧边栏和主体-->
    <div style="display: flex;">
      <!--侧边栏导航-->
      <div style="width: 200px;min-height: calc(100vh - 63px); overflow: hidden; margin-right: 2px; background-color: white;">
        <el-menu :default-active="$route.path" router class="el-menu-demo">
          <el-menu-item index="/">
            <i class="el-icon-s-order"></i>
            <span>患者中心</span>
          </el-menu-item>
          <!-- === user ===-->
          <el-submenu index="user">
            <template slot="title">
              <i class="el-icon-s-unfold"></i>
              <span>患者管理</span>
            </template>
            <el-menu-item index="/userList">
              <i class="el-icon-user-solid"></i>
              <span>患者列表</span>
            </el-menu-item>
            <el-menu-item index="/addUser">
              <i class="el-icon-circle-plus"></i>
              <span>添加患者</span>
            </el-menu-item>
          </el-submenu>

          <!-- === doctor ===-->
          <el-submenu index="doctor">
            <template slot="title">
              <i class="el-icon-s-unfold"></i>
              <span>工作人员管理</span>
            </template>
            <el-menu-item index="/doctorList">医生列表</el-menu-item>
            <el-menu-item index="/addDoctor">添加医生</el-menu-item>
          </el-submenu>

          <!-- === admin === -->
          <el-submenu index="admin">
            <template slot="title">
              <i class="el-icon-s-unfold"></i>
              <span>用户管理</span>
            </template>
            <el-menu-item index="/adminList">用户列表</el-menu-item>
            <el-menu-item index="/addAdmin">添加用户</el-menu-item>
          </el-submenu>

          <!-- ==== medicinal ==== -->
          <el-submenu index="medicinal">
            <template slot="title">
              <i class="el-icon-s-unfold"></i>
              <span>药品专柜</span>
            </template>
            <el-menu-item index="/medicinalList">药品信息</el-menu-item>
            <el-menu-item index="/addMedicinal">添加药品</el-menu-item>
          </el-submenu>

          <!-- ==== receipt ==== -->
          <el-submenu index="receipt">
            <template slot="title">
              <i class="el-icon-s-unfold"></i>
              <span>订单信息</span>
            </template>
            <el-menu-item index="/receiptList">订单详情</el-menu-item>
            <el-menu-item index="/addReceipt">添加订单</el-menu-item>
          </el-submenu>



        </el-menu>
      </div>
      <!--主体数据-->
      <div style="flex: 1;background-color: white;">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Layout",
  methods:{
    login(){
      this.$router.push('login')
    }
  }
}
</script>

