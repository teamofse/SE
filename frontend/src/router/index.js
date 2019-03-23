import Vue from 'vue'
import Router from 'vue-router'
import login from '../components/login'
import profile from '../components/profile'
import info from '../components/info'
import records from '../components/records'
import home from '../components/home'
import list from '../components/list'
import Login from '../components/Login'
import App from '../App'
import HelloWorld from '../components/HelloWorld'
import Register from '../components/Register'
import ItemInfo from '../components/ItemInfo'

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
          path: '/hello',
          component: HelloWorld
        },
        {
          path: '/profile',
          component: profile
        },
        {
          path: '/info',
          component: info
        },
        {
          path: '/records',
          component: records
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
