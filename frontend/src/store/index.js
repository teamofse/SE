import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const state = { // 要设置的全局访问的state对象
  isLogin: false,
  showFooter: true,
  changableNum: 0
}
const getters = { // 实时监听state值的变化(最新状态)
  isLogin (state) { // 承载变化的showFooter的值
    return state.isLogin
  },
  isShow (state) {
    return state.showFooter
  },
  getChangedNum () {
    return state.changableNum
  }
}
const mutations = {
  login (state) { // 自定义改变state初始值的方法，这里面的参数除了state之外还可以再传额外的参数(变量或对象);
    state.isLogin = true
  },
  show (state) {
    state.showFooter = true
  },
  hide (state) {
    state.showFooter = false
  },
  newNum (state, sum) {
    state.changableNum += sum
  }
}
const actions = {
  toLogin (context) { // 同上注释
    context.commit('login')
  },
  hideFooter (context) { // 自定义触发mutations里函数的方法，context与store 实例具有相同方法和属性
    context.commit('hide')
  },
  showFooter (context) { // 同上注释
    context.commit('show')
  },
  getNewNum (context, num) { // 同上注释，num为要变化的形参
    context.commit('newNum', num)
  }
}

const store = new Vuex.Store({
  state,
  getters,
  mutations,
  actions
})

export default store
