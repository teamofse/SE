<template id="abouts">
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="p1">
        <img src="../assets/zyl1.png"/>
    </div>
    <div class="row clearfix all" style="color: #5e5e5e">
      <div class="col-md-8 column">
        <h2>
          品牌故事
        </h2>
        <p >Brand Introduction</p>
        <p >
          随着现在互联网的高速发展，线上交易与我们的生活越来越密不可分，越来越多的人喜欢线上交易商品，与此同时也涌现了许多优秀的电子商务网站。现在我们虽然由众多的电子商务网站，但是我们将要完成的是一个在线物品共享的网站，从整体上分类应该是属于一个电子商务网站，不过略显不同的是，它要完成的并不是基于金钱的交易，而是希望分享个人的不需要的，闲置的的物品，从而使得物品能够到需要的人的手中，让它再次变得有价值，不浪费，这也是符合我国的优良的传统。
          近年来，在全球互联网的迅速普及，全球的电子商务市场保持了告诉增长，相应的，我国也出现了几个非常优秀的电子商务网站，包括淘宝，京东，天猫等等，伴随着这些优秀的电子商务网站的成长，国内的物流网络也是发展的非常成熟，而国外的话则有像亚马逊这样的。
          而我们要完成的享物网站，现在市场上应该是不多的，因为它现在应该还是一个比较小众需求，而且并不会有很多的盈利，但是现阶段，我国正大力弘扬勤俭节约的传统，那么随着人们节约意识的增强，应该会有越来越多的人加入这个旧物共享的行列中来的。

        </p>
        <p>
          <a class="btn" href="/home">开启分享之旅 »</a>
        </p>
      </div>
      <div class="col-md-4 column all">
        <div class="row clearfix">
          <div class="col-md-6 column">
            <img src="../assets/abouts_1.jpg" class="img-circle" height="220" width="220" />
          </div>
          <div class="col-md-6 column">
          </div>
        </div>
        <div class="row clearfix">
          <div class="col-md-6 column">
          </div>
          <div class="col-md-6 column">
            <img src="../assets/abouts_2.jpg" class="img-circle" height="220" width="220" />
          </div>
        </div>
        <div class="row clearfix">
          <div class="col-md-6 column">
            <img src="../assets/abouts_3.jpg" class="img-circle" height="220" width="220" />
          </div>
          <div class="col-md-6 column">
          </div>
        </div>
        <div class="row clearfix">
          <div class="col-md-6 column">
          </div>
          <div class="col-md-6 column">
            <img src="../assets/abouts_4.jpg" class="img-circle" height="220" width="220" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import NavigationBar from './navigationbar'

export default {
  name: 'abouts',
  components: {NavigationBar}
}
</script>

<style scoped>
  .p1{
    margin-left: 0;
    width: 100%;
    height: 400px;
  }
  .word{
    color: rgb(141, 144, 149);
  }
  .all{
    margin-top: 20px;
  }

</style>
