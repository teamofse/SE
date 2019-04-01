<template>
  <div class="list">
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

        <!--商品列表-->
        <div class="goods">
          <div class="col-md-4" v-for="result in results" :key="result" v-on:click="addHot(result.id, result.title, result.star, result.name, result.city, result.hot)">
            <div class="thumbnail">
              <img class="image" alt="1" src="../assets/1.jpg" />
              <div class="intro">
                <p class="title" align="left">
                  <strong>{{result.title}}</strong>
                </p>
                <div class="money-row">
                  <img class="star" alt="star" src="../assets/star.png" align="left"/>
                  <p class="money"><strong>{{result.star}}</strong></p>
                  <p class="hot"><strong>点击量：{{result.hot}}</strong></p>
                </div>
                <hr class="line" />
                <span class="name-city-row">
                  <p class="name" align="left"><strong>{{result.name}}</strong></p>
                  <p class="city" align="right"><strong>{{result.city}}</strong></p>
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

        <!--footer-->
        <div class="footer">
          <img class="footer-img" alt="footer" src="../assets/footer.jpg" />
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'home',
  data: function () {
    return {
      responseResult: [],
      results: []
      // newList: {}
    }
  },
  mounted: function () {
    this.$axios
      .get('/queryGoodsById')
      .then(successResponse => {
        this.responseResult = successResponse.data
        this.results = this.bubbleSort(this.responseResult)
        // var i
        // var j
        // var index = 0
        // var newListIndex = 0
        // var x = []
        // for (var k = 0; k < Math.ceil(this.responseResult.length / 3); k++) {
        //   x[k] = []
        // }
        // for (i = 0; i < Math.ceil(this.responseResult.length / 3); i++) {
        //   for (j = 0; j < 3; ++j) {
        //     if (index < this.responseResult.length) {
        //       x[i][j] = (this.responseResult[index])
        //       index++
        //     }
        //   }
        //   this.newList[newListIndex] = {}
        //   this.newList[newListIndex].key = 'akey'
        //   this.newList[newListIndex].avalue = x[i]
        //   newListIndex++
        // }
        // console.log(this.newList)
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
    addHot: function (id, title, star, name, city, hot) {
      var newId = this.id
      var newTitle = this.title
      var newStar = this.star
      var newName = this.name
      var newCity = this.city
      var newHot = this.hot++
      this.$axios
        .put('/updateGoods', {id: newId, title: newTitle, star: newStar, name: newName, city: newCity, hot: newHot})
        .then(successResponse => {
          this.responseResult = successResponse.data
          console.log(successResponse.data)
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
    bottom: 255px;
    right: 60px;
  }
  .footer-img {
    margin-top: 50px;
    width: 100%;
    height: 250px;
  }
</style>
