package com.example.myapplication

import com.artifex.solib.SOSecureFS
import android.util.Log

class SecureFS : SOSecureFS {
    override fun isSecurePath(p0: String?): Boolean {
        Log.e("SecureFS", "isSecurePath")
        return false
    }

    override fun getTempPath(): String? {
        Log.e("SecureFS", "getTempPath")
        return null
    }

    override fun getFileAttributes(p0: String?): SOSecureFS.FileAttributes? {
        Log.e("SecureFS", "getFileAttribute")
        return null
    }

    override fun renameFile(p0: String?, p1: String?): Boolean {
        Log.e("SecureFS", "renameFile")
        return false
    }

    override fun copyFile(p0: String?, p1: String?): Boolean {
        Log.e("SecureFS", "copyFile")
        return false
    }

    override fun deleteFile(p0: String?): Boolean {
        Log.e("SecureFS", "deleteFile")
        return false
    }

    override fun fileExists(p0: String?): Boolean {
        Log.e("SecureFS", "fileExists")
        return false
    }

    override fun recursivelyRemoveDirectory(p0: String?): Boolean {
        Log.e("SecureFS", "recursivelyRemoveDirectory")
        return false
    }

    override fun createDirectory(p0: String?): Boolean {
        Log.e("SecureFS", "createDirectory")
        return false
    }

    override fun createFile(p0: String?): Boolean {
        Log.e("SecureFS", "createFile")
        return false
    }

    override fun getFileHandleForReading(p0: String?): Any? {
        Log.e("SecureFS", "getfileHandlerForReading")
        return null
    }

    override fun getFileHandleForWriting(p0: String?): Any? {
        Log.e("SecureFS", "getFileHandleForWriting")
        return null
    }

    override fun getFileHandleForUpdating(p0: String?): Any? {
        Log.e("SecureFS", "getFileHandleForUpdating")
        return null
    }

    override fun closeFile(p0: Any?): Boolean {
        Log.e("SecureFS", "closeFile")
        return true
    }

    override fun setFileLength(p0: Any?, p1: Long): Boolean {
        Log.e("SecureFS", "setFileLength")
        return false
    }

    override fun readFromFile(p0: Any?, p1: ByteArray?): Int {
        Log.e("SecureFS", "readFromFile")
        return 0
    }

    override fun writeToFile(p0: Any?, p1: ByteArray?): Int {
        Log.e("SecureFS", "writeToFile")
        return 0
    }

    override fun syncFile(p0: Any?): Boolean {
        Log.e("SecureFS", "syncFile")
        return false
    }

    override fun getFileLength(p0: Any?): Long {
        Log.e("SecureFS", "getFileLength")
        return 0
    }

    override fun getFileOffset(p0: Any?): Long {
        Log.e("SecureFS", "getFileOffset")
        return 0
    }

    override fun seekToFileOffset(p0: Any?, p1: Long): Boolean {
        Log.e("SecureFS", "seekToFileOffset")
        return false
    }

    override fun getSecurePath(): String? {
        Log.e("SecureFS", "getSecurePath")
        return null
    }

    override fun getSecurePrefix(): String? {
        Log.e("SecureFS", "getSecurePrefix")
        return null
    }
}