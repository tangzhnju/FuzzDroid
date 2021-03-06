package me.zhenhao.forced.frameworkevents

import com.android.ddmlib.IDevice

import me.zhenhao.forced.commandlinelogger.LogHelper
import me.zhenhao.forced.commandlinelogger.MyLevel

class PhoneRestartEvent : FrameworkEvent() {

    override fun onEventReceived(device: IDevice): Any? {
        try {
            device.reboot(null)
            LogHelper.logEvent(MyLevel.RESTART, "App restarted event sent")
        } catch (e: Exception) {
            LogHelper.logEvent(MyLevel.EXCEPTION_ANALYSIS, "Not able to reboot device...: " + e.message)
            e.printStackTrace()
        }

        return null
    }

    override fun toString(): String {
        return "PhoneRestartEvent"
    }
}
