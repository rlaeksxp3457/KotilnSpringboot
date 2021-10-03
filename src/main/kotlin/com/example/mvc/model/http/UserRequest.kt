package com.example.mvc.model.http

//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class) // 전역으로 속성지정
data class UserRequest(
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var address: String? = null,
   // @JsonProperty("phone_number") 코틀린은 카멜 표기법 Json 은 스네이크 표기법 이라 컨벤션 문제가 발생하여 어노테이션으로 처리
    var phoneNumber: String?= null // phone_number
)

/*
{
    "result" : {
        "result_code" : "OK",
        "result_message" : "성공"
    },
    "description" : "~~~~~~~",
    "user" : [
        {
            "name" : "steve",
            "age", : "10",
            "email" : "",
            "phoneNumber" : ""
        },
        {
            "name" : "a",
            "age", : "20",
            "email" : "",
            "phoneNumber" : ""
        },
        {
            "name" : "b",
            "age", : "30",
            "email" : "",
            "phoneNumber" : ""
        }
    ]
}
*/
