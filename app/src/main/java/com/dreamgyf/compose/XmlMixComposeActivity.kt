package com.dreamgyf.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView

class XmlMixComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml_mix_compose)

        findViewById<ComposeView>(R.id.compose_view).setContent {
            Text(text = "Compose Text")
        }
    }
}