<template id="publish">
  <div class="container">
    <div class="all">
      <div class="publish_imag">
        <div><img src="../assets/publish_1.jpg" /></div>
        <div><img src="../assets/publish_1.jpg" /></div>
      </div>
      <div class="right">
        <div class="discription">
          <form>
            <div>
              <p>
                <span style="font-size:large; "><strong>标题</strong></span>
                <br/>
                <textarea name="reworkmes" cols="40" rows="1"  placeholder="品类品牌型号都是买家喜欢搜索的" style="OVERFLOW:   hidden"></textarea>
              </p>
            </div>
                <p>宝贝类别：</p>
                <input type="radio" name="checkbok" value="衣服">衣服
                <input type="radio" name="checkbok" value="衣服">衣服
                <input type="radio" name="checkbok" value="衣服">衣服
                <input type="radio" name="checkbok" value="衣服">衣服
                <input type="radio" name="checkbok" value="衣服">衣服
                <input type="radio" name="checkbok" value="衣服">衣服
                <br/>
                <br/>
                <p>宝贝详情：</p>
                <textarea name="reworkmes" cols="40" rows="4" style="OVERFLOW:   hidden"></textarea>
                <br/>
                <div><p>价格：</p></div>
                <textarea name="reworkmes" cols="40" rows="1" placeholder="                                                               元" style="OVERFLOW:   hidden"></textarea>
                <br/>
                <br/>
              </form>
              <div class="publish">
                <button type="button" id="modal-140183" href="#modal-container-140183" role="button" class="btn btn-default btn-block" data-toggle="modal">发布</button>
              </div>

              <div class="modal fade" id="modal-container-140183" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="success">
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
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">去查看</button>
                    </div>
                  </div>
                </div>
              </div>
              </div>
            </div>
          </div>
    </div>
    <div class="publish_imag">
      <div><img src="../assets/publish_1.jpg" /></div>
      <div><img src="../assets/publish_1.jpg" /></div>
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
  .right{
    margin-top:0px;
    margin-right: 70px;
    float: right;
  }
  .all{
    margin-top:30px;
  }
</style>
