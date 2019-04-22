<template>
  <div class="list">
    <navigation-bar></navigation-bar>
    <div class="row clearfix">
      <div class="col-md-12 column">
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
  import NavigationBar from './navigationbar'
import qs from 'Qs'
export default {
  name: 'list',
  components: { NavigationBar },
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
