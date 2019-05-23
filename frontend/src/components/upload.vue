<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <form>
      <input type="file" @change="getFile($event)">
      <button class="button button-primary button-pill button-small" @click="submit($event)">提交</button>
    </form>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'upload',
    data () {
      return {
        msg: 'Welcome to Your Vue.js App',
        file: ''
      }
    },
    methods: {
      getFile: function (event) {
        this.file = event.target.files[0]
        console.log(this.file)
      },
      submit: function (event) {
        // 阻止元素发生默认的行为
        event.preventDefault()
        let formData = new FormData()
        formData.append('file', this.file)
        axios.post('/upload/singlefile', formData)
          .then(function (response) {
            alert(response.data)
            console.log(response)
            window.location.reload()
          })
          .catch(function (error) {
            console.log(error)
            window.location.reload()
          })
      }
    }
  }
</script>
