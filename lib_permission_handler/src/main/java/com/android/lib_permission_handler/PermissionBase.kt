package com.android.lib_permission_handler

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.LinkedHashMap

abstract class PermissionBase {
    //获取码处理
    private var requestCodeCache = 0
    private val requestCodeCacheMax = 1000
    private val requestCode: Int
        get() {
            requestCodeCache++
            if (requestCodeCache > requestCodeCacheMax) {
                requestCodeCache %= requestCodeCacheMax
            }
            return requestCodeCache
        }
    //权限暂存属性
    private val permissionCache = LinkedHashMap<Int, PermissionItem>()

    /**
     * 检查单个权限的方法
     */
    protected fun checkSinglePermission(
        @NonNull context: Context,
        @NonNull permission: String
    ): Boolean {
        val permissionCheckInfo = ContextCompat.checkSelfPermission(context, permission)
        return permissionCheckInfo == PackageManager.PERMISSION_GRANTED
    }

    /**
     * 获取单个权限的方法
     */
    protected fun requestSinglePermission(
        @NonNull activity: Activity,
        @NonNull permission: String,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        if (!checkSinglePermission(activity, permission)) {
            val requestCode = requestCode
            save(requestCode, onPermissionSingleListener)
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(permission),
                requestCode
            )
        } else {
            onPermissionSingleListener.success()
        }
    }

    //权限暂存方法
    private fun save(
        requestCode: Int,
        onPermissionListener: OnPermissionListener
    ) {
        permissionCache[requestCode] = PermissionItem(
            onPermissionListener,
            false
        )
    }

    protected fun save(
        requestCode: Int,
        onPermissionSingleListener: OnPermissionSingleListener
    ) {
        permissionCache[requestCode] = PermissionItem(
            onPermissionSingleListener,
            false
        )
    }

    protected fun save(
        requestCode: Int,
        onPermissionActivityListener: OnPermissionActivityListener
    ) {
        permissionCache[requestCode] = PermissionItem(
            onPermissionActivityListener,
            true
        )
    }

    //权限处理方法
    fun handle(
        requestCode: Int,
        @NonNull permissions: Array<String>,
        @NonNull grantResults: IntArray
    ) {
        if (!permissionCache.containsKey(requestCode)) {
            return
        }
        val permissionItem = permissionCache[requestCode] ?: return
        if (permissionItem.isActivityPermission == false) {
            //permission deal
            val listener = permissionItem.listener
            if (listener == null) {
                permissionCache.remove(requestCode)
                return
            }
            if (listener is OnPermissionSingleListener) {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    listener.success()
                } else {
                    listener.fail()
                }
            }
            if (listener is OnPermissionListener) {
                listener.callBack(permissions, grantResults)
            }
        }
        permissionCache.remove(requestCode)
    }

    fun handle(
        requestCode: Int,
        resultCode: Int,
        @Nullable data: Intent?
    ) {
        if (!permissionCache.containsKey(requestCode)) {
            return
        }
        val permissionItem = permissionCache[requestCode] ?: return
        if (permissionItem.isActivityPermission == false) {
            //activity permission deal
            val listener = permissionItem.listener
            if (listener == null) {
                permissionCache.remove(requestCode)
                return
            }
            if (resultCode == Activity.RESULT_OK) {
                (listener as? OnPermissionActivityListener)?.success(data)
            } else {
                (listener as? OnPermissionActivityListener)?.fail(data)
            }
        }
        permissionCache.remove(requestCode)
    }

    private inner class PermissionItem internal constructor(
        internal var listener: OnPermissionBaseListener?,
        internal var isActivityPermission: Boolean?
    )

}