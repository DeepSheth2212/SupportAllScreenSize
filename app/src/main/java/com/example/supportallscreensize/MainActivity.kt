package com.example.supportallscreensize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.supportallscreensize.ui.theme.SupportAllScreenSizeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SupportAllScreenSizeTheme {
                val windowInfo = RememberWindowInfo()
                if(windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact ){
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        items(10){
                            Text(text = "item $it" , Modifier.fillMaxWidth().background(color = Color.Green).padding(16.dp))
                        }
                        items(10){
                            Text(text = "item $it" , Modifier.fillMaxWidth().background(color =  Color.Cyan).padding(16.dp))
                        }
                    }
                }
                else{
                    Row(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LazyColumn(modifier = Modifier.weight(1f)){
                            items(10){
                                Text(text = "item $it" , Modifier.fillMaxWidth().background(color = Color.Green).padding(16.dp))
                            }
                        }
                        LazyColumn(modifier = Modifier.weight(1f)){
                            items(10){
                                Text(text = "item $it" , Modifier.fillMaxWidth().background(color = Color.Cyan).padding(16.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

