package gg.flyte.hangerApi

import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

class HangarClientThread : ThreadFactory {
    private var threadCount = AtomicInteger(1)
    
    /**
     * Creates a new [Thread] that executes the specified [Runnable] with a custom name.
     *
     * @param r The [Runnable] to be executed by the new thread.
     * @return A new [Thread] that executes the specified [Runnable].
     */
    override fun newThread(r: Runnable): Thread {
        return Thread(r, "HangarClientThread-${threadCount.getAndIncrement()}")
    }
}
