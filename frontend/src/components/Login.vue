<template>
  <div class="container clogin">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-4 column">
          </div>
          <div class="col-md-4 column">
            <span style="font-size: 100px;color: #ea5445">G</span>
            <span style="font-size: 100px;color: #5bea4b">K</span>
            <span style="font-size: 100px;color: #e9ea3f">X</span>
            <span style="font-size: 100px;color: #0dd4ea">W</span>
          </div>
          <div class="col-md-4 column">
          </div>
        </div>
        <div class="row clearfix">
          <div class="col-md-4 column">
          </div>
          <div class="col-md-4 column">
            <form class="form-horizontal" role="form">
              <div class="form-group">
                <div class="col-sm-1">
                </div>
                <div class="col-sm-10">
                  <input type="text" v-model="loginInfo.account" class="form-control" id="inputEmail3" placeholder="Account"/>
                </div>
                <div class="col-sm-1">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-1">
                </div>
                <div class="col-sm-10">
                  <input type="password" v-model="loginInfo.password" class="form-control" id="inputPassword3" placeholder="Password"/>
                </div>
                <div class="col-sm-1">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-1 col-sm-8">
                  <div class="checkbox">
                    <label style="float: left"><input type="checkbox" />Remember me</label>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-1 col-sm-5">
                  <button id="login" v-on:click="login" type="submit" class="btn btn-default" >登录</button>
                </div>
                <div class="col-sm-5">
                  <button type="submit" class="btn btn-default">注册</button>
                </div>
              </div>
            </form>
          </div>
          <div class="col-md-4 column">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import qs from 'Qs'
export default {
  name: 'Login',
  data: function () {
    return {
      loginInfo: {
        account: '',
        password: ''
      },
      responseResult: []
    }
  },
  methods: {
    login () {
      this.$axios
        .post('/login', qs.stringify({
          account: this.loginInfo.account,
          password: this.loginInfo.password
        }))
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            this.$router.replace({path: '/home'})
          }
        })
        .catch(failResponse => {})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
