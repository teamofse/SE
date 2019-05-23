<template>
  <div class="list">
    <navigation-bar></navigation-bar>
    <div class="row clearfix">
      <div class="col-md-12 column">

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
          <div class="col-md-4" v-for="result in results" :key="result" v-on:click="addHot(result.goods_id, result.hot)">
            <div class="thumbnail">
              <img class="image" alt="1" src="../assets/1.jpg" />
              <div class="intro">
                <span class="title" align="left">
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
  name: 'list',
  components: {
    NavigationBar,
    AppFooter
  },
  data: function () {
    return {
      flag: true,
      results: [],
      responseResultUser: [],
      responseResultClass: [],
      responseAll: [],
      resultsClass: []
      // newList: {}
    }
  },
  mounted: function () {
    this.$axios
      .get('/queryGoodsInformationById')
      .then(successResponse => {
        this.results = successResponse.data
        this.$axios // 返回users表所有内容
          .get('/queryAllUsers')
          .then(successResponse => {
            this.responseResultUser = successResponse.data
            // console.log(this.responseResultUser)
            this.$axios // 返回goods_class表所有内容
              .get('/queryGoodsClass')
              .then(successResponse => {
                this.responseResultClass = successResponse.data
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
    addHot: function (id, hot) {
      var newId = id
      var newHot = hot + 1
      this.$axios
        .put('/updateGoodsInformation', qs.stringify({
          id: newId,
          hot: newHot
        }), {
          headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
          }
        })
        .then(successResponse => {
          this.responseResult = JSON.stringify(successResponse.data)
          if (successResponse.data.code === 200) {
            this.$router.push({path: '/itemInfo?itemid=id'})
            console.log(successResponse.data.data)
          }
        })
        .catch(failResponse => {
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
              var userId = successResponse.data.id
              // console.log(userId)
              // console.log(successResponse.data)
              this.$axios
                .post('/addGoodsLike', qs.stringify({
                  id: newId,
                  user_id: userId,
                  goods_id: goodsId
                }), {headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
                  }})
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
  }
}

</script>

<style scoped>
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
  .footer-img {
    margin-top: 50px;
    width: 100%;
    height: 250px;
  }
</style>
