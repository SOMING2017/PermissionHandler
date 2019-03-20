package com.android.lib_permission_handler

import android.content.Intent

interface OnPermissionActivityListener : OnPermissionBaseListener {
    fun success(data: Intent?)
    fun fail(data: Intent?)
}
