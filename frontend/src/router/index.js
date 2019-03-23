import Vue from 'vue'
import Router from 'vue-router'
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
          path: '/login',
          component: Login
        },
        {
          path: '/hello',
          component: HelloWorld
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
