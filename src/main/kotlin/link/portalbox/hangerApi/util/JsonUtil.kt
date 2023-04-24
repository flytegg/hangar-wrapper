package link.portalbox.hangerApi.util

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

fun getJsonData(url: String) : JsonObject {
    return JsonParser.parseString(getClient().newCall(Request.Builder()
            .url(url)
            .header("User-Agent", "flytegg/hanger-api")
            .build()
    ).execute().body?.string()).asJsonObject
}

private fun getClient() : OkHttpClient {
    return OkHttpClient.Builder()
        .build()
}