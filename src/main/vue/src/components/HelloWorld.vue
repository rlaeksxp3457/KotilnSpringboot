<template>
  <v-container>
    <v-row justify="center" align="center">
      <v-col cols="4">
        <v-card>
          <v-card-title>
            {{ name + "님 " + age + "살" }} 반갑습니다.
          </v-card-title>
          <v-card-actions>
            <v-spacer/>
            <v-btn align="center" @click="testPage">
              테스트1
            </v-btn>
            <v-btn align="center" @click="testPage2">
              테스트1
            </v-btn>
          </v-card-actions>
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
  mounted () {
    this.testPage()
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
    },
    testPage2 () {
      this.axios.get('http://localhost:8080/api/get-mapping/path-variable2/' + '테스트' + '/' + 25)
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
