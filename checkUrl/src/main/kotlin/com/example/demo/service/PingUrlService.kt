package com.example.demo.service

import com.example.demo.util.Responses
import org.springframework.stereotype.Service
import java.net.*

@Service
class PingUrlService {

    fun pingUrl(url: URL) : Responses {
        return when (
            try {
                val urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.requestMethod = "HEAD"
                urlConnection.responseCode
            }
            catch (ex: UnknownHostException){ throw UnknownHostException() }
            catch (ex: MalformedURLException){ throw MalformedURLException() }
        ) {
            200 -> {
                Responses.REACHABLE_URL
            }
            else -> {
                Responses.UNREACHABLE_URL
            }
        }
    }
}