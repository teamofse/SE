<template>
  <div class="list">
    <navigation-bar></navigation-bar>
    <div class="row clearfix">
      <div class="col-md-12 column">

        <!--header-->

        <!--body-->
        <!--幻灯片-->
        <div class="carousel slide" id="carousel-134833">
          <ol class="carousel-indicators">
            <li class="active" data-slide-to="0" data-target="#carousel-134833">
            </li>
            <li data-slide-to="1" data-target="#carousel-134833">
            </li>
            <li data-slide-to="2" data-target="#carousel-134833">
            </li>
          </ol>
          <div class="carousel-inner">
            <div class="item active">
              <img class="zyl" alt="zyl" src="../assets/zyl1.png" />
              <div class="carousel-caption">
                <h4>
                  First Thumbnail label
                </h4>
                <p>
                  Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                </p>
              </div>
            </div>
            <div class="item">
              <img class="zyl" alt="zyl" src="../assets/zyl2.png" />
              <div class="carousel-caption">
                <h4>
                  Second Thumbnail label
                </h4>
                <p>
                  Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                </p>
              </div>
            </div>
            <div class="item">
              <img class="zyl" alt="zyl" src="../assets/zyl3.png" />
              <div class="carousel-caption">
                <h4>
                  Third Thumbnail label
                </h4>
                <p>
                  Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                </p>
              </div>
            </div>
          </div>
          <a class="left carousel-control" href="#carousel-134833" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
          <a class="right carousel-control" href="#carousel-134833" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
        </div>

        <div class="sort">
          <text>全部</text>
          <text>女装</text>
        </div>

        <!--商品列表-->
        <div class="goods">
          <div class="col-md-4" v-for="result in responseAll" :key="result" v-on:click="addHot(result.goods_id, result.hot)">
            <div class="thumbnail">
              <img class="image" alt="1" src="../assets/1.jpg" />
              <div class="intro">
                <p class="title" align="left">
                  <strong>{{result.goods_name}}</strong>
                </p>
                <div class="money-row">
                  <img class="star" alt="star" src="../assets/star.png" align="left"/>
                  <p class="money"><strong>{{result.price}}</strong></p>
                  <p class="hot"><strong>点击量：{{result.hot}}</strong></p>
                </div>
                <hr class="line" />
                <span class="name-city-row">
                  <p class="name" align="left"><strong>{{result.user_name}}</strong></p>
                  <p class="city" align="right"><strong>{{result.user_addr_city}}</strong></p>
                </span>
              </div>
            </div>
          </div>
        </div>

        <!--查看更多-->
          <router-link
            class="more-link" to="/list">
              <p class="more-word">查看更多 >></p>
          </router-link>

      </div>
    </div>
    <App-footer></App-footer>
  </div>

</template>

<script>
  import NavigationBar from './navigationbar'
  import AppFooter from './footer'
