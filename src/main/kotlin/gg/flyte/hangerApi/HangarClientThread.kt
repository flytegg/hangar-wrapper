package gg.flyte.hangerApi

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

class HangarClientThread : ThreadFactory {

    private var threadCount = AtomicInteger(1)

    override fun newThread(r: Runnable): Thread {
        return Thread(r, "HangarClientThread-${threadCount.getAndIncrement()}")
    }
}
