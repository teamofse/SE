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

        <div class="goods">
          <!--商品列表-->
          <div class="row" v-for="news in newList" :key="news">
            <div class="col-md-4" v-for="result in news.avalue" :key="result">
              <div class="thumbnail">
                <img class="image" alt="1" src="../assets/1.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>{{result.title}}</strong>
                  </p>
                  <span class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>{{result.star}}</strong></p>
                  </span>
                  <hr class="line" />
                  <span class="name-city-row">
                    <p class="name" align="left"><strong>{{result.name}}</strong></p>
                    <p class="city" align="right"><strong>{{result.city}}</strong></p>
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!--查看更多-->
        <a class="more" align="right">
          <router-link
            to="/list">
            <span>
              <p class="more-word">查看更多</p>
              <img class="more-img" alt="more" src="../assets/more.png" />
            </span>
          </router-link>
        </a>

        <!--footer-->
        <div class="footer">
          <img class="footer-img" alt="footer" src="../assets/footer.jpg" />
        </div>

      </div>
    </div>
  </div>
</template>

<script>
// import qs from 'Qs'
export default {
  name: 'home',
  data: function () {
    return {
      responseResult: [],
      newList: {}
    }
  },
  created: function () {
    console.log('created')
  },
  beforeMount: function () {
    // console.log('before1')
    this.$axios
      .get('/queryGoodsById')
      .then(successResponse => {
        this.responseResult = successResponse.data
        // console.log(successResponse.data)
        // console.log(this.responseResult)

        var i
        var j
        var index = 0
        var newListIndex = 0
        var x = []
        for (var k = 0; k < Math.ceil(this.responseResult.length / 3); k++) {
          x[k] = []
        }
        // console.log(x)
        // console.log(this.responseResult.length)
        for (i = 0; i < Math.ceil(this.responseResult.length / 3); i++) {
          for (j = 0; j < 3; ++j) {
            if (index < this.responseResult.length) {
              x[i][j] = (this.responseResult[index])
              index++
            }
          }
          this.newList[newListIndex] = {}
          this.newList[newListIndex].key = 'akey'
          this.newList[newListIndex].avalue = x[i]
          newListIndex++
        }
        console.log(this.newList)
      })
      .catch(failResponse => {
      })
    // console.log('before2')
  },
  mounted: function () {
    // console.log('mount1')
    // console.log(this.responseResult)
    // console.log(this.successResponse.data)
    // console.log('mount2')
  },
  methods: {

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
</script>

<style scoped>
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
    margin-left: 45px;
    font-size: 15px;
    line-height: 30px;
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
  .more {
    width: 80px;
    height: 25px;
    float: right;
    margin-right: 120px;
    margin-top: -50px;
  }
  .more-word {
    line-height: 18px;
    width: 60px;
    float: left;
  }
  .more-img {
    width: 15px;
    height: 15px;
    float: right;
  }
  .footer-img {
    width: 100%;
    height: 300px;
  }
</style>
