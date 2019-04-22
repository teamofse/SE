<template>
  <div class="list">
    <div class="row clearfix">
      <div class="col-md-12 column">

        <!--header-->
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">

          <!--Brand-->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
          </div>

          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <!--link1-->
              <li class="active">
                <a href="#">Link1</a>
              </li>
              <!--link2-->
              <li>
                <a href="#">Link2</a>
              </li>
              <!--dropdown1-->
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown1<strong class="caret"></strong></a>
                <ul class="dropdown-menu">
                  <li>
                    <a href="#">Action</a>
                  </li>
                  <li>
                    <a href="#">Another action</a>
                  </li>
                  <li>
                    <a href="#">Something else here</a>
                  </li>
                  <li class="divider">
                  </li>
                  <li>
                    <a href="#">Separated link</a>
                  </li>
                  <li class="divider">
                  </li>
                  <li>
                    <a href="#">One more separated link</a>
                  </li>
                </ul>
              </li>
            </ul>
            <!--search-->
            <form class="navbar-form navbar-left" role="search">
              <div class="form-group">
                <input type="text" class="form-control" />
              </div> <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
              <!--link3-->
              <li>
                <a href="#">Link3</a>
              </li>
              <!--dropdown2-->
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown2<strong class="caret"></strong></a>
                <ul class="dropdown-menu">
                  <li>
                    <a href="#">Action</a>
                  </li>
                  <li>
                    <a href="#">Another action</a>
                  </li>
                  <li>
                    <a href="#">Something else here</a>
                  </li>
                  <li class="divider">
                  </li>
                  <li>
                    <a href="#">Separated link</a>
                  </li>
                </ul>
              </li>
            </ul>
          </div>

        </nav>

        <!--<div>-->
          <!--<p>{{routerParams}}</p>-->
        <!--</div>-->

        <!--body-->
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

        <!--footer-->
        <div class="footer">
          <img class="footer-img" alt="footer" src="../assets/footer.jpg" />
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import qs from 'Qs'
export default {
  name: 'list',
  data: function () {
    return {
      results: []
      // newList: {}
    }
  },
  mounted: function () {
    this.$axios
      .get('/queryGoodsById')
      .then(successResponse => {
        this.results = successResponse.data
      })
      .catch(failResponse => {
      })
  },
  methods: {
    addHot: function (id, title, star, name, city, hot) {
      var newId = id
      var newTitle = title
      var newStar = star
      var newName = name
      var newCity = city
      var newHot = hot + 1
      this.$axios
        .put('/updateGoods', qs.stringify({
          id: newId,
          title: newTitle,
          star: newStar,
          name: newName,
          city: newCity,
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
    }
  }
}

</script>

<style scoped>
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
  .footer-img {
    margin-top: 50px;
    width: 100%;
    height: 250px;
  }
</style>
