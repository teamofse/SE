<template id="itembar0">
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-1 column">
          </div>
          <div class="col-md-10 column">
            <div class="row clearfix">
              <div class="col-md-6 column">
                <div class="carousel slide" id="carousel-760586">
                  <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel-760586">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-760586">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-760586">
                    </li>
                  </ol>
                  <div class="carousel-inner">
                    <div class="item active">
                      <img alt="" src="/static/img/ww1.jpg" />
                      <div class="carousel-caption">
                        <h4>
                          First Thumbnail label
                        </h4>
                        <p>
                        </p>
                      </div>
                    </div>
                    <div class="item">
                      <img alt="" src="/static/img/ww2.jpg" />
                      <div class="carousel-caption">
                        <h4>
                          Second Thumbnail label
                        </h4>
                        <p>
                        </p>
                      </div>
                    </div>
                    <div class="item">
                      <img alt="" src="/static/img/ww3.jpg" />
                      <div class="carousel-caption">
                        <h4>
                          Third Thumbnail label
                        </h4>
                        <p>
                        </p>
                      </div>
                    </div>
                  </div> <a class="left carousel-control" href="#carousel-760586" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-760586" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
              </div>
              <div class="col-md-6 column">
                <h2 style="float: left;display: inline-block;clear:left;">标题标题标题</h2>
                <div style="width: 100%;float: left;clear:left;">
                  <span style="float: left;display: inline-block;">介绍</span>
                  <span style="float: left;display: inline-block">:</span>
                  <p v-bind:disabled="!itemInfo.isLogin">哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
                    哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
                    哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
                    哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
                    哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
                  </p>
                </div>
                <div style="float: left;clear:left;">
                  <span style="float: left;">价格</span>
                  <span style="float: left;">:</span>
                  <span>99.99</span>
                </div>
                <div style="float: left;clear:left;">
                  <a id="modal-17668" style="float: left;clear: left;margin-left: 0" href="#modal-container-17668" role="button" class="btn" data-toggle="modal">购买</a>
                  <img src="/static/icon/like.png">
                </div>
                <div class="modal fade" id="modal-container-17668" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">
                          请输入
                        </h4>
                      </div>
                      <div class="modal-body">
                        <form class="form-horizontal" role="form">
                          <div class="form-group">
                            <div class="col-sm-1">
                            </div>
                            <div class="col-sm-10">
                              <input type="email" class="form-control" id="inputAddress" placeholder="地址"/>
                            </div>
                            <div class="col-sm-1">
                            </div>
                          </div>
                          <div class="form-group">
                            <div class="col-sm-1">
                            </div>
                            <div class="col-sm-10">
                              <input type="password" class="form-control" id="inputItem" placeholder="商品"/>
                            </div>
                            <div class="col-sm-1">
                            </div>
                          </div>
                        </form>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">保存</button>
                      </div>
                    </div>

                  </div>

                </div>

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
import qs from 'Qs'
import NavigationBar from './navigationbar'
export default {
  name: 'ItemInfo',
  components: { NavigationBar },
  data: function () {
    return {
      itemInfo: {
        itemId: '',
        isLogin: this.$store.isLogin
      },
      styleObject: {
      },
      responseResult: []
    }
  },
  mounted: function () {
    this.$axios
      .post('/getiteminfopage', qs.stringify({
        itemId: this.$route.params.itemid
      }), {headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }})
      .then(successResponse => {
        this.responseResult = JSON.stringify(successResponse.data)
        if (successResponse.data.code === 200) {
          alert('注册成功!')
          this.$router.replace({path: '/login'})
          console.log(successResponse.data.data)
        } else if (successResponse.data.code === 400) {
          if (successResponse.data.data === '注册失败，详细信息[用户名或密码为空]。') {
            alert(successResponse.data.data)
          }
        }
      })
      .catch(failResponse => {})
  },
  methods: {
    toLogin () {
      this.$router.replace({path: '/login'})
    },
    toRegister () {
      this.$router.replace({path: '/register'})
    }
  }
}
</script>

<style scoped>

</style>
