const path = require('path')

module.exports = {
  devServer: {
    port: 8081,
    proxy: 'http://localhost:8080',
    disableHostCheck: true
  },

  outputDir: path.resolve(__dirname, '../resources/static/dist'),

  transpileDependencies: [
    'vuetify'
  ]
}
