import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

private const val TIME_OUT = 6000

val httpClientAndroid= HttpClient(Android){

    install(JsonFeature){

        serializer= KotlinxSerializer(kotlinx.serialization.json.Json{
            prettyPrint= true
            isLenient= true
            ignoreUnknownKeys= true
        })

        engine {
            connectTimeout= TIME_OUT
            socketTimeout= TIME_OUT
        }
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("Logger Ktor =>", message)
            }

        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
        header("X-Api-Key", "19f5197b0bc7443992e44a17351a0b02")
    }
}