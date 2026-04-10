package com.fruitid.data.local.prefs

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Singleton
class SettingsPrefs @Inject constructor(
    private val context: Context
) {
    private val dataStore = context.dataStore

    companion object {
        val ALLOW_MOBILE_DATA = booleanPreferencesKey("allow_mobile_data")
        val DOWNLOAD_PROGRESS_BYTES = longPreferencesKey("download_progress_bytes")
        val MODEL_VERSION = stringPreferencesKey("model_version")
        val FIRST_DOWNLOAD_COMPLETE = booleanPreferencesKey("first_download_complete")
        val LAST_CLEANUP_TIMESTAMP = longPreferencesKey("last_cleanup_timestamp")
    }

    val allowMobileData: Flow<Boolean> = dataStore.data
        .map { it[ALLOW_MOBILE_DATA] ?: false }

    val downloadProgressBytes: Flow<Long> = dataStore.data
        .map { it[DOWNLOAD_PROGRESS_BYTES] ?: 0L }

    val modelVersion: Flow<String> = dataStore.data
        .map { it[MODEL_VERSION] ?: "" }

    val firstDownloadComplete: Flow<Boolean> = dataStore.data
        .map { it[FIRST_DOWNLOAD_COMPLETE] ?: false }

    val lastCleanupTimestamp: Flow<Long> = dataStore.data
        .map { it[LAST_CLEANUP_TIMESTAMP] ?: 0L }

    suspend fun setAllowMobileData(value: Boolean) {
        dataStore.edit { it[ALLOW_MOBILE_DATA] = value }
    }

    suspend fun setDownloadProgressBytes(bytes: Long) {
        dataStore.edit { it[DOWNLOAD_PROGRESS_BYTES] = bytes }
    }

    suspend fun clearDownloadProgress() {
        dataStore.edit { it.remove(DOWNLOAD_PROGRESS_BYTES) }
    }

    suspend fun setModelVersion(version: String) {
        dataStore.edit { it[MODEL_VERSION] = version }
    }

    suspend fun setFirstDownloadComplete(value: Boolean) {
        dataStore.edit { it[FIRST_DOWNLOAD_COMPLETE] = value }
    }

    suspend fun setLastCleanupTimestamp(timestamp: Long) {
        dataStore.edit { it[LAST_CLEANUP_TIMESTAMP] = timestamp }
    }
}
