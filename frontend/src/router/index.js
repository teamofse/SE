import Vue from 'vue'
import Router from 'vue-router'
import profile from '../components/profile'
import Login from '../components/Login'
import App from '../App'
import HelloWorld from '../components/HelloWorld'
import Register from '../components/Register'
import ItemInfo from '../components/ItemInfo'
import psinfo from '../components/psinfo'
import records from '../components/records'
import commodity from '../components/commodity'
import sold from '../components/sold'
import onsale from '../components/onsale'
import home from '../components/home'
import list from '../components/list'
import publish from '../components/publish'

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
          path: '/home',
          component: home
        },
        {
          path: '/list',
          component: list
        },
        {
          path: '/Login',
          component: Login
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
          path: '/register',
          component: Register
        },
        {
          path: '/iteminfo',
          component: ItemInfo
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
