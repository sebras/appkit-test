package com.example.myapplication

import android.content.Context
import android.util.Log
import com.artifex.sonui.editor.SOPersistentStorage;

class PersistentStorage : SOPersistentStorage {
    override fun getStorageObject(p0: Context?, p1: String?): Any? {
        Log.e("PersistentStorage", "getStorageObject(" + p1 + ")")
        return null
    }

    override fun setStringPreference(p0: Any?, p1: String?, p2: String?) {
        Log.e("PersistentStorage", "setStorageObject(" + p1 + ", " + p2 + ")")
    }

    override fun getStringPreference(p0: Any?, p1: String?, p2: String?): String? {
        Log.e("PersistentStorage", "getStringPreference(" + p1  + ", " + p2 + ")")
        return null
    }

    override fun getAllStringPreferences(p0: Any?): MutableMap<String, *>? {
        Log.e("PersistentStorage", "getAllStringPreferences")
        return null
    }

    override fun removePreference(p0: Any?, p1: String?) {
        Log.e("PersistentStorage", "removePreference")
    }
}