import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/Layout.vue'

Vue.use(VueRouter)

const routes = [
    // ==== 注册 ====
  {
    path: '/register',
    name: 'register',
    component:()=>import('@/views/login/register')
  },
    // ==== 登录 ====
  {
    path: '/login',
    name: 'login',
    component: ()=>import('@/views/login/Login')
  },
    // ===== 主页 =====
  {
    path: '/',
    name: 'layout',
    component: Layout,
    redirect: '/home',
    children:[//子路由
        //主页
      {
        path: 'home',
        name: 'Home',
        component: ()=>import('@/views/home/HomeView.vue')
      },
      // ==== Admin ====
      {
        path: 'adminList',
        name: 'admin',
        component: ()=>import('@/views/admin/List.vue')
      },
      {
        path:'addAdmin',
        name:'AddAdmin',
        component: () => import('@/views/admin/Add.vue')
      },
      {
        path: 'editAdmin',
        name: 'EditAdmin',
        component: () => import('@/views/admin/Edit.vue')
      },
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
