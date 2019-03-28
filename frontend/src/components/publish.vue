<template id="publish">
  <div class="container">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="publish_imag">
            <div><img src="../assets/publish_1.jpg" /></div>
            <div><img src="../assets/publish_1.jpg" /></div>
          </div>
          <div class="publish_imag">
            <div><img src="../assets/publish_1.jpg" /></div>
            <div><img src="../assets/publish_1.jpg" /></div>
          </div>
          <div class="right">
            <div class="discription">
                <div>
                   <p>
                     <span style="font-size:large; "><strong>标题</strong></span>
                     <span style="font-size: small; ">品类品牌型号都是买家喜欢搜索的</span>
                   </p>
                </div>
                <div><p>宝贝详情：</p></div>
                <div><p>价格：</p></div>
              <div class=".publish">
                <button type="button" class="btn btn-default btn-block">确认发布</button>
              </div>
              <a id="modal-140183" href="#modal-container-140183" role="button" class="btn" data-toggle="modal">发布完成后点这里显示发布成功</a>

              <div class="modal fade" id="modal-container-140183" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="height:20px;width:10px">×</button>
                      <h4 class="modal-title" id="myModalLabel">
                        标题
                      </h4>
                    </div>
                    <div class="modal-body">
                      宝贝发布成功！
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
      </div>
    </div>
  </div>
</template>

<script>
  export default {
  }

</script>

<style scoped>
  .publish_imag{
    float:left;
    width:55%;
    margin-left:30px;
    overflow:hidden
  }
  .publish_imag div{
    border: solid 2px #843534;
    width:50%;
    float:left;
  }
  .publish_imag div img{
    width:100%;
  }
  .discription {
    margin-right: 50px;
    float: left;
  }
  .discription div{
  }
  .right{
    margin-top: 50px;
    margin-right: 70px;
    float: right;
  }
</style>
