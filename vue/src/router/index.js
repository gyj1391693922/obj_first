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
      // ==== User ====
      {
        path: 'userList',
        name: 'User',
        component: ()=>import('@/views/user/User.vue')
      },
      {
        path:'addUser',
        name:'AddUser',
        component: () => import('@/views/user/AddUser.vue')
      },
      {
        path:'editUser',
        name:'EditUser',
        component: () => import('@/views/user/EditUser.vue')
      },
      // ==== Doctor ====
      {
        path: 'doctorList',
        name: 'doctor',
        component: ()=>import('@/views/doctor/List.vue')
      },
      {
        path:'addDoctor',
        name:'AddDoctor',
        component: () => import('@/views/doctor/Add.vue')
      },
      {
        path:'editDoctor',
        name:'EditDoctor',
        component: () => import('@/views/doctor/Edit.vue')
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
        // ==== medicinal ====
      {
        path:'medicinalList',
        name:'Medicinal',
        component:() => import('@/views/medicinal/List')
      },
      {
        path:'addMedicinal',
        name:'AddMedicinal',
        component:() => import('@/views/medicinal/Add')
      },
      {
        path:'editMedicinal',
        name:'EditMedicinal',
        component:() => import('@/views/medicinal/Edit')
      },

        // ==== 购买单 ====
      {
        path:'receiptList',
        name:'Receipt',
        component:() => import('@/views/receipt/List')
      },
      {
        path:'addReceipt',
        name:'AddReceipt',
        component:() => import('@/views/receipt/Add')
      },
      {
        path:'editReceipt',
        name:'EditReceipt',
        component:() => import('@/views/receipt/Edit')
      }

    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
