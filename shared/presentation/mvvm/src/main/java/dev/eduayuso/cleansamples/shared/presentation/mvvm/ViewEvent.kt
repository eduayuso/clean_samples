package dev.eduayuso.cleansamples.shared.presentation.mvvm

open class ViewEvent<out T>(private val content: T) {

    var dispatched = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContent(): T? {
        return if (dispatched) {
            null
        } else {
            dispatched = true
            content
        }
    }
}
