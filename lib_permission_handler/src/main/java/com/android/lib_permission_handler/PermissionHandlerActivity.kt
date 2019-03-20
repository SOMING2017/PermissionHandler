package com.android.lib_permission_handler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.android.lib_permission_handler.utils.IntUtils

open class PermissionHandlerActivity: AppCompatActivity() {
    open val permissionHandler = PermissionHandler.instance

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        permissionHandler.handle(requestCode, resultCode, data)
        //使fragment下的onActivityResult生效
        if (IntUtils.isNotZero(supportFragmentManager.fragments.count())) {
            val fragments = supportFragmentManager.fragments
            for (fragment in fragments) {
                fragment.onActivityResult(requestCode, resultCode, data)
                if (IntUtils.isNotZero(fragment.childFragmentManager.fragments.count())) {
                    val childFragments = fragment.childFragmentManager.fragments
                    for (childFragment in childFragments) {
                        childFragment.onActivityResult(requestCode, resultCode, data)
                    }
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionHandler.handle(requestCode, permissions, grantResults)
        //使fragment下的onRequestPermissionsResult生效
        if (IntUtils.isNotZero(supportFragmentManager.fragments.count())) {
            val fragments = supportFragmentManager.fragments
            for (fragment in fragments) {
                fragment.onRequestPermissionsResult(requestCode, permissions, grantResults)
                if (IntUtils.isNotZero(fragment.childFragmentManager.fragments.count())) {
                    val childFragments = fragment.childFragmentManager.fragments
                    for (childFragment in childFragments) {
                        childFragment.onRequestPermissionsResult(requestCode, permissions, grantResults)
                    }
                }
            }
        }
    }
}