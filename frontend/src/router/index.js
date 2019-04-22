import Vue from 'vue'
import Router from 'vue-router'
import profile from '../components/profile'
import login from '../components/login'
import App from '../App'
import HelloWorld from '../components/HelloWorld'
import register from '../components/register'
import itemInfo from '../components/itemInfo'
import psinfo from '../components/psinfo'
import records from '../components/records'
import commodity from '../components/commodity'
import sold from '../components/sold'
import onsale from '../components/onsale'
import home from '../components/home'
import list from '../components/list'
import publish from '../components/publish'
import uploadfile from '../components/uploadfile'

Vue.use(Router)

export default new Router({
  mode: 'history', // 不加'history'的话要在每个路由前加#
  routes: [
    {
      path: '/',
      name: 'App',
      component: App,
      children: [
        {
          path: '/',
          redirect: '/login'
        },
        {
          path: '/home',
          component: home
        },
        {
          path: '/list',
          component: list
        },
        {
          path: '/login',
          component: login,
          meta: {
            isLogin: false
          }
        },
        {
          path: '/register',
          component: register,
          meta: {
            isLogin: false
          }
        },
        {
          path: '/publish',
          component: publish
        },
        {
          path: '/hello',
          component: HelloWorld
        },
        {
          path: '/upload',
          component: uploadfile
        },
        {
          path: '/profile',
          component: profile,
          children: [
            {
              path: '/psinfo',
              component: psinfo
            },
            {
              path: '/records',
              component: records
            },
            {
              path: '/commodity',
              component: commodity,
              children: [
                {
                  path: '/sold',
                  component: sold
                },
                {
                  path: '/onsale',
                  component: onsale
                }
              ]
            }
          ]
        },
        {
          path: '/iteminfo',
          component: itemInfo
        }
      ]
    }
  ]
})
var routes = [
  {
    path: '/psinfo',
    component: {template: '#psinfo'}
  },
  {
    path: '/records',
    component: {template: '#records'}
  },
  {
    path: '/commodity',
    component: {template: '#commodity'},
    children: [
      {
        path: '/sold',
        component: {template: '#sold'}
      },
      {
        path: '/onsale',
        component: {template: '#onsale'}
      }
    ]
  }
]
// 定义路由组件
var router = new Router({
  routes
})
// 定义路由
/* eslint-disable no-new */
new Vue({
  el: '#profile-box',
  router
})
