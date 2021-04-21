package com.example.myapplication

import android.content.pm.PackageManager
import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

import java.io.File

import com.artifex.solib.ArDkLib
import com.artifex.solib.ConfigOptions
import com.artifex.solib.FileUtils
import com.artifex.sonui.editor.DocumentView
import com.artifex.sonui.editor.Utilities

class MainActivity : AppCompatActivity() {
    var isSetup : Boolean = false

    private val REQUEST_EXTERNAL_STORAGE = 1

    private val PERMISSIONS_STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        var askPermission:Boolean = false
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                askPermission = true
        }

        if (askPermission) {
                // Not immediately granted, so ask.
                // We'll return in onRequestPermissionsResult()
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE)
                return
        }

        gotPermission()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
                    when (requestCode) {
                            REQUEST_EXTERNAL_STORAGE -> {
                                    // If request is cancelled, the result arrays are empty.
                                    if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                                            // Permission was granted.
                                            gotPermission()
                                    } else {
                                            // Permission denied.
                                            finish()
                                    }
                                    return
                            }
                    }
    }

    fun gotPermission() {

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            if (!isSetup) {
                Snackbar.make(view, "Setting up!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()

                Utilities.setPersistentStorage(PersistentStorage())
                ArDkLib.setClipboardHandler(ClipboardHandler())
                FileUtils.init(this)
                isSetup = true
            }
            else {
                Snackbar.make(view, "Already set up!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
            }

            var dirpath : String = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
            var filepath : String = dirpath + File.separator + "test.pdf"

            Log.e("MainActivity", filepath)

            val configOptions = ConfigOptions()

            configOptions.setOpenInEnabled(false)
            configOptions.setShareEnabled(false)
            configOptions.setPrintingEnabled(false)
            configOptions.setSaveAsEnabled(false)
            configOptions.setSaveEnabled(false)
            configOptions.setEditingEnabled(false)

            ArDkLib.setAppConfigOptions(configOptions)

            val documentView : DocumentView = findViewById<View>(R.id.doc_view) as DocumentView
            documentView.setDocConfigOptions(ArDkLib.getAppConfigOptions())
            //documentView.setDocDataLeakHandler(Utilities.getDataLeakHandlers())
            documentView.start(Uri.fromFile(File(filepath)), 0, true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
