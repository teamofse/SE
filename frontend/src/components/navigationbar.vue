<template xmlns:display="http://www.w3.org/1999/xhtml">
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <img class="logo" alt="logo" src="static/img/logo.png" />
    <h2 class="web-name">
      <strong>隔空享物</strong>
      <div class="top">
        <ul class="nav navbar-nav">
          <li>
            <a href="#">首页</a>
          </li>
          <li>
            <a href="#">商品</a>
          </li>
          <li>
            <a href="#">关于我们</a>
          </li>
          <li>
            <a v-if="!isLogin" href="/login">登录</a>
          </li>
          <li>
            <a v-if="!isLogin" href="/register">注册</a>
          </li>
          <li>
            <a v-if="isLogin" href="/psinfo">我的</a>
          </li>
        </ul>
      </div>
    </h2>
  </nav>

</template>

<script>
import {mapState} from 'vuex'
import loginStatus from '../store/modules/loginStatus'
export default {
  name: 'NavigationBar',
  data: function () {
    return {
    }
  },
  computed: {
    ...mapState('loginStatus', [
      'isLogin'
    ]),
    isLogin () {
      return loginStatus.state.isLogin
    }
  }
}
</script>

<style scoped>
.isDisplay{
  display: none;
}
</style>
