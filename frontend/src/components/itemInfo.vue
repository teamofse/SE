<template id="itembar0">
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="row clearfix" >
      <div class="col-md-12 column">
        <div class="row clearfix shadow" style="padding-bottom:20px; background-color: #fafafa">
          <div class="col-md-1 column">
          </div>
          <div class="col-md-10 column">
            <div class="row clearfix" style="margin-top: 10px">
              <div class="col-md-6 column">
                <img style="height:300px;width: 400px" src="/api/img/itemid1.jpg"/>
              </div>
              <div class="col-md-6 column">
                <h2 style="float: left;display: inline-block;clear:left;">{{results.goods_name}}</h2>
                <div style="width: 100%;float: left;clear:left;">
                  <span style="float: left;display: inline-block">&nbsp;&nbsp;&nbsp;&nbsp;</span>
                  <p>{{results.goods_detail}}</p>
                </div>
                <div style="width: 100%;float: left;clear:left;">
                  <span style="float: left;display: inline-block;">简介</span>
                  <span style="float: left;display: inline-block">&nbsp;&nbsp;&nbsp;&nbsp;</span>
                  <p>{{results.goods_detail}}</p>
                </div>
                <div style="float: left;clear:left;">
                  <span style="float: left;">价格</span>
                  <span style="float: left;">&nbsp;&nbsp;&nbsp;&nbsp;</span>
                  <span style="color:red">¥{{results.price}}</span>
                </div>
                <div style="width: 100%;float: left;clear:left;">
                  <span style="float:left">您的地址</span>
                </div>
                <div style="width: 100%;float: left;clear:left;">
                  <input type="text" class="form-control" placeholder="省"/>
                </div>
                <div style="width: 100%;float: left;clear:left;">
                  <input type="text" class="form-control" placeholder="市"/>
                </div>
                <div style="width: 100%;float: left;clear:left;">
                  <input type="text" class="form-control" placeholder="详细地址"/>
                </div>
                <div style="float: left;clear:left;margin-top: 10px">
                  <button v-on:click="clickedBuyingButton" style="float: left;clear: left;margin-left: 0" class="btn">购买</button>
                </div>
                <div style="float: left;clear:left;margin-top: 10px">

                </div>
              </div>
            </div>
          </div>
          <div class="col-md-1 column">
          </div>
        </div>

        <div class="row clearfix shadow" style="margin-top:10px; padding-bottom:20px; background-color: #fafafa">
          <div class="col-md-2 column">
          </div>
          <div class="col-md-8 column" style="margin-top: 5px">
            <p>给商家留言</p>
          </div>
          <div class="col-md-2 column">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import qs from 'Qs'
import NavigationBar from './navigationbar'
export default {
  name: 'ItemInfo',
  components: { NavigationBar },
  data: function () {
    return {
      itemInfo: {
        itemId: '',
        isLogin: this.$store.isLogin
      },
      styleObject: {
      },
      responseResult: [],
      results: [],
      addr: []
    }
  },
  mounted: function () {
    this.itemInfo.itemId = this.$route.query.itemid
    console.log(this.itemInfo.itemId)
    this.$axios
      .get('/getiteminfopage', {
        params: {
          itemId: this.itemInfo.itemId
        }
      }, {headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }})
      .then(successResponse => {
        this.responseResult = successResponse.data
        this.results = this.responseResult
      })
      .catch(failResponse => {
        alert(this.$router.params.itemid)
      })
    this.$axios
      .get('/getiteminfopage', {
        params: {
          itemId: this.itemInfo.itemId
        }
      }, {headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }})
      .then(successResponse => {
        this.responseResult = successResponse.data.data
        this.results = this.responseResult
      })
      .catch(failResponse => {
        alert(this.$router.params.itemid)
      })
  },
  methods: {
    clickedBuyingButton () {
      console.log('@@@@@@@' + this.itemInfo.itemId)
      this.$axios
        .post('/buying', qs.stringify({
          itemid: this.itemInfo.itemId,
          user_addr_pro: 'Fujian',
          user_addr_city: 'Zhaoan',
          user_addr_det: 'Bushang'
        }), {headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
          }})
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            alert('ok')
          }
        })
        .catch(err => {
          this.$message.error(err)
        })
    }
  }
}
</script>

<style scoped>
  .shadow{
    -webkit-box-shadow: 0 1px 5px 0 rgba(0,34,77,.12);
    -moz-box-shadow: 0 1px 5px 0 rgba(0,34,77,.12);
    box-shadow: 0 1px 5px 0 rgba(0,34,77,.12);
  }
</style>
