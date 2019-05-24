<template>
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="row clearfix block-sub-banner">
      <div class="block-sub-banner-min-container wrap">
        <span class="title">账户设置</span>
        <span class="content">修改账户的基本信息</span>
      </div>
    </div>
    <div class="form-container">
    <div class="row clearfix form">
      <div class="col-md-12 column">
        <!--<form role="form">-->
          <div id="username" class="form-element">
            <!--<label for="exampleInputEmail1">账号</label>-->
            <label class="form-label">
              账号
            </label>
            <input v-model="results.account" class="input" disabled>
            <!--<input type="email" class="form-control" id="exampleInputEmail1" v-model="results.user_addr" placeholder="请输入地址" :disabled="flag"/>-->
          </div>
          <div id="telnum" class="form-element">
            <label class="form-label">电话</label>
            <input v-model="results.user_tel" class="input"/>
          </div>
          <div id="addr1" class="form-element">
            <label class="form-label">省份</label>
            <input v-model="results.user_addr_pro" class="input"/>
          </div>
          <div id="addr2" class="form-element">
            <label class="form-label">城市</label>
            <input v-model="results.user_addr_city" class="input"/>
          </div>
          <div id="addr3" class="form-element">
            <label class="form-label">详细地址</label>
            <input v-model="results.user_addr_det" class="input"/>
          </div>
        <!--<button type="submit" class="btn btn-default"><a v-on:click="modifyaddr">提交</a></button>-->
            <div class="form-element">
              <span class="modify btn btn-normal" v-on:click="modifyaddr">保存</span>
              <span class="btn btn-normal">取消</span>
            </div>
        <!--</form>-->
      </div>
    </div>
    <div class="row clearfix form">
      <div class="col-md-12 column">
        <!--<form role="form">-->
        <div id="oldpsw" class="form-element">
          <label class="form-label">旧密码</label>
            <input v-model="oldpsw" type="password" class="input"/>
        </div>
        <div id="newpsw" class="form-element">
          <label class="form-label">新密码</label>
            <input v-model="newpsw" type="password" class="input"/>
        </div>
        <div id="confirmnewpsw" class="form-element">
          <label class="form-label">确认密码</label>
            <input v-model="confirmnewpsw" type="password" class="input"/>
        </div>
        <!--<button type="submit" class="btn btn-default"><a v-on:click="modifyaddr">提交</a></button>-->
        <div class="form-element"><span class="modify btn btn-normal" v-on:click="modifypsw">修改密码</span></div>
        <!--</form>-->
      </div>
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
  .block-sub-banner {
    position: relative;
  }
  .block-sub-banner {
    /*background: #090723;*/
    /*position: absolute;*/
    width: 100%;
    height: 100%;
    left: 0;
    top: -10px;
    /*padding-top: 55px;*/
    overflow: hidden;
  }
  .block-sub-banner, .block-sub-banner-min-container {
    height: 100px;
    position: relative;
    margin: 0 auto;
    box-sizing: border-box;
    padding-top: 30px;
    padding-left: 10px;
    /*text-align: left;*/
  }
  .block-sub-banner-min-container, .title {
    font-size: 22px;
    color: #000000;
    vertical-align: baseline;
    display: inline-block;
  }
  .block-sub-banner .block-sub-banner-min-container .content {
    font-size: 12px;
    color: #000000;
    margin-left: 10px;
    vertical-align: baseline;
    display: inline-block;
  }
  .wrap {
    width: 1160px!important;
    margin: 0 auto;
  }
  .form-container, form-element, .input {
    width: 318px;
    height: 36px;
    background-color: #fff;
    border-radius: 5px;
  }

  .input{
    color: #333;
    font-size: 12px;
    height: 32px;
    line-height: 32px!important;
    padding: 6px 9px;
    border-width: 1px;
    border-style: solid;
    border-color: #e6e6e6;
    background-color: #fff;
    border-radius: 4px;
    box-sizing: border-box;
    vertical-align: middle;
    cursor: auto;
    border-image: initial;
    display: inline-block;
    text-align: start;
  }
  .input:focus {
    border-color: red;
    outline: 0;
  }
  .input:hover {
    border-color: #ccc;
  }
  .form-label {
    display: block;
    font-size: 12px;
    color: #999;
    cursor: text;
    width: 80px;
    position: absolute;
    left: 0;
    top: 18px;
  }
  .form, .form-element {
    margin-bottom: 30px;
    padding-left: 80px;
    position: relative;
  }
  .form, .form-container{
    padding: 20px 0 0 20px;
  }
  .form-container {
    width: 500px;
    margin: 0 auto;
  }
  div {
    display: block;
  }
  .btn {
    display: inline-block;
    padding: 0 20px;
    height: 32px;
    line-height: 30px;
    border: 1px solid transparent;
    border-radius: 4px;
    color: #999;
    text-align: center;
    white-space: nowrap;
    touch-action: manipulation;
    cursor: pointer;
    user-select: none;
    background-image: none;
    box-sizing: border-box;
    font-size: 12px;
    vertical-align: middle;
  }
  .btn-normal {
    background-color: #ddd;
    color: #333;
    border-radius: 40px;
  }
  span {
    margin-right: 50px;
  }
</style>
