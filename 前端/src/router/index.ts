import { createRouter, createWebHistory, RouteRecordRaw} from "vue-router";

const routes:Array<RouteRecordRaw> = [
    {
        path:"/",
        name:"login",
        component: () => import("../views/login.vue"),
    },
    {
        path:"/home",
        name: "home",
        component: () => import("../views/home.vue"),
        children: [
            {
                path:"/home/file",
                component: () => import("../views/file.vue"),
                name:"file",
            },
            {
                path:"/home/user",
                component: () => import("../views/user.vue"),
                name:"user",
            },
            {
                path:"/home/code",
                component: () => import("../views/code.vue"),
                name:"code",
            },
            {
                path:"/home/submit",
                component: () => import("../views/submit.vue"),
                name:"submit",
            },
            {
                path:"/home/view",
                component: () => import("../views/view.vue"),
                name:"view",
            },
        ]
    },
    
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})

export default router