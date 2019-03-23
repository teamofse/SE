<template>
  <div class="container">
    <div class="row clearfix">
      <div class="col-md-12 column">
        <div class="row clearfix">
          <div class="col-md-2 column">
          </div>
          <div class="col-md-8 column">
            <nav class="navbar navbar-default" role="navigation">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
              </div>

              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li class="active">
                    <a href="#">Link</a>
                  </li>
                  <li>
                    <a href="#">Link</a>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
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
                <form class="navbar-form navbar-left" role="search">
                  <div class="form-group">
                    <input type="text" class="form-control" />
                  </div> <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <ul class="nav navbar-nav navbar-right">
                  <li>
                    <a href="#">Link</a>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
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
            <div class="row clearfix">
              <div class="col-md-6 column">
                <div class="carousel slide" id="carousel-276770">
                  <ol class="carousel-indicators">
                    <li class="active" data-slide-to="0" data-target="#carousel-276770">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-276770">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-276770">
                    </li>
                  </ol>
                  <div class="carousel-inner">
                    <div class="item active">
                      <img alt="" src="v3/default.jpg" />
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
                      <img alt="" src="v3/default1.jpg" />
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
                      <img alt="" src="v3/default2.jpg" />
                      <div class="carousel-caption">
                        <h4>
                          Third Thumbnail label
                        </h4>
                        <p>
                          Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                        </p>
                      </div>
                    </div>
                  </div> <a class="left carousel-control" href="#carousel-276770" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-276770" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
              </div>
              <div class="col-md-6 column">
                <a id="modal-249609" href="#modal-container-249609" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>

                <div class="modal fade" id="modal-container-249609" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">
                          标题
                        </h4>
                      </div>
                      <div class="modal-body">
                        内容...
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
          <div class="col-md-2 column">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ItemInfo'
}
</script>

<style scoped>

</style>
