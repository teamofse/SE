<template id="publish">
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="all col-md-12 column">
      <form :model="GoodsInfo" ref="GoodsInfo" :rules="ruleInline">
      <div class="publish_imag col-md-8 column">
        <div><img src="../assets/publish_1.jpg" /></div>
        <form name="imgForm" class="imgForm" enctype="multipart/form-data" action="图片上传接口" method='post'>
        <input class="input-loc-img imgLocal"  name="imgLocal" type='file' accept="image/*" @change="selectImg" />
        </form>

        <div><img src="../assets/publish_1.jpg" /></div>
        <form name="imgForm" class="imgForm" enctype="multipart/form-data" action="图片上传接口" method='post'>
          <input class="input-loc-img imgLocal"  name="imgLocal" type='file' accept="image/*" @change="selectImg" />
        </form>

        <div><img src="../assets/publish_1.jpg" /></div>
        <form name="imgForm" class="imgForm" enctype="multipart/form-data" action="图片上传接口" method='post'>
          <input class="input-loc-img imgLocal"  name="imgLocal" type='file' accept="image/*" @change="selectImg" />
        </form>

        <div><img src="../assets/publish_1.jpg" /></div>

        <FormItem label="宝贝图片 : ">
          <div>
            <input type="file" @change="doUpload" ref="inputFile"/>
            <Icon type="ios-plus-empty" class="uploadIcon"></Icon>

            <div v-show="categoryLogoIsShow">
              <img :src="GoodsInfo.goods_name" @click="$refs.inputFile.click()"/>
            </div>
          </div>
          <div v-show="categoryLogoIsShow" style="text-align: left;">
            <Icon type="information-circled"></Icon>
            可点击图片重新选择
          </div>
        </FormItem>

      </div>
      <div class="right col-md-4 column">
        <div class="discription">
            <div>
              <p>
                <span style="font-size:large; "><strong>标题</strong></span>
                <br/>
                <textarea name="goods_name" v-model="GoodsInfo.goods_name" cols="40" rows="1"  placeholder="品类品牌型号都是买家喜欢搜索的" style="OVERFLOW:   hidden"></textarea>
              </p>
            </div>
            <div id="class">
                <p>宝贝类别：</p>
              <div v-for="(item,index) in radios" :key="item.id">
                <input v-model="GoodsInfo.class_id" :value="item.value"  name="input-radio"  @click="check(index)" type="radio">{{item.label}}
              </div>
              <br/>
            </div>
                <br/>
                <p>宝贝详情：</p>
                <textarea name="goods_detail" v-model="GoodsInfo.goods_detail"  cols="40" rows="4" style="OVERFLOW:   hidden"></textarea>
                <br/>
                <div><p>价格：</p></div>
                <textarea name="price"  v-model="GoodsInfo.price" cols="40" rows="1" placeholder="                                                               星星" style="OVERFLOW:   hidden"></textarea>
                <br/>
                <br/>
              <div class="publish">
                <button type="button" id="modal-140183" href="#modal-container-140183" v-on:click="publish" role="button" class="btn btn-default btn-block" data-toggle="modal">发布</button>
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
      </form>
    </div>
  </div>
</template>

<script>
import qs from 'Qs'
import NavigationBar from './navigationbar'

  export default {
      name: 'publish',
      components: {NavigationBar},

      data: function () {
      return {
        total: { isShow:false,text:""} ,
        radios: [
          {
            label: '女装',
            value: '0',
            isChecked: false
          },
          {
            label: '男装',
            value: '1',
            isChecked: false
          },
          {
            label: '家居家纺',
            value: '4',
            isChecked: false
          },
          {
            label: '母婴',
            value: '2',
            isChecked: false
          },
          {
            label: '美妆',
            value: '3',
            isChecked: false
          },
          {
            label: '数码家电',
            value: '5',
            isChecked: false
          },
          {
            label: '手表配饰',
            value: '6',
            isChecked: false
          },
          {
            label: '男女内衣',
            value: '7',
            isChecked: false
          },
          {
            label: '鞋包',
            value: '8',
            isChecked: false
          },
          {
            label: '生活小物',
            value: '9',
            isChecked: false
          }
        ],
        GoodsInfo: {
          goods_id: '',
          goods_name: '',
          price: '',
          goods_detail: '',
          class_id: '',
          goods_picture_4: ''
        },
        ruleInline: {
          goods_name: [
            {required: true, message: '寶貝標題不能为空', trigger: 'blur'},
          ],
          price: [
            {required: true, message: '寶貝價格不能为空', trigger: 'blur'},
          ],
          goods_detail: [
            {required: true, message: '宝贝详情不能为空', trigger: 'blur'},
          ],
          class_id: [
            {required: true, message: '宝贝分类不能为空', trigger: 'blur'},
          ],
          goods_picture_4: [
            {required: true, message: '宝贝图片不能为空', trigger: 'blur'},
          ]
        },
        responseResult: []
      }
    },
    methods: {
      publish () {
        this.$axios.post('/insertGoodsInformation', qs.stringify({
          goods_id: '0',
          goods_name: this.GoodsInfo.goods_name,
          price: this.GoodsInfo.price,
          goods_detail: this.GoodsInfo.goods_detail,
          class_id: this.GoodsInfo.class_id,
          goods_picture_4: this.GoodsInfo.goods_picture_4
        }))
          .then(successResponse => {
            this.responseResult = successResponse.data
            console.log(successResponse.data)
          })
          .catch(failResponse => {
          })
      },
      check (index) {
        this.radios.forEach((item) => {
          item.isChecked = false
        })
        this.GoodsInfo.class_id = this.radios[index].value
        this.radios[index].isChecked = true
      },
      doUpload(files) {
        var that = this;
        this.uploadOneImage(files, function (err, data) {
          if (err) {
            that.formItem.fc_icon = data.url;
            that.organizationLogoIsShow = true;
          } else {
            alert("图片上传失败");
          }

        });
      },
    }
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
