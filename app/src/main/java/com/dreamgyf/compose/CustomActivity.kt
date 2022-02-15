package com.dreamgyf.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class CustomActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Demo()
            Modifier.padding()
        }
    }
}

@Composable
fun Demo() {
    MyLayout {
        Text(text = "Text1")
        HorizontalLine(Modifier.width(50.dp))
        Text(text = "Text2")
    }
}

@Composable
fun MyLayout(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        //测量每个子布局
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        //设置布局大小为最大可容纳大小
        layout(constraints.maxWidth, constraints.maxHeight) {
            var xPosition = 0
            var yPosition = 0

            //放置每个子View
            placeables.forEach { placeable ->
                placeable.placeRelative(x = xPosition, y = yPosition)

                //下一个子View的坐标为上一个子View的右下角
                xPosition += placeable.width
                yPosition += placeable.height
            }
        }
    }
}

@SuppressLint("ModifierParameter")
@Composable
fun HorizontalLine(modifier: Modifier = Modifier.fillMaxWidth()) {
    Canvas(modifier = Modifier
        .then(modifier), onDraw = {
        drawLine(color = Color.Black, Offset(0f, 0f), Offset(size.width, 0f), 2f)
    })
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MyLayout {
        Text(text = "Text1")
        HorizontalLine(Modifier.width(50.dp))
        Text(text = "Text2")
    }
}