<template id="publish">
  <div class="container">
    <navigation-bar></navigation-bar>
    <div class="all col-md-12 column">
      <div class="publish_imag col-md-8 column">
        <div><img src="../assets/publish_1.jpg" @click="getFile_1($event)"/></div>
        <form>
          <input type="file" @change="getFile_1($event)">
        </form>

        <div><img src="../assets/publish_1.jpg" @click="getFile_2($event)"/></div>
        <form>
          <input type="file" @change="getFile_2($event)">
        </form>

        <div><img src="../assets/publish_1.jpg" @click="getFile_3($event)"/></div>
        <form>
          <input type="file" @change="getFile_3($event)">
        </form>

        <div><img src="../assets/publish_1.jpg" @click="getFile_4($event)"/></div>
        <form>
          <input type="file" @change="getFile_4($event)">
          <button class="button button-primary button-pill button-small" @click="submit($event)">提交</button>
        </form>

      </div>
      <div class="right col-md-4 column">
        <div class="discription">
          <form>
            <div>
              <p>
                <span style="font-size:large; "><strong>标题</strong></span>
                <br/>
                <textarea name="goods_name" v-model="GoodsInfo.goods_name" cols="40" rows="1"  placeholder="品类品牌型号都是买家喜欢搜索的" style="OVERFLOW:   hidden"></textarea>
              </p>
            </div>
            <div id="class">
                <p>宝贝类别：</p>
              <div class="radio-box" v-for="(item,index) in radios" :key="item.id">
                <span class="radio" :class="{'on':item.isChecked}"></span>
                <input v-model="GoodsInfo.class_id" :value="item.value" class="input-radio" :checked='item.isChecked'  @click="check(index)" type="radio">{{item.label}}
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
              </form>
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
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> <button type="button" class="btn btn-primary">去查看</button>
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
          class_id: ''
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
  .radio-box{
    display: inline-block;
    position: relative;
    height: 25px;
    line-height: 25px;
    margin-right: 5px;
  }
  .radio {
    display: inline-block;
    width: 25px;
    height: 25px;
    vertical-align: middle;
    cursor: pointer;
    border: solid 2px #843534;
    background-image: url(../assets/radio.png);
    background-attachment: fixed;
    background-repeat: no-repeat;
    background-size: 100% 100%;
    background-position: 0 0;
    background-image: url(../assets/radio.png);
    background-size : 100% 100%;
  }
  .input-radio {
    display: inline-block;
    position: absolute;
    opacity: 0;
    width: 25px;
    height: 25px;
    cursor: pointer;
    left: 0px;
    outline: none;
    -webkit-appearance: none;
  }
  .on {
    background-position: -25px 0;
  }
</style>
