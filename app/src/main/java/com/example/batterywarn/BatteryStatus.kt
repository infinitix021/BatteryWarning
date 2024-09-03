package com.example.batterywarn

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.runtime.MutableState

class BatteryStatus(private var status: MutableState<Int>): BroadcastReceiver() {

    fun analyse (context: Context, batteryImage : MutableState<Int>)
    {
        context.registerReceiver(

            BatteryStatus(batteryImage), IntentFilter(Intent.ACTION_BATTERY_LOW).apply {

                addAction(Intent.ACTION_BATTERY_OKAY)
            }

        )
    }

    override fun onReceive(context: Context, intent: Intent) {

        if ( intent.action == Intent.ACTION_BATTERY_OKAY)
            status.value = R.drawable.battery_full

        else if (intent.action == Intent.ACTION_BATTERY_LOW)
            status.value = R.drawable.battery_low

    }

}
