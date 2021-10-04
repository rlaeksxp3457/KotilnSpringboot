package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController         // REST API Controller 동작
@RequestMapping("/api") // http://localhost:8080/api
class GetApiController { // 가져오기

    @GetMapping(path = ["/hello", "/abcd"]) // GET http://localhost:8080/api/hello, GET http://localhost:8080/api/abcd
    fun hello(): String = "hello kotlin"

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"]) // 구방식
    fun requestMapping(): String {
        return "request-mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}") //GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name}, ${age}")
        return name + " " + age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}") //GET http://localhost:8080/api/get-mapping/path-variable/steve
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") age: Int): UserRequest {
        val user = UserRequest ().apply {
            this.name = _name
            this.age = age
        }

        println("${_name}, ${age}")
        return user
    }

    // http://localhost:8080/api/page?key=value&key=value&key=value 는 쿼리 파라미터
    @GetMapping("/get-mapping/query-param") // ?name=steve&age=20
    fun queryParam(@RequestParam name: String, @RequestParam(value = "age") age: Int): String {
        println("${name} , ${age}")
        return name + " " + age
    }

    // name, age, address, email
    // -
    // phoneNumber -> phonenumber , phone-number
    // 객체로 요청 받을시에 json 구조로 넘어온다
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    //쿼리 파라미터에 - 이 들어간 변수 가 있을시 처리 방법
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber = map.get("phone-number")
        println(phoneNumber)
        return map
    }
}