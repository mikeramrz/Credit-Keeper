package com.scavdev.creditkeeper.model

open class CreditItemEvent <out T>(private val content: T){

    var hasBeenHandled = false
    private set

    fun getContentOfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else{
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content


}