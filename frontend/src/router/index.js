import Vue from 'vue'
import Router from 'vue-router'
import login from '../components/login'
import App from '../App'
import HelloWorld from '../components/HelloWorld'
import register from '../components/register'

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
          component: login
        },
        {
          path: '/hello',
          component: HelloWorld
        },
        {
          path: '/register',
          component: register
        }
      ]
    }
  ]
})
