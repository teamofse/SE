<template>
<div class="container" id="profile-box">
  <div class="row clearfix">
    <div class="col-md-12 column">
      <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li class="active">
              <a href="#">首页</a>
            </li>
            <li>
              <a href="#">商品</a>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li>
              <a href="#">关于我们</a>
            </li>
            <li>
              <a href="#">我的</a>
            </li>
          </ul>
        </div>

      </nav>
    </div>
  </div>
  <div class="row clearfix">
    <div class="col-md-1 column">
    </div>
    <div class="col-md-10 column">
      <div class="row clearfix">
        <div class="col-md-3 column">
          <div class="panel-group" id="panel-260036">
            <div class="panel panel-default">
              <div class="panel-heading">
                <a class="panel-title" data-toggle="collapse" data-parent="#panel-260036">
                  <router-link to="/psinfo">个人信息</router-link>
                </a>
              </div>

            </div>
            <div class="panel panel-default">
              <div class="panel-heading">
                <a class="panel-title" data-toggle="collapse" data-parent="#panel-260036">
                  <router-link to="/records">购买记录</router-link>
                </a>
              </div>
            </div>
            <div class="panel panel-default">
              <div class="panel-heading">
                <a class="panel-title" data-toggle="collapse" data-parent="#panel-260036">
                  <router-link to="/commodity">我发布的</router-link>
                </a>
              </div>
            </div>
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
</template>

<script>
export default {

}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
