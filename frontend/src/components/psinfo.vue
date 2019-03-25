<template id="psinfo">
  <div class="inforegion">
    <div class="row clearfix">
          <div class="col-md-1 column">
          </div>
          <div class="col-md-10 column">
            <div class="infoborder">
            <p id="heading">个人信息</p>
            <dl class="dl-horizontal" id="perinfo">
              <div id="username">
              <dt>
                账号
              </dt>
              <dd>
                dracomalfoy233
              </dd>
              </div>
              <div id="star">
              <dt>
                我的星星
              </dt>
              <dd>
                200
              </dd>
              </div>
              <div id="address">
              <dt>
                地址
              </dt>
              <dd id="add1">
                山东省 威海市
              </dd>
              <dd id="add2">
                哈尔滨工业大学
              </dd>
                <p id="modify"><a>修改地址</a></p>
              </div>
            </dl>
          </div>
          <div class="col-md-1 column">
          </div>
          </div>
        </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
  #perinfo {
    border-top: 2px solid #737373;
    padding-top: 20px;
}
  #heading {
    text-align: right;
  }
  .infoborder {
    margin-top: 20px;
  }
  #username {
    padding: 10px;
  }
  #star {
    padding: 10px;
  }
  #address {
    padding: 10px;
  }
  #add2 {
    margin-top: 10px;
  }
  #modify {
    text-align: right;
  }
  #inforegion {
    padding: 20px;
  }
</style>
