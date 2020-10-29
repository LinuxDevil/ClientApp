package com.aligmohammad.doctorapp.helpers

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DataStoreHelper(context: Context): CoroutineScope {

    private val TOKEN_KEY = preferencesKey<String>("TOKEN")
    private val TIME_KEY = preferencesKey<Long>("TIME")
    private val dataStore = context.createDataStore("My_Clinic")

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    fun saveToken(token: String) {
        launch {
            dataStore.edit {
                it[TOKEN_KEY] = token
            }
        }
    }

    fun saveTime(time: Long) {
        launch {
            dataStore.edit {
                it[TIME_KEY] = time
            }
        }
    }

    fun getToken(): String = dataStore.data.map {
        it[TOKEN_KEY]
    }.toString()

    fun getTime(): Long {
        var time = 0L
        launch {
            time = dataStore.data.map {
                it[TIME_KEY] ?: 0L
            }.first()
        }
        return time
    }

}