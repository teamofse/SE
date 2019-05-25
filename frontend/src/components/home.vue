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
              <img class="zyl" alt="zyl" src="../assets/e.jpg" />
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
              <img class="zyl" alt="zyl" src="../assets/g.jpg" />
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
              <img class="zyl" alt="zyl" src="../assets/k.jpg" />
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
          <div class="sort_item">
            <p class="sort_all" style="color: red" v-on:click="find_class(0)" v-if="flag === true">全部</p>
            <p class="sort_all" v-on:click="find_class(0)" v-if="flag === false">全部</p>
            <p class="sort_nv" style="color: red" v-on:click="find_class(1)" v-if="results[0].class_id === 1 && flag === false">女装</p>
            <p class="sort_nv" v-on:click="find_class(1)" v-if="results[0].class_id !== 1 || flag === true">女装</p>
            <p class="sort_nan" style="color: red" v-on:click="find_class(2)" v-if="results[0].class_id === 2 && flag === false">男装</p>
            <p class="sort_nan" v-on:click="find_class(2)" v-if="results[0].class_id !== 2 || flag === true">男装</p>
            <p class="sort_mu" style="color: red" v-on:click="find_class(3)" v-if="results[0].class_id === 3 && flag === false">母婴</p>
            <p class="sort_mu" v-on:click="find_class(3)" v-if="results[0].class_id !== 3 || flag === true">母婴</p>
            <p class="sort_mei" style="color: red" v-on:click="find_class(4)" v-if="results[0].class_id === 4 && flag === false">美妆</p>
            <p class="sort_mei" v-on:click="find_class(4)" v-if="results[0].class_id !== 4 || flag === true">美妆</p>
            <p class="sort_jia" style="color: red" v-on:click="find_class(5)" v-if="results[0].class_id === 5 && flag === false">家居家纺</p>
            <p class="sort_jia" v-on:click="find_class(5)" v-if="results[0].class_id !== 5 || flag === true">家居家纺</p>
            <p class="sort_shu" style="color: red" v-on:click="find_class(6)" v-if="results[0].class_id === 6 && flag === false">数码家电</p>
            <p class="sort_shu" v-on:click="find_class(6)" v-if="results[0].class_id !== 6 || flag === true">数码家电</p>
            <p class="sort_shou" style="color: red" v-on:click="find_class(7)" v-if="results[0].class_id === 7 && flag === false">手表配饰</p>
            <p class="sort_shou" v-on:click="find_class(7)" v-if="results[0].class_id !== 7 || flag === true">手表配饰</p>
            <p class="sort_nei" style="color: red" v-on:click="find_class(8)" v-if="results[0].class_id === 8 && flag === false">男女内衣</p>
            <p class="sort_nei" v-on:click="find_class(8)" v-if="results[0].class_id !== 8 || flag === true">男女内衣</p>
            <p class="sort_xie" style="color: red" v-on:click="find_class(9)" v-if="results[0].class_id === 9 && flag === false">鞋包</p>
            <p class="sort_xie" v-on:click="find_class(9)" v-if="results[0].class_id !== 9 || flag === true">鞋包</p>
            <p class="sort_wu" style="color: red" v-on:click="find_class(10)" v-if="results[0].class_id === 10 && flag === false">生活小物</p>
            <p class="sort_wu" v-on:click="find_class(10)" v-if="results[0].class_id !== 10 || flag === true">生活小物</p>
          </div>
        </div>

        <!--商品列表-->
        <div class="goods">
          <div class="col-md-4" v-for="result in results" :key="result" >
            <div class="thumbnail">
              <img class="image" alt="1" v-bind:src="result.imgpath" v-on:click="addHot(result.goods_id, result.hot)"/>
              <!--<img class="image" alt="1" v-bind:src="/api/img/itemid{{result.goods_picture_1}}" v-on:click="addHot(result.goods_id, result.hot)"/>-->
              <div class="intro">
                <span class="title">
                  <p class="goods_name" align="left"><strong>{{result.goods_name}}</strong></p>
                  <p class="store" align="right" v-on:click="goodStore(result.goods_id)">收藏</p>
                </span>
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
      flag: true,
      responseResult: [], // goods_information表
      responseResultUser: [], // users表
      responseResultClass: [], // goods_class表
      results: [], // 冒泡排序后的goods_information表 用来显示
      responseAll: [], // 连接三个表
      resultsClass: [], // 点击分类
      responseLike: [] // 收藏
      // newList: {}
    }
  },
  mounted: function () {
    this.$axios // 返回goods_information表所有内容
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
                // eslint-disable-next-line no-redeclare
                for (var i = 0; i < this.results.length; i++) {
                  this.responseAll[i].imgpath = '/api/img/itemid' + this.responseAll[i].goods_id + '.jpg'
                  // eslint-disable-next-line no-undef
                  console.log(this.responseAll[i].goods_id)
                  console.log(this.responseAll[i].imgpath)
                }
                // 咋用results就好使，用responseAll就不好使捏
                this.results = this.responseAll
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
        .post('/updateGoodsInformation', qs.stringify({
          id: newId,
          hot: newHot
        }), {headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
          }})
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            this.$router.push({path: '/itemInfo?itemid=' + id})
            // console.log(successResponse.data.data)
          }
        })
        .catch(failResponse => {
          console.log(failResponse)
        })
    },
    goodStore: function (goodsId) {
      this.$axios
        .get('/queryGoodsLike')
        .then(successResponse => {
          this.responseLike = successResponse.data
          var oldId = this.responseLike[this.responseLike.length - 1].id
          var newId = oldId + 1
          this.$axios
            .get('/queryByAccount')
            .then(successResponse => {
              // console.log(successResponse.data.id)
              if (successResponse.data.id == null) {
                alert('未登录！')
                this.$router.push({path: '/login'})
              } else {
                var userId = successResponse.data.id
                // console.log(userId)
                // console.log(successResponse.data)
                this.$axios
                  .post('/addGoodsLike', qs.stringify({
                    id: newId,
                    user_id: userId,
                    goods_id: goodsId
                  }), {
                    headers: {
                      'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                    }
                  })
                  .then(successResponse => {
                    if (successResponse.data.code === 200) {
                      alert('收藏成功!')
                      // console.log(successResponse.data.data)
                    }
                  })
                  .catch(failResponse => {
                    console.log(failResponse)
                    alert('收藏失败!')
                  })
              }
            })
            .catch(failResponse => {
              console.log(failResponse)
            })
        })
        .catch(failResponse => {
          console.log(failResponse)
        })
    },
    find_class: function (x) {
      if (x === 0) { // 查找全部
        this.results = this.responseAll
        this.flag = true
      } else { // 查找部分
        var flag = 0
        this.flag = false
        this.resultsClass = []
        for (var i = 0; i < this.responseAll.length; i++) {
          if (this.responseAll[i].class_id === x) {
            this.resultsClass[flag] = this.responseAll[i]
            flag++
          }
        }
        // console.log(this.resultsClass)
        this.results = this.resultsClass
      }
      // console.log(this.results)
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
    width: 100%;
    margin-top: 30px;
    margin-bottom: -30px;
    margin-left: 150px
  }
  .sort_item {
    margin-left: 20%;
  }
  .sort_all, .sort_nv, .sort_nan, .sort_mu, .sort_mei, .sort_jia, .sort_shu, .sort_shou, .sort_nei, .sort_xie, .sort_wu{
    float: left;
    margin-right: 10px;
  }
  .sort_all:hover, .sort_nv:hover, .sort_nan:hover, .sort_mu:hover, .sort_mei:hover, .sort_jia:hover, .sort_shu:hover, .sort_shou:hover, .sort_nei:hover, .sort_xie:hover, .sort_wu:hover {
    color: red;
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
  .store {
    margin-top: 4px;
    float: right;
    font-size: 15px;
    color: #2e6da4;
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
    bottom: -30px;
    right: 60px;
  }  .footer-img {
       margin-top: 50px;
       width: 100%;
       height: 250px;
     }

</style>