import qs from 'Qs'
export default {
  name: 'home',
  components: {
    NavigationBar,
    AppFooter
  },
  data: function () {
    return {
      responseResult: [], // goods_information表
      responseResultUser: [], // users表
      responseResultClass: [], // goods_class表
      results: [], // 冒泡排序后的goods_information表
      responseAll: [] // 连接三个表
      // newList: {}
    }
  },
  mounted: function () {
    this.$axios
      .get('/queryGoodsInformationById')
      .then(successResponse => {
        this.responseResult = successResponse.data
        // console.log(this.responseResult)
        this.results = this.bubbleSort(this.responseResult)
        // console.log('goods')
        // console.log(this.results)
        this.$axios // 返回users表所有内容
          .get('/queryAllUsers')
          .then(successResponse => {
            this.responseResultUser = successResponse.data
            // console.log('users')
            // console.log(this.responseResultUser)
            this.$axios // 返回goods_class表所有内容
              .get('/queryGoodsClass')
              .then(successResponse => {
                this.responseResultClass = successResponse.data
                // console.log('class')
                // console.log(this.responseResultClass)
                for (var i = 0; i < this.results.length; i++) {
                  this.responseAll[i] = this.results[i]
                  // console.log(this.responseAll[i])
                  for (var j = 0; j < this.responseResultUser.length; j++) {
                    if (this.responseAll[i].user_id === this.responseResultUser[j].id) {
                      this.responseAll[i].user_name = this.responseResultUser[j].account
                      this.responseAll[i].user_addr_city = this.responseResultUser[j].user_addr_city
                      break
                    }
                  }
                  for (var k = 0; k < this.responseResultClass.length; k++) {
                    if (this.responseAll[i].class_id === this.responseResultClass[k].class_id) {
                      this.responseAll[i].class_name = this.responseResultClass[k].class_name
                      break
                    }
                  }
                }
                // console.log(this.responseAll[0])
                // console.log(this.responseAll[1])
                // console.log(this.responseAll[2])
                // console.log(this.responseAll[3])
                // console.log(this.responseAll[4])
              })
              .catch(failResponse => {
              })
          })
          .catch(failResponse => {
          })
      })
      .catch(failResponse => {
      })
  },
  methods: {
    // 冒泡排序，热度大的排前面
    bubbleSort: function (arr) {
      var len = arr.length
      for (var i = 0; i < len; i++) {
        for (var j = 0; j < len - 1 - i; j++) {
          if (arr[j].hot < arr[j + 1].hot) { // 相邻元素两两对比
            var temp = arr[j + 1]// 元素交换
            arr[j + 1] = arr[j]
            arr[j] = temp
          }
        }
      }
      return arr
    },
    addHot: function (id, hot) {
      var newId = id
      var newHot = hot + 1
      this.$axios
        .put('/updateGoodsInformation', qs.stringify({
          id: newId,
          hot: newHot
        }), {headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
          }})
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            this.$router.push({path: '/itemInfo?itemid=id'})
            console.log(successResponse.data.data)
          }
        })
        .catch(failResponse => {
        })
    }
  // 监听路由，每次进入都要从后台获取新数据。init方法即为每次进入此页面都需要执行的方法，请求数据的方法也在里面。
  // watch: {
  //   "$route": {
  //     handler(route){
  //       const that = this
  //       if(route.name==='home'){
  //         that.init()
  //       }
  //     },
  //     deep: true
  //   }
  // }
  }
}
</script>

<style scoped>
  .carousel-inner {
    height: 400px;
  }
  .col-md-12 column {
    height: 100%;
  }
  .zyl {
    width: 100%;
    height: 400px;
  }
  .sort {
    float: left;
  }
  .goods {
    padding-bottom: 100px;
    width: 100%;
    margin-left: 100px;
  }
  .col-md-4 {
    height: 400px;
    width:28%;
    margin-top: 50px;
  }
  .thumbnail {
    height: 400px;
  }
  .image {
    width: fit-content;
    height: 250px;
  }
  .intro {
    margin-left: 30px;
    margin-right: 30px;
    margin-top: 20px;
  }
  .title {
    font-size: 20px;
    margin: 0px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .star {
    width: 30px;
    height: 30px;
    margin-left: -5px;
  }
  .money {
    margin-left: 15px;
    font-size: 15px;
    line-height: 30px;
    float: left
  }
  .hot {
    font-size: 15px;
    line-height: 30px;
    margin-right: -150px;
  }
  .line {
    height: 2px;
    border: none;
    border-top:1px solid black;
    margin: 0px;
  }
  .name {
    width: 45%;
    float: left;
    font-size: 15px;
    margin-top: 10px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .city {
    width: 45%;
    float: right;
    font-size: 15px;
    margin-top: 10px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
  .more-link {
    display: block;
  }
  .more-word {
    width: 90px;
    margin-right: 20px;
    position: absolute;
    bottom: 20px;
    right: 60px;
  }
  .footer-img {
    margin-top: 50px;
    width: 100%;
    height: 250px;
  }
</style>
