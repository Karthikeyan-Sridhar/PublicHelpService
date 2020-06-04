package com.developersinc.publichelpservice.Interface

interface LoginResultCallbacks {

    fun onSuccess(message:String)

    fun onError(message: String)

    fun login()

}