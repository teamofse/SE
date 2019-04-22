<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <form>
      <input type="file" id="saveImage" name="myphoto" accept="image/png,image/gif,image/jpeg"
             ref="new_image">
      <button @click="addImage">确认添加</button>
    </form>
  </div>
</template>
<script>
  export default {
    name: 'uploadfile',
    data () {
      return {
        msg: 'Welcome to Your Vue.js App',
        file: ''
      }
    },
    methods: {
      addImage: function () {
        let self = this
        if (self.$refs.new_image.files.length !== 0) {
          var formData = new FormData()
          formData.append('image_data', self.$refs.new_image.files[0])
          // 单个文件进行上传
          self.$ajax.post('/addImage', formData, {
            headers: {
              'Content-Type': 'multipart/form-data'
            }
          }).then(response => {

          })
        }
      }
    }
  }
</script>
