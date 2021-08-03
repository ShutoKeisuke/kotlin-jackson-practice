package practice.kotlinjackson.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.web.bind.annotation.*
import practice.kotlinjackson.model.JsonData
import java.time.LocalTime

@RestController
@RequestMapping("json")
class JacksonPractice {

    @PostMapping(
            value=[""],
            consumes = ["application/json"]
    )
    fun postJsonData(@RequestBody json: String) {
        println("called getJsonData")
        println("----- json data -----")
        println(json)
        println("")
        val mapper = ObjectMapper().registerKotlinModule()
        mapper.registerModule(JavaTimeModule())
        val jsonData = mapper.readValue<JsonData>(json)
        println("----- json serialize -----")
        println(jsonData)
    }

    @PostMapping(value = ["converter"])
    fun postMessageConverter(@RequestBody jsonData: JsonData) {
        println("----- json serialize -----")
        println(jsonData)
    }
}