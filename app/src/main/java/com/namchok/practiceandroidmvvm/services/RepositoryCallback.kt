package com.namchok.practiceandroidspotify.services

import okhttp3.ResponseBody

interface RepositoryCallback<T> {
    fun onPreExecute()
    fun onSuccess(result: T?)
    fun onFailure(t: Throwable?)
    fun onPostExecute()
}