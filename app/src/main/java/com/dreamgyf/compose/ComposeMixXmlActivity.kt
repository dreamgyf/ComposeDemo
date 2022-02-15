package com.dreamgyf.compose

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.viewinterop.AndroidView

class ComposeMixXmlActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Compose Text")
                AndroidView(factory = { context ->
                    TextView(context).apply {
                        text = "传统TextView"
                    }
                })
            }
        }
    }
}