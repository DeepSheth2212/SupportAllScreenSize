package com.example.supportallscreensize

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RememberWindowInfo() : WindowInfo  {
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenWidthInfo = when {
            //these values are suggested by android documentation
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenHeightInfo = when {
            //these values are suggested by android documentation
            configuration.screenWidthDp < 480 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        },
        screenHeight = configuration.screenHeightDp.dp ,
        screenWidth = configuration.screenWidthDp.dp
    )
}

data class WindowInfo(
    val screenWidthInfo : WindowType,
    val screenHeightInfo : WindowType,
    val screenWidth : Dp,
    val screenHeight : Dp
){
    sealed class WindowType{
        object Compact : WindowType() //for device having screen width
        object Medium : WindowType()
        object Expanded : WindowType()
    }
}

