<template id="psinfo">
  <div class="inforegion">
    <div class="row clearfix">
          <div class="col-md-1 column">
          </div>
          <div class="col-md-10 column">
            <div class="infoborder">
            <p id="heading">个人信息</p>
            <dl class="dl-horizontal" id="perinfo">
              <div id="username">
              <dt>
                账号
              </dt>
              <dd>
                {{results.account}}
              </dd>
              </div>
              <div id="star">
              <dt>
                我的星星
              </dt>
              <dd>
                {{results.user_star}}
              </dd>
              </div>
              <div id="address">
              <dt>
                地址
              </dt>
              <input id="add1" v-model="results.user_addr" placeholder="请输入地址" :disabled="flag"/>
              <!--<dd id="add2">-->
                <!--哈尔滨工业大学-->
              <!--</dd>-->
                <p class="modify"><a v-on:click="changevision" :class="{'colordisplay':modify}">修改地址</a></p>
                <p class="modify"><a v-on:click="modifyaddr" :class="{'colordisplay':commit}">确定</a></p>
              </div>
            </dl>
          </div>
          <div class="col-md-1 column">
          </div>
          </div>
        </div>
  </div>
</template>

<script>
  import qs from 'Qs'
  export default {
    name: 'psinfo',
    data: function () {
      return {
        responseResult: [],
        results: [],
        flag: true,
        modify: false,
        commit: true
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
      changevision: function () {
        if (this.flag === true) {
          this.flag = false
          this.modify = true
          this.commit = false
        }
      },
      modifyaddr: function () {
        // console.log(this.modifyInfo.user_addr)
        this.$axios
          .put('/updateAddrs', qs.stringify({
            account: this.results.account,
            user_addr: this.results.user_addr
          }), {headers: {
              'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
            }})
          .then(successResponse => {
            // console.log(this.modifyInfo.user_addr)
            // console.log(successResponse.data)
            this.responseResult = JSON.stringify(successResponse.data)
            // console.log(this.responseResult)
            if (successResponse.data.code === 200) {
              this.$router.replace({path: '/psinfo'})
              console.log(successResponse.data.data)
            }
          })
          .catch(failResponse => {
            // console.log(this.modifyInfo.user_addr)
          })
        this.flag = true
        this.modify = false
        this.commit = true
      }
    }
  }
</script>

<style scoped>
  #perinfo {
    border-top: 2px solid #737373;
    padding-top: 20px;
}
  #heading {
    text-align: right;
  }
  .infoborder {
    margin-top: 20px;
  }
  #username {
    padding: 10px;
  }
  #star {
    padding: 10px;
  }
  #address {
    padding: 10px;
  }
  #add2 {
    margin-top: 10px;
  }
  .modify {
    text-align: right;
  }
  #inforegion {
    padding: 20px;
  }

  .colordisplay {
    display: none;
  }
</style>
