<template>
<div class="container" id="profile-box">
  <navigation-bar></navigation-bar>
  <div class="row clearfix">
    <div class="col-md-12 column">
  <div class="row clearfix">
    <div class="col-md-1 column">
    </div>
    <div class="col-md-10 column">
      <div class="row clearfix">
        <div class="col-md-3 column btnregion">
            <div class="button">
                  <router-link to="/psinfo">个人信息</router-link>
            </div>
            <div class="button">
                  <router-link to="/records">购买记录</router-link>
            </div>
            <div class="button">
                  <router-link to="/onsale">我发布的</router-link>
            </div>
        </div>
        <div class="col-md-9 column">
          <router-view></router-view>
        </div>
      </div>
    </div>
    <div class="col-md-1 column">
    </div>
  </div>
</div>
</div>
</div>
</template>

<script>
  import NavigationBar from './navigationbar'
export default {
  name: 'profile',
  components: { NavigationBar }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .btnregion {
    padding-top: 20px;
  }
  .button {
    background-color: gainsboro; /* Green */
    border: none;
    width: 200px;
    border-radius: 8px;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 6px 2px;
    cursor: pointer;
  }
</style>
