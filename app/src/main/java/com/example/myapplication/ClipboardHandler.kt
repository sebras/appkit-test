package com.example.myapplication

import android.app.Activity
import android.util.Log
import com.artifex.solib.SOClipboardHandler

class ClipboardHandler : SOClipboardHandler {
    override fun putPlainTextToClipboard(p0: String?) {
        Log.e("ClipboardHandler", "putPlainTextToClipBoard")
    }

    override fun getPlainTextFromClipoard(): String? {
        Log.e("ClipboardHandler", "getPlainTextFromClipBoard")
        return null
    }

    override fun clipboardHasPlaintext(): Boolean {
        Log.e("ClipboardHandler", "clipboardHasPlainText")
        return false
    }

    override fun initClipboardHandler(p0: Activity?) {
        Log.e("ClipboardHandler", "initclipboardHandler")
    }
}