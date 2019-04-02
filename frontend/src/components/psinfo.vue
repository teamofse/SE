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
              <input id="add1" v-model="results.user_addr" placeholder="请输入地址" :disabled="seen">
              <!--<dd id="add2">-->
                <!--哈尔滨工业大学-->
              <!--</dd>-->
                <p id="modify"><a v-on:click="changevision" >{{message}}</a></p>
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
  export default {
    name: 'psinfo',
    data: function () {
      return {
        responseResult: [],
        results: [],
        seen: true,
        message: '修改地址'
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
    modifyaddr: function () {

    },
    methods: {
      changevision: function () {
        if (this.message === '修改地址') {
          this.message = '确定'
          this.seen = false
        } else {
          this.message = '修改地址'
          this.seen = true
          console.log(this.results.user_addr)
        }
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
  #modify {
    text-align: right;
  }
  #inforegion {
    padding: 20px;
  }
</style>
