<template id="abouts">
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="p1">
        <img src="../assets/zyl1.png"/>
    </div>
    <div class="row clearfix all" style="color: #5e5e5e">
      <div class="col-md-8 column">
        <h2>
          <strong>品牌故事</strong>
        </h2>
        <p >Brand Introduction</p>
        <div class="word" style="font-size:20px ; text-indent: 2em">
        <p align="left">
          随着现在互联网的高速发展，线上交易与我们的生活越来越密不可分，越来越多的人喜欢线上交易商品，与此同时也涌现了许多优秀的电子商务网站。现在我们虽然由众多的电子商务网站，但是我们将要完成的是一个在线物品共享的网站，从整体上分类应该是属于一个电子商务网站，不过略显不同的是，它要完成的并不是基于金钱的交易，而是希望分享个人的不需要的，闲置的的物品，从而使得物品能够到需要的人的手中，让它再次变得有价值，不浪费，这也是符合我国的优良的传统。
        </p>
          <p align="left">
            近年来，在全球互联网的迅速普及，全球的电子商务市场保持了告诉增长，相应的，我国也出现了几个非常优秀的电子商务网站，包括淘宝，京东，天猫等等，伴随着这些优秀的电子商务网站的成长，国内的物流网络也是发展的非常成熟，而国外的话则有像亚马逊这样的。
          </p>
          <p align="left">
            从共享单车开始，短短一年间，这个行业就出现了共享充电宝、共享雨伞、共享篮球甚至是共享玩具这些听起来一点都不性感的创业方向。
            追风者们前赴后继，使得共享经济成为本年度最当之无愧的创业火葬场。不完全统计，截至目前，共有26家投身共享经济的企业宣告倒闭或终止服务。其中包括7家共享单车企业、3家共享汽车企业、7家共享充电宝企业、4家共享租衣企业、1家共享雨伞企业和4家共享玩具企业。
          </p>
          <p align="left">
            2010年以来，我国共享经济迅速发展，大步进入知识消费、闲置资源配置、衣食住行等生产生活众多领域，也提出理论上深入研究共享经济本质性、发展模式、产品特征和发展规律等问题的必要性。借助类型学的思维归纳了共享经济的主要模式,总结了共享经济的本质特征。研究发现,共享经济的经济性主要体现为外部经济,即可循环性和可分享性对用户的经济性；共享经济的可复制性和可替代性则容易陷入“不持续投入就失去市场”、“持续投入却盈利不足”的悖论,容易导致内部不经济,即共享产品企业发展的不可持续性。而共享产品的选择和发展主要依托两条路径,一是弱化私人品的竞争性,二是提高公共品的排他性。本文发现：共享产品的经济学属性本质定位于自然垄断品,只有实现了规模经济,才能实现更好的盈利,因此垄断经营才是共享经济的最佳盈利模式。值得关注的是,共享产品还需考虑其所处的人文环境和国别差异,否则可能导致共享产品成本高企、制约共享企业发展。
          </p>
          <p align="left">
            而隔空享物网站，现在市场上应该是不多的，因为它现在应该还是一个比较小众需求，而且并不会有很多的盈利。但是现阶段，我国正大力弘扬勤俭节约的传统，那么随着人们节约意识的增强，应该会有越来越多的人加入这个旧物共享的行列中来的。
          </p>
        </div>
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
