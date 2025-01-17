package com.toretate.aigisandroidtools

/**
 * http://nosix.hatenablog.com/entry/2016/09/16/175238 より
 */
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings

fun Activity.hasOverlayPermission(): Boolean =
        if (Build.VERSION.SDK_INT >= 23) Settings.canDrawOverlays(this) else true

fun Activity.requestOverlayPermission(requestCode: Int) {
    if (Build.VERSION.SDK_INT >= 23) {
        val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))
        startActivityForResult(intent, requestCode)
    }
}