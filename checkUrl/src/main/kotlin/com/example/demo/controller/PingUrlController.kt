package com.example.demo.controller

import com.example.demo.model.UrlModel
import com.example.demo.service.PingUrlService
import com.example.demo.util.Responses
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.MalformedURLException
import java.net.UnknownHostException

@RestController
@RequestMapping("ping")

class PingUrlController (val pingUrlService: PingUrlService) {

    @PostMapping
    fun pingUrl(@RequestBody url: UrlModel): Responses {
        return try {
            pingUrlService.pingUrl(url.url)
        }
        catch (ex: MalformedURLException){
            Responses.MALFORMED_URL
        }catch (ex: UnknownHostException){
            Responses.UNREACHABLE_URL
        }
    }
}