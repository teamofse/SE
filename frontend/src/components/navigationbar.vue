<template xmlns:display="http://www.w3.org/1999/xhtml">
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <img class="logo" alt="logo" src="static/img/logo.png" />
    <h2 class="web-name">
      <strong>隔空享物</strong>
      <div class="top">
        <ul class="nav navbar-nav">
          <li>
            <a href="/home">首页</a>
          </li>
          <li>
            <a href="/list">商品</a>
          </li>
          <li :class="{'colordisplay':seenlog}">
            <a href="/login">登录</a>
          </li>
          <li :class="{'colordisplay':seenlog}">
            <a href="/register">注册</a>
          </li>
          <li :class="{'colordisplay':seen}">
            <a href="/publish">发布</a>
          </li>
          <li :class="{'colordisplay':seen}" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown">{{results.account}}<strong class="caret"></strong></a>
            <ul class="dropdown-menu">
              <li>
                <a href="/psinfo">个人信息</a>
              </li>
              <li>
                <a href="/modifypsinfo">设置</a>
              </li>
            </ul>
          </li>
          <li>
            <a href="/abouts">关于我们</a>
          </li>
        </ul>
      </div>
    </h2>
  </nav>

</template>

<script>
export default {
  name: 'NavigationBar',
  data: function () {
    return {
      responseResult: [],
      results: [],
      seen: true,
      seenlog: false
    }
  },
  mounted: function () {
    this.$axios
      .get('/queryUserById')
      .then(successResponse => {
        this.responseResult = successResponse.data
        this.results = this.responseResult
        if (this.results.account != null) {
          this.seen = false
          this.seenlog = true
        }
        // console.log(this.responseResult)
        // console.log(this.results)
      })
      .catch(failResponse => {
      })
  },
  methods: {}
}
</script>

<style scoped>
  .colordisplay {
    display: none;
  }
</style>
