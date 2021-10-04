<template>
  <v-container>
    <v-row justify="center" align="center">
      <v-col>
      <v-card>
        <v-card-title>
         {{ name+ "님 " + age + "살"}} 반갑습니다.
        </v-card-title>
        <v-btn @click="testPage">
          테스트
        </v-btn>
      </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      name: null,
      age: null
    }
  },
  methods: {
    testPage () {
      this.axios.get('http://localhost:8080/api/get-mapping/path-variable2/' + '이범수' + '/' + 25)
        .then(response => {
          this.name = response.data.name
          this.age = response.data.age
        }).catch(error => {
          console.log(error)
        })
    }
  }
}
</script>
