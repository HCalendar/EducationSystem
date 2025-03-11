import { createRouter, createWebHistory } from 'vue-router'


const routes = [
    {
        path:'/',
        name:'HomePage',
        component:() => import('@/views/Home.vue')
    },
    {
        path: '/DuJuHuiYan',
        name: 'DuJuHuiYan',
        component:()=> import('@/views/djhy.vue')
    },
    {
        path:'/BaiDuBuQin',
        name:'BaiDuBuQin',
        component:()=>import('@/views/bdbq.vue')
    },
    {
        path:'/GuShiJieMa',
        name:'GuShiJieMa',
        component:()=>import('@/views/gsjm.vue')
    },
    {
        path:'/studentEmail',
        name:'studentEmail',
        component:()=>import('@/views/studentEmail.vue')
    },
    {
        path:'/policeEmail',
        name:'policeEmail',
        component:()=>import('@/views/policeEmail.vue')
    },
    {
        path:'/questionnaire',
        name:'questionnaire',
        component:()=>import('@/views/questionnaire.vue')
    },
    {
        path:'/comment',
        name:'comment',
        component:()=>import('@/views/comment.vue')
    },
    {
        path: '/manage',
        name: 'manage',
        component: () => import('@/views/manage.vue'), // 父组件
        children: [
            {
                path: 'showData',
                name: 'ShowData',
                component: () => import('@/views/showData.vue'),
            },
            {
                path: 'showComment',
                name: 'ShowComment',
                component: () => import('@/views/showComment.vue'),
            },
        ],
    },
    ]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
