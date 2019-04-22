
const state = { // 要设置的全局访问的state对象
  isLogin: false
}
const getters = { // 实时监听state值的变化(最新状态)
  getLogin (state) { // 承载变化的showFooter的值
    return state.isLogin
  }
}
const mutations = {
  login (state) { // 自定义改变state初始值的方法，这里面的参数除了state之外还可以再传额外的参数(变量或对象);
    state.isLogin = true
  },
  logout (state) {
    state.isLogin = false
  }
}
const actions = {
  toLogin (context) { // 同上注释
    context.commit('login')
  },
  tologout (context) {
    context.commit('logout')
  }
}

export default {
  namespace: true,
  state,
  getters,
  mutations,
  actions
}
