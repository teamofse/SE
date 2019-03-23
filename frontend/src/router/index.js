import Vue from 'vue'
import Router from 'vue-router'
import home from '../components/home'
import login from '../components/login'
import list from '../components/list'
import App from '../App'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'clogin',
      component: App,
      children: [
        {
          path: '/home',
          component: home
        },
        {
          path: '/login',
          component: login
        },
        {
          path: '/list',
          component: list
        }
      ]
    }
  ]
})
