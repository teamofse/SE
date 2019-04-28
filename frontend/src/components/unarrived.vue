<template id="unarrived">
  <div class="itemregion">
    <div class="item">
      <div class="row clearfix" v-for="result in results" :key="result">
        <div class="col-md-3 column">
          <img alt="140x140" src="../assets/logo.png" width="140" height="140"/>
        </div>
        <div class="col-md-9 column">
          <h2 class="heading">
            {{result.goods_name}}
          </h2>
          <p class="detail">
            {{result.goods_detail}}
          </p>
          <p>
            <router-link :to="{path:'/iteminfo',query:{ itemid:result.goods_id }}" class="button"><span>View details</span></router-link>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
      name: 'unarrived',
      data: function () {
        return {
          responseResult: [],
          results: []
        }
      },
      mounted: function () {
        this.$axios
          .get('/queryGoodByOnTheWayState')
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
      }
    }
</script>

<style scoped>
  h2.heading {
    text-align: left;
  }
  p.detail {
    text-align: justify;
  }
  .button {
    display: inline-block;
    border-radius: 4px;
    border: none;
    text-align: center;
    font-size: 14px;
    padding: 10px;
    width: 150px;
    transition: all 0.5s;
    cursor: pointer;
    margin: 5px;
  }

  .button span {
    cursor: pointer;
    display: inline-block;
    position: relative;
    transition: 0.5s;
  }

  .button span:after {
    content: '»';
    position: absolute;
    opacity: 0;
    top: 0;
    right: -20px;
    transition: 0.5s;
  }

  .button:hover span {
    padding-right: 25px;
  }

  .button:hover span:after {
    opacity: 1;
    right: 0;
  }
  .itemregion{
    padding: 20px;
  }
  .item {
    margin-top: 20px;
  }
</style>
