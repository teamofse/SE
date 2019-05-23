<template id="publish">
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="all col-md-12 column">
      <div class="left col-md-8 column">
        <div class="row clearfix">
          <div class="col-md-6 column">
            <img src="../assets/publish_1.jpg" height="330" width="330"  @click="getFile_1($event)" />
            <form>
              <input type="file" @change="getFile_1($event)">
            </form>
          </div>
          <div class="col-md-6 column ">
            <img src="../assets/publish_1.jpg" height="330" width="330" @click="getFile_2($event)"/>
            <form>
              <input type="file" @change="getFile_2($event)">
            </form>
          </div>
        </div>

        <div class="row clearfix">
          <div class="col-md-6 column">
            <img src="../assets/publish_1.jpg" height="330" width="330" @click="getFile_3($event)"/>
            <form>
              <input type="file" @change="getFile_3($event)">
            </form>
          </div>
          <div class="col-md-6 column">
            <img src="../assets/publish_1.jpg" height="330" width="330" @click="getFile_4($event)"/>
            <form>
              <input type="file" @change="getFile_4($event)">
              <button class="button button-primary button-pill button-small" @click="submit($event)">提交</button>
            </form>
          </div>
        </div>
      </div>
      <div class="right col-md-4 column">
        <div class="discription">
          <form>
            <div>
              <p>
                <span style="font-size:large; "><strong>标题</strong></span>
                <br/>
                <textarea v-on:keypress="checkForm" name="goods_name" v-model="GoodsInfo.goods_name" cols="40" rows="1"  placeholder="品类品牌型号都是买家喜欢搜索的" style="OVERFLOW:   hidden"></textarea>
              </p>
            </div>
            <div id="class">
                <p>宝贝类别：</p>
              <div class="radio-box" v-for="(item,index) in radios" :key="item.id">
                <input v-on:keypress="checkForm" v-model="GoodsInfo.class_id" :value="item.value" class="input-radio" :checked='item.isChecked'  @click="check(index)" type="radio">{{item.label}}
              </div>
              <br/>
            </div>
                <br/>
                <p>宝贝详情：</p>
                <textarea v-on:keypress="checkForm" name="goods_detail" v-model="GoodsInfo.goods_detail"  cols="40" rows="4" style="OVERFLOW:   hidden"></textarea>
                <br/>
                <div><p>价格：</p></div>
                <textarea v-on:keypress="checkForm" name="price"  v-model="GoodsInfo.price" cols="40" rows="1" placeholder="                                                               星星" style="OVERFLOW:   hidden"></textarea>
                <br/>
                <br/>
              </form>
              <span id="tips" v-bind:style="styleObject.tips">{{GoodsInfo.tipsInfo}}</span>
              <div class="publish">
                <button type="button" id="modal-140183" href="#modal-container-140183" v-on:click="publish($event)" role="button" class="btn btn-default btn-block" data-toggle="modal">发布</button>
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
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary" v-on:click=" ">去查看</button>
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
import qs from 'Qs'
import axios from 'axios'
import NavigationBar from './navigationbar'

  export default {
    name: 'publish',
    components: {NavigationBar},
    data: function () {
      return {
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
          tipsInfo: ''
        },
        styleObject: {
          tips: {
            color: 'green'
          }
        },
        file_1: '',
        file_2: '',
        file_3: '',
        file_4: '',
        responseResult: []
      }
    },
    methods: {
      getFile_1: function (event) {
        this.file_1 = event.target.files[0]
        console.log(this.file_1)
      },
      getFile_2: function (event) {
        this.file_2 = event.target.files[0]
        console.log(this.file_2)
      },
      getFile_3: function (event) {
        this.file_3 = event.target.files[0]
        console.log(this.file_3)
      },
      getFile_4: function (event) {
        this.file_4 = event.target.files[0]
        console.log(this.file_4)
      },
      checkForm () {
        if (this.GoodsInfo.goods_name === '') {
          this.GoodsInfo.tipsInfo = '宝贝标题不能为空!'
        } else if (this.GoodsInfo.class_id === '') {
          this.GoodsInfo.tipsInfo = '宝贝类别不能为空!'
        } else if (this.GoodsInfo.goods_detail === '') {
          this.GoodsInfo.tipsInfo = '宝贝详情不能为空!'
        } else if (this.GoodsInfo.price === '') {
          this.GoodsInfo.tipsInfo = '宝贝价格不能为空!'
        } else {
          this.GoodsInfo.tipsInfo = 'It\'s OK!'
          this.styleObject.tips.color = 'green'
        }
      },
      publish (event) {
        this.$axios.post('/insertGoodsInformation', qs.stringify({
          goods_id: '0',
          goods_name: this.GoodsInfo.goods_name,
          price: this.GoodsInfo.price,
          goods_detail: this.GoodsInfo.goods_detail,
          class_id: this.GoodsInfo.class_id
        }))
          .then(successResponse => {
          this.responseResult = successResponse.data
          console.log(successResponse.data)
        })
          .catch(failResponse => {
          })
        event.preventDefault()
        // let formData1 = new FormData()
        // formData1.append('file', this.file_1)
        // axios.post('/upload/singlefile', formData1)
        //   .then(function (response) {
        //     alert(response.data)
        //     console.log(response)
        //     window.location.reload()
        //   })
        //   .catch(function (error) {
        //     alert('上传失败')
        //     console.log(error)
        //     window.location.reload()
        //   })
        // let formData2 = new FormData()
        // formData2.append('file', this.file_2)
        // axios.post('/upload/singlefile', formData2)
        //   .then(function (response) {
        //     alert(response.data)
        //     console.log(response)
        //     window.location.reload()
        //   })
        //   .catch(function (error) {
        //     alert('上传失败')
        //     console.log(error)
        //     window.location.reload()
        //   })
        // let formData3 = new FormData()
        // formData3.append('file', this.file_3)
        // axios.post('/upload/singlefile', formData3)
        //   .then(function (response) {
        //     alert(response.data)
        //     console.log(response)
        //     window.location.reload()
        //   })
        //   .catch(function (error) {
        //     alert('上传失败')
        //     console.log(error)
        //     window.location.reload()
        //   })
        // let formData4 = new FormData()
        // formData4.append('file', this.file_4)
        // axios.post('/upload/singlefile', formData4)
        //   .then(function (response) {
        //     alert(response.data)
        //     console.log(response)
        //     window.location.reload()
        //   })
        //   .catch(function (error) {
        //     alert('上传失败')
        //     console.log(error)
        //     window.location.reload()
        //   })
      },
      submit: function (event) {
        // 阻止元素发生默认的行为
        event.preventDefault()
        let formData1 = new FormData()
        formData1.append('file', this.file_1)
        axios.post('/upload/singlefile', formData1)
          .then(function (response) {
            alert(response.data)
            console.log(response)
            window.location.reload()
          })
          .catch(function (error) {
            alert('上传失败')
            console.log(error)
            window.location.reload()
          })
        let formData2 = new FormData()
        formData2.append('file', this.file_2)
        axios.post('/upload/singlefile', formData2)
          .then(function (response) {
            alert(response.data)
            console.log(response)
            window.location.reload()
          })
          .catch(function (error) {
            alert('上传失败')
            console.log(error)
            window.location.reload()
          })
        let formData3 = new FormData()
        formData3.append('file', this.file_3)
        axios.post('/upload/singlefile', formData3)
          .then(function (response) {
            alert(response.data)
            console.log(response)
            window.location.reload()
          })
          .catch(function (error) {
            alert('上传失败')
            console.log(error)
            window.location.reload()
          })
        let formData4 = new FormData()
        formData4.append('file', this.file_4)
        axios.post('/upload/singlefile', formData4)
          .then(function (response) {
            alert(response.data)
            console.log(response)
            window.location.reload()
          })
          .catch(function (error) {
            alert('上传失败')
            console.log(error)
            window.location.reload()
          })
      },
      check (index) {
        this.radios.forEach((item) => {
          item.isChecked = false
        })
        this.GoodsInfo.class_id = this.radios[index].value
        this.radios[index].isChecked = true
      }
    }
  }

</script>

<style scoped>
  .publish_imag{
    width: 20px;
    margin-left:30px;
    overflow:hidden
  }
  .discription {
    margin-right: 50px;
    float: left;
  }
  .right{
    margin-top:0px;
    float: right;
  }
  .all{
    margin-top:30px;
  }
  .radio-box{
    display: inline-block;
    position: relative;
    height: 25px;
    line-height: 25px;
    margin-right: 5px;
  }
  .input-radio {
    cursor: pointer;
  }
</style>
