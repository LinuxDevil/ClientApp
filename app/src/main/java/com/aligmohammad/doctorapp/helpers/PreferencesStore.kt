package com.aligmohammad.doctorapp.helpers

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PreferencesStore @Inject constructor(context: Context) {

    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(
            name = "my_data_store"
        )
    }

    val accessToken: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[ACCESS_TOKEN]
        }

    val firebaseUser: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[FIREBASE_USER]
        }

    val lanuage: Flow<String?>
        get() = dataStore.data.map { pref -> pref[LANGUAGE_KEY] }

    val refreshToken: Flow<String?>
        get() = dataStore.data.map { preferences ->
            preferences[REFRESH_TOKEN]
        }

    suspend fun saveLanguage(lang: String) {
        dataStore.edit { pref -> pref[LANGUAGE_KEY] = lang }
    }

    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = accessToken
            preferences[REFRESH_TOKEN] = refreshToken
        }
    }

    suspend fun saveFirebaseUser(firebaseUser: String) {
        dataStore.edit { pref ->
            pref[FIREBASE_USER] = firebaseUser
        }
    }

    suspend fun clear() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("key_access_token")
        private val REFRESH_TOKEN = stringPreferencesKey("key_refresh_token")
        private val FIREBASE_USER = stringPreferencesKey("key_firebase_user")
        private val LANGUAGE_KEY = stringPreferencesKey("key_language")
    }

}