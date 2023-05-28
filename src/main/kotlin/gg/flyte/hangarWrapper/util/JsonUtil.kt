package gg.flyte.hangarWrapper.util

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

/**
 * Retrieves a [JsonObject] containing data retrieved from a specified URL.
 *
 * @param url The URL to retrieve data from.
 * @return A [JsonObject] containing data retrieved from the specified URL.
 * @throws IOException if there was an error during the HTTP request.
 */
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