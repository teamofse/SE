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
          <div class="row">
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="1" src="../assets/1.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷张云雷张云雷张云雷张云雷张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮孔唐潮孔唐潮孔唐潮孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市威海市威海市威海市威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="2" src="../assets/2.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="3" src="../assets/3.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="4" src="../assets/4.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="5" src="../assets/5.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="6" src="../assets/6.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="1" src="../assets/1.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="2" src="../assets/2.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="thumbnail">
                <img class="image" alt="3" src="../assets/3.jpg" />
                <div class="intro">
                  <p class="title" align="left">
                    <strong>张云雷</strong>
                  </p>
                  <scan class="money-row">
                    <img class="star" alt="star" src="../assets/star.png" align="left"/>
                    <p class="money" align="left"><strong>200</strong></p>
                  </scan>
                  <hr class="line" />
                  <scan class="name-city-row">
                    <p class="name" align="left"><strong>孔唐潮</strong></p>
                    <p class="city" align="right"><strong>威海市</strong></p>
                  </scan>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!--查看更多-->
        <a class="more" align="right">
          <scan>
            <p class="more-word">查看更多</p>
            <img class="more-img" alt="more" src="../assets/more.png" />
          </scan>
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
export default {
  name: 'home'
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
