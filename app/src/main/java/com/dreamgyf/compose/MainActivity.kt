package com.dreamgyf.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(Modifier.padding(10.dp)) {
                Button(onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            NewsActivity::class.java
                        )
                    )
                }) {
                    Text(text = "新闻", color = Color.White)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            ListActivity::class.java
                        )
                    )
                }) {
                    Text(text = "书库", color = Color.White)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            XmlMixComposeActivity::class.java
                        )
                    )
                }) {
                    Text(text = "xml混合compose", color = Color.White)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            ComposeMixXmlActivity::class.java
                        )
                    )
                }) {
                    Text(text = "compose混合xml", color = Color.White)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            CustomActivity::class.java
                        )
                    )
                }) {
                    Text(text = "自定义UI", color = Color.White)
                }
            }
        }
    }
}