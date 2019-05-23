<template>
  <div class="container">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-4 column">
          </div>
          <div class="col-md-4 column">
            <span style="font-size: 60px;font-family: 'Microsoft JhengHei'">注</span>
            <span style=""></span>
            <span style="font-size: 60px;font-family: 'Microsoft JhengHei'">册</span>
          </div>
          <div class="col-md-4 column">
          </div>
        </div>
      </div>
    </div>
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-4 column">
          </div>
          <div class="col-md-4 column">
            <form class="form-horizontal" role="form">
              <div class="form-group">
                <div class="col-sm-1">
                </div>
                <div class="col-sm-10">
                  <input type="text" v-on:keypress="checkForm" v-model="userInfo.account" class="form-control" id="inputEmail1" placeholder="账号"/>
                </div>
                <div class="col-sm-1">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-1">
                </div>
                <div class="col-sm-10">
                  <input type="text" v-on:keypress="checkForm" v-model="userInfo.telephone" class="form-control" id="inputEmail2" placeholder="手机号码"/>
                </div>
                <div class="col-sm-1">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-1">
                </div>
                <div class="col-sm-10">
                  <input type="password" v-on:keypress="checkForm" v-model="userInfo.password" class="form-control" id="inputPassword1" placeholder="密码"/>
                </div>
                <div class="col-sm-1">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-1">
                </div>
                <div class="col-sm-10">
                  <input type="password" v-on:keypress="checkForm" v-model="userInfo.password2" class="form-control" id="inputPassword2" placeholder="再次输入密码"/>
                </div>
                <div class="col-sm-1">
                </div>
              </div>
              <span id="tips" v-bind:style="styleObject.tips">{{userInfo.tipsInfo}}</span>
              <div class="form-group">
                <div class="col-sm-offset-1 col-sm-5">
                  <button type="submit" v-on:click="checkForm" class="btn btn-default" >注册</button>
                </div>
                <div class="col-sm-5">
                  <button type="submit" v-on:click="toLogin" class="btn btn-default">登录</button>
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
import NavigationBar from './navigationbar'
import qs from 'Qs'
export default {
  name: 'register',
  components: { NavigationBar },
  data: function () {
    return {
      userInfo: {
        account: '',
        password: '',
        password2: '',
        telephone: '',
        tipsInfo: ''
      },
      styleObject: {
        tips: {
          color: 'green'
        }
      },
      responseResult: []
    }
  },
  methods: {
    checkForm () {
      if (this.userInfo.account === '') {
        this.userInfo.tipsInfo = '请输入用户名!'
      } else if (this.userInfo.telephone === '') {
        this.userInfo.tipsInfo = '请输入电话!'
      } else if (this.userInfo.password === '') {
        this.userInfo.tipsInfo = '请输入密码!'
      } else if (this.userInfo.password2 === '' || this.userInfo.password !== this.userInfo.password2) {
        this.userInfo.tipsInfo = '两次输入密码不一致'
      } else {
        this.userInfo.tipsInfo = 'It\'s OK!'
        this.styleObject.tips.color = 'green'
      }
    },
    register () {
      this.$axios
        .post('/register', qs.stringify({
          account: this.userInfo.account,
          telephone: this.userInfo.telephone,
          password: this.userInfo.password
        }), {headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
          }})
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            alert('注册成功!')
            this.$router.replace({path: '/login'})
            console.log(successResponse.data.data)
          } else if (successResponse.data.code === 400) {
            if (successResponse.data.data === '注册失败，详细信息[用户名或密码为空]。') {
              alert(successResponse.data.data)
            }
          }
        })
        .catch(failResponse => {})
    },
    toLogin () {
      this.$router.push({path: '/login?account=' + this.userInfo.account})
    }
  }
}
</script>

<style scoped>

</style>
