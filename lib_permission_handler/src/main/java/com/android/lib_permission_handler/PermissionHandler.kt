package com.android.lib_permission_handler

import android.Manifest
import android.app.Activity
import android.content.Context
import android.os.Build

//todo
//import cn.monkeyfly.eir.common.utils.DialogUtils

import android.os.Build.VERSION.SDK_INT
import androidx.annotation.NonNull
import androidx.core.app.NotificationManagerCompat

/**
 * Created on 2019/3/1.13:42
 *
 * @author song
 */
class PermissionHandler private constructor() : PermissionBase() {
    //自定义检查权限方法
    fun checkReadCalendar(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.READ_CALENDAR)
    }

    fun checkWriteCalendar(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.WRITE_CALENDAR)
    }

    fun checkCamera(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.CAMERA)
    }

    fun checkReadContacts(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.READ_CONTACTS)
    }

    fun checkWriteContacts(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.WRITE_CONTACTS)
    }

    fun checkGetAccounts(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.GET_ACCOUNTS)
    }

    fun checkAccessFineLocation(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
    }

    fun checkAccessCoarseLocation(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    fun checkRecordAudio(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.RECORD_AUDIO)
    }

    fun checkReadPhoneState(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.READ_PHONE_STATE)
    }

    fun checkCallPhone(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.CALL_PHONE)
    }

    fun checkReadCallLog(
        @NonNull context: Context
    ): Boolean {
        return if (SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            checkSinglePermission(context, Manifest.permission.READ_CALL_LOG)
        } else {
            false
        }
    }

    fun checkWriteCallLog(
        @NonNull context: Context
    ): Boolean {
        return if (SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            checkSinglePermission(context, Manifest.permission.WRITE_CALL_LOG)
        } else {
            false
        }
    }

    fun checkAddVoiceMail(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.ADD_VOICEMAIL)
    }

    fun checkUseSip(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.USE_SIP)
    }

    fun checkProcessOutGoingCalls(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.PROCESS_OUTGOING_CALLS)
    }

    fun checkBodySensors(
        @NonNull context: Context
    ): Boolean {
        return if (SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            checkSinglePermission(context, Manifest.permission.BODY_SENSORS)
        } else {
            false
        }
    }

    fun checkSendSMS(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.SEND_SMS)
    }

    fun checkReceiveSMS(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.RECEIVE_SMS)
    }

    fun checkReadSMS(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.READ_SMS)
    }

    fun checkReceiveWapPush(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.RECEIVE_WAP_PUSH)
    }

    fun checkReceiveMMS(
        @NonNull context: Context
    ): Boolean {
        return checkSinglePermission(context, Manifest.permission.RECEIVE_MMS)
    }

    fun checkReadExternalStorage(
        @NonNull context: Context
    ): Boolean {
        return if (SDK_INT < Build.VERSION_CODES.M) {
            true
        } else checkSinglePermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    fun checkWriteExternalStorage(
        @NonNull context: Context
    ): Boolean {
        return if (SDK_INT < Build.VERSION_CODES.M) {
            true
        } else checkSinglePermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    /**
     * 检查通知权限
     */
    fun checkNotification(
        @NonNull context: Context
    ): Boolean {
        val notificationManagerCompat = NotificationManagerCompat.from(context)
        return notificationManagerCompat.areNotificationsEnabled()
    }

    //自定义获取权限处理方法
    /**
     * 获取读取日历权限
     */
    fun requestReadCalendar(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.READ_CALENDAR,
            onPermissionSingleListener
        )
    }

    /**
     * 获取编辑日历权限
     */
    fun requestWriteCalendar(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.WRITE_CALENDAR,
            onPermissionSingleListener
        )
    }

    /**
     * 获取相机权限
     */
    fun requestCamera(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.CAMERA,
            onPermissionSingleListener
        )
    }

    /**
     * 获取读取联系人权限
     */
    fun requestReadContacts(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.READ_CONTACTS,
            onPermissionSingleListener
        )
    }

    /**
     * 获取编辑联系人权限
     */
    fun requestWriteContacts(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.WRITE_CONTACTS,
            onPermissionSingleListener
        )
    }

    /**
     * 通讯录权限
     */
    fun requestGetAccounts(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.GET_ACCOUNTS,
            onPermissionSingleListener
        )
    }

    /**
     * 获取位置服务权限
     */
    fun requestAccessFineLocation(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.ACCESS_FINE_LOCATION,
            onPermissionSingleListener
        )
    }

    fun requestAccessCoarseLocation(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            onPermissionSingleListener
        )
    }

    /**
     * 获取麦克风权限
     */
    fun requestRecordAudio(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.RECORD_AUDIO,
            onPermissionSingleListener
        )
    }

    /**
     * 获取读取本机识别码权限
     */
    fun requestReadPhoneState(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.READ_PHONE_STATE,
            onPermissionSingleListener
        )
    }

    /**
     * 获取电话权限
     */
    fun requestCallPhone(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.CALL_PHONE,
            onPermissionSingleListener
        )
    }

    /**
     * 获取读取通话记录权限
     */
    fun requestReadCallLog(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        if (SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            requestSinglePermission(
                activity,
                Manifest.permission.READ_CALL_LOG,
                onPermissionSingleListener
            )
        } else {
            onPermissionSingleListener.fail()
        }
    }

    /**
     * 获取编辑通话记录权限
     */
    fun requestWriteCallLog(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        if (SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            requestSinglePermission(
                activity,
                Manifest.permission.WRITE_CALL_LOG,
                onPermissionSingleListener
            )
        } else {
            onPermissionSingleListener.fail()
        }
    }

    /**
     * 获取新增语音邮件权限
     */
    fun requestAddVoiceMail(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.ADD_VOICEMAIL,
            onPermissionSingleListener
        )
    }

    /**
     * 获取SIP网络通话权限
     */
    fun requestUseSip(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.USE_SIP,
            onPermissionSingleListener
        )
    }

    /**
     * 获取监听、控制、取消呼出电话权限
     */
    fun requestProcessOutgoingCalls(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.PROCESS_OUTGOING_CALLS,
            onPermissionSingleListener
        )
    }

    /**
     * 获取人体传感器权限
     */
    fun requestBodySensors(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        if (SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            requestSinglePermission(
                activity,
                Manifest.permission.BODY_SENSORS,
                onPermissionSingleListener
            )
        } else {
            onPermissionSingleListener.fail()
        }
    }

    /**
     * 获取发送短信权限
     */
    fun requestSendSMS(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.SEND_SMS,
            onPermissionSingleListener
        )
    }

    /**
     * 获取接收短信权限
     */
    fun requestReceiveSMS(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.RECEIVE_SMS,
            onPermissionSingleListener
        )
    }

    /**
     * 获取读取短信权限
     */
    fun requestReadSMS(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.READ_SMS,
            onPermissionSingleListener
        )
    }

    /**
     * 获取接收wap push权限
     */
    fun requestReceiveWapPush(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.RECEIVE_WAP_PUSH,
            onPermissionSingleListener
        )
    }

    /**
     * 获取接收彩信权限
     */
    fun requestReceiveMMS(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        requestSinglePermission(
            activity,
            Manifest.permission.RECEIVE_MMS,
            onPermissionSingleListener
        )
    }

    /**
     * 获取读取文件权限
     */
    fun requestReadExternalStorage(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        if (SDK_INT < Build.VERSION_CODES.M) {
            onPermissionSingleListener.success()
            return
        }
        requestSinglePermission(
            activity,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            onPermissionSingleListener
        )
    }

    /**
     * 获取写入文件权限（包含读取文件权限）
     */
    fun requestWriteExternalStorage(
        @NonNull activity: Activity,
        @NonNull onPermissionSingleListener: OnPermissionSingleListener
    ) {
        if (SDK_INT < Build.VERSION_CODES.M) {
            onPermissionSingleListener.success()
            return
        }
        requestSinglePermission(
            activity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            onPermissionSingleListener
        )
    }

    /**
     * 自定义获取未知软件安装程序
     */
    @Deprecated(level = DeprecationLevel.HIDDEN,message = "待完善")
    fun requestPackageInstalls(
        @NonNull activity: Activity,
        @NonNull onPermissionActivityListener: OnPermissionActivityListener
    ) {
        if (SDK_INT > Build.VERSION_CODES.O) {
            if (activity.packageManager.canRequestPackageInstalls()) {
                onPermissionActivityListener.success(null)
            } else {
                //todo
//                DialogUtils.showCancelOkCenterTipDialog(
//                    activity,
//                    activity.getString(R.string.request_package_installs_tip),
//                    object : DialogUtils.OnDialogClickListener() {
//                        fun ok() {
//                            val requestCode = requestCode
//                            val packageURI = Uri.parse("package:" + activity.packageName)
//                            val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI)
//                            save(requestCode, onPermissionActivityListener)
//                            activity.startActivityForResult(intent, requestCode)
//                        }
//
//                        fun cancel() {
//                            onPermissionActivityListener.fail(null)
//                        }
//                    }
//                )
            }
        } else {
            onPermissionActivityListener.success(null)
        }
    }

    companion object {
        val instance = PermissionHandler()
    }
}


