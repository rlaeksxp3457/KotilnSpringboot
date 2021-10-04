package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    // http://localhost:8080/main
    @GetMapping("/")
    fun main(): String {    // text "main.html"
        println("init main")
        return "index.html"
    }

    @ResponseBody
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name = "steve"
        }

       // return "main.html"
    }
}