import com.google.gson.Gson
import com.google.gson.GsonBuilder
import link.portalbox.hangerApi.HangarClient
import link.portalbox.hangerApi.implementation.Platform
import org.apache.commons.io.FileUtils
import java.io.File
import java.net.URL

fun main() {
    val externalProject = HangarClient.getProject("Stephen", "PluginPortal")
    val externalVersions = HangarClient.getVersions(externalProject.namespace.owner, externalProject.namespace.slug)
    val externalDownloadURL = HangarClient.getDownloadURL(externalProject.namespace.owner, externalProject.namespace.slug, externalVersions.result[0].name, Platform.PAPER)
    FileUtils.copyURLToFile(URL(externalDownloadURL), File("external.jar"))
    println(externalDownloadURL)

    val internalProject = HangarClient.getProject("kennytv", "Maintenance")
    val internalVersions = HangarClient.getVersions(internalProject.namespace.owner, internalProject.namespace.slug)
    val internalDownloadURL = HangarClient.getDownloadURL(internalProject.namespace.owner, internalProject.namespace.slug, internalVersions.result[0].name, Platform.PAPER)
    FileUtils.copyURLToFile(URL(internalDownloadURL), File("internal.jar"))
    println(internalDownloadURL)

}

