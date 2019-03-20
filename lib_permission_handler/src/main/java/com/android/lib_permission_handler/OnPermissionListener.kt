package com.android.lib_permission_handler

interface OnPermissionListener : OnPermissionBaseListener {
    fun callBack(permissions: Array<String>, grantResults: IntArray)
}
