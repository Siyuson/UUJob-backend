const routes = [
    {
        name: 'Login',
        path: '/login',
        meta: {keepAlive: false},
        component: () => import('@/view/LoginRegister.vue')
    },

    // {
    //     name: 'Home',
    //     path: '/home',
    //     meta: {keepAlive: true},
    //     component: () => import('@/view/Home.vue')
    // },
    //
    // {
    //     name: 'Myspace',
    //     path: '/myspace',
    //     meta: {keepAlive: true},
    //     component: () => import('@/view/Myspace.vue'),
    //     children:[
    //     {
    //       path: '/myspace/userInfo',
    //       name: 'userInfo',
    //       component: () => import('@/components/myspace/UserInfo.vue')
    //     },
    //
    //     {
    //         path: '/myspace/historyPostList',
    //         name: 'history',
    //         component: () => import('@//components/myspace/HistoryPostList.vue')
    //       },
    //
    //       {
    //         path: '/myspace/myProfile',
    //         name: 'myProfile',
    //         component: () => import('@/components/myspace/MyProfile.vue')
    //       },
    //
    //       {
    //         path: '/myspace/sysNotice',
    //         name: 'sysNotice',
    //         component: () => import('@/components/myspace/SysNotice.vue')
    //       },
    //
    //     ]
    //
    // },
    // {
    //     name: 'FaultPage',
    //     path: '/:catchAll(.*)',
    //     component: () => import('@/view/404.vue')
    // },
    //
];

export default routes