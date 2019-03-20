package com.android.lib_permission_handler.utils

class IntUtils {
    companion object {
        fun isZero(num:Int):Boolean{
            return num == 0
        }

        fun isNotZero(num:Int):Boolean{
            return !isZero(num)
        }
    }
}