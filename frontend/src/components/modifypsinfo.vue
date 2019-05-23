<template>
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="row clearfix">
      <div class="col-md-12 column">
        <!--<form role="form">-->
          <div id="username">
            <!--<label for="exampleInputEmail1">账号</label>-->
            <dt>
              账号
            </dt>
            <dd>
              {{results.account}}
            </dd>
            <!--<input type="email" class="form-control" id="exampleInputEmail1" v-model="results.user_addr" placeholder="请输入地址" :disabled="flag"/>-->
          </div>
          <div id="telnum">
            <dt>电话</dt>
            <dd><input v-model="results.user_tel"/></dd>
          </div>
          <div id="addr1">
            <dt>省份</dt>
            <dd><input v-model="results.user_addr_pro"/></dd>
          </div>
          <div id="addr2">
            <dt>城市</dt>
            <dd><input v-model="results.user_addr_city"/></dd>
          </div>
          <div id="addr3">
            <dt>详细地址</dt>
            <dd><input v-model="results.user_addr_det"/></dd>
          </div>
        <!--<button type="submit" class="btn btn-default"><a v-on:click="modifyaddr">提交</a></button>-->
            <p class="modify"><a v-on:click="modifyaddr">修改个人信息</a></p>
        <!--</form>-->
      </div>
    </div>
    <div class="row clearfix">
      <div class="col-md-12 column">
        <!--<form role="form">-->
        <div id="oldpsw">
          <dt>旧密码：</dt>
          <dd><label>
            <input v-model="oldpsw" type="password"/>
          </label></dd>
        </div>
        <div id="newpsw">
          <dt>新密码：</dt>
          <dd><label>
            <input v-model="newpsw" type="password"/>
          </label></dd>
        </div>
        <div id="confirmnewpsw">
          <dt>确认密码：</dt>
          <dd><label>
            <input v-model="confirmnewpsw" type="password"/>
          </label></dd>
        </div>
        <!--<button type="submit" class="btn btn-default"><a v-on:click="modifyaddr">提交</a></button>-->
        <p class="modify"><a v-on:click="modifypsw">确认修改密码</a></p>
        <!--</form>-->
      </div>
    </div>
  </div>
</template>

<script>
  import NavigationBar from './navigationbar'
  import qs from 'Qs'
  export default {
    name: 'modifypsinfo',
    components: {NavigationBar},
    data: function () {
      return {
        responseResult: [],
        results: [],
        oldpsw: '',
        newpsw: '',
        confirmnewpsw: ''
      }
    },
    mounted: function () {
      this.$axios
        .get('/queryUserById')
        .then(successResponse => {
          this.responseResult = successResponse.data
          this.results = this.responseResult
          // console.log(this.responseResult)
          // console.log(this.results)
        })
        .catch(failResponse => {
        })
    },
    methods: {
      modifyaddr: function () {
        // console.log(this.modifyInfo.user_addr)
        this.$axios
          .post('/updateAddrs', qs.stringify({
            account: this.results.account,
            user_addr_pro: this.results.user_addr_pro,
            user_addr_city: this.results.user_addr_city,
            user_addr_det: this.results.user_addr_det
          }), {headers: {
              'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
            }})
          .then(successResponse => {
            // console.log(this.modifyInfo.user_addr)
            // console.log(successResponse.data)
            this.responseResult = JSON.stringify(successResponse.data)
            // console.log(this.responseResult)
            if (successResponse.data.code === 200) {
              this.$router.push({path: '/psinfo'})
              console.log(successResponse.data.data)
            }
          })
          .catch(failResponse => {
            // console.log(this.modifyInfo.user_addr)
          })
      },
      modifypsw: function () {
        // console.log(this.modifyInfo.user_addr)
        this.$axios
          .post('/updatePsw', qs.stringify({
            account: this.results.account,
            oldpsw: this.oldpsw,
            newpsw: this.newpsw,
            confirmnewpsw: this.confirmnewpsw
          }), {headers: {
              'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
            }})
          .then(successResponse => {
            // console.log(this.modifyInfo.user_addr)
            // console.log(successResponse.data)
            this.responseResult = JSON.stringify(successResponse.data)
            // console.log(this.responseResult)
            if (successResponse.data.code === 200) {
              this.$router.push({path: '/psinfo'})
              console.log(successResponse.data.data)
            }
          })
          .catch(failResponse => {
            // console.log(this.modifyInfo.user_addr)
          })
      }
    }
  }
</script>

<style scoped>
  #username, #telnum, #addr1, #addr2, #addr3, #oldpsw, #newpsw, #confirmnewpsw {
    padding: 10px;
  }
</style>
