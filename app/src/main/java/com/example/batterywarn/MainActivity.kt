package com.example.batterywarn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.batterywarn.ui.theme.BatteryWarnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BatteryWarnTheme {
                BatteryView()
            }
        }

    }
}

@Composable
fun BatteryView (modifier: Modifier = Modifier) {

    val status = remember {

        mutableIntStateOf(R.drawable.battery_low)
    }

    val context = LocalContext.current


    var batteryStatus =BatteryStatus(status).analyse(context, status)

    Box (modifier  = modifier.fillMaxSize()){

        Image(

            painter = painterResource(id = status.intValue ),
            contentDescription = null,

            modifier = modifier.fillMaxSize(),
        )
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BatteryPreview() {

    BatteryWarnTheme {
        BatteryView()
    }

}