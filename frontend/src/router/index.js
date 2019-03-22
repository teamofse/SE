import Vue from 'vue'
import Router from 'vue-router'
import login from '../components/login'
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
          path: '/login',
          component: login
        }
      ]
    }
  ]
})
