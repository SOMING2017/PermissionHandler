package com.android.lib_permission_handler

/**
 * Created on 2019/3/1.14:33
 *
 * @author song
 */
interface OnPermissionSingleListener : OnPermissionBaseListener {
    fun success()
    fun fail()
}
