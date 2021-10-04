<template>
  <div class="about">
    <h1>{{name + age}}</h1>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      user: null
    }
  },
  methods: {
    async testPage () {
      await axios.get('http://localhost:8080/api/get-mapping/path-variable2/', { name: '이범수', age: 20 })
        .then(response => {
          this.user = response.data
        }).catch(error => {
          console.log(error)
        })
    }
  },
  mounted: (
    this.testPage()
  )
}
</script>
