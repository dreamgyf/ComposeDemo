package com.dreamgyf.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import kotlin.math.ceil

class ListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Content(Modifier.weight(1f))
                Button(onClick = { addData() }) {
                    Text(
                        text = "模拟加载更多",
                        fontSize = 10.sp,
                        color = Color(0xffffffff),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

    @Composable
    fun Content(modifier: Modifier) {
        val columns = 3
        val rows = ceil(mDataList.size.toDouble() / columns).toInt()
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
                .then(modifier),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(rows) { rowIndex ->
                Row {
                    for (colIndex in 0 until columns) {
                        val index = rowIndex * columns + colIndex

                        if (colIndex > 0) {
                            Spacer(modifier = Modifier.weight(1f))
                        }

                        if (index >= mDataList.size) {
                            Spacer(modifier = Modifier.width(90.dp))
                        } else {
                            val data = mDataList[index]
                            Book(
                                data.coverPicUrl,
                                data.bookName,
                                data.useExtExample,
                                data.wordCount,
                                data.coins
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Book(
        coverPicUrl: String,
        bookName: String,
        useExtExample: Boolean,
        wordCount: Int,
        coins: Int
    ) {
        Column(modifier = Modifier.width(90.dp)) {
            Box(
                modifier = Modifier.clip(RoundedCornerShape(6.3.dp)),
            ) {
                Image(
                    modifier = Modifier.size(90.dp, 129.dp),
                    painter = rememberImagePainter(coverPicUrl),
                    contentDescription = null
                )
                if (coins > 0) {
                    Image(
                        modifier = Modifier
                            .width(42.dp)
                            .align(Alignment.TopEnd),
                        painter = painterResource(id = R.drawable.pic_vip_corner),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.align(Alignment.BottomStart),
                        text = "${coins}贝壳",
                        color = Color(0xfff2f2f2),
                        fontSize = 12.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = bookName,
                color = Color(0xff333333),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "${wordCount}词",
                color = Color(0xffb0b4be),
                fontSize = 11.sp
            )
        }
    }

    data class ViewModel(
        val coverPicUrl: String,
        val bookName: String,
        val useExtExample: Boolean,
        val wordCount: Int,
        val coins: Int
    )

    private val mDataList by lazy {
        mutableStateListOf<ViewModel>().apply {
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/tkdghk/12f74729c75a83e1190c777f56437c34.6ceb9390eaa338040986228a08948632.jpg?x-oss-process=image/quality,Q_80",
                    "高考考纲词汇(2021版)",
                    false,
                    3657,
                    0
                )
            )
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/verskb/4ddd6e2a4176801fa48d6dd8258bc443.45f961e9ad8ef4052ee1916cc2164b1f.png?x-oss-process=image/quality,Q_80",
                    "高考真题核心词汇书",
                    true,
                    2207,
                    2900
                )
            )
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/verskb/e514cb6a68071e34a80ab865386f4607.40c6ce0dfad376670a14cb917f6cfe81.jpeg",
                    "词根词缀巧记妙用高考重难点词汇",
                    false,
                    1342,
                    0
                )
            )
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/tkdghk/61b4afccdee6fd1dcd60509a63af5cfc.888db9c7ddeec23b5f737c1d0f6b3cc4.jpeg",
                    "外研社新版高中词汇（必修一）",
                    false,
                    409,
                    0
                )
            )
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/tkdghk/b82e54795ebf8b7d20767b125d2d0868.99ae27e4e2cf2dd0b7f3105c547fd136.jpeg",
                    "外研社新版高中词汇（必修二）",
                    false,
                    363,
                    0
                )
            )
        }
    }

    private fun addData() {
        mDataList.apply {
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/tkdghk/1edf19205b118452858ede8cea8186d6.058444ac0a55fdd1dbc8b0a6e75bc4ab.jpeg",
                    "外研社新版高中词汇（必修三）",
                    false,
                    281,
                    0
                )
            )
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/tkdghk/c62e53ddf5461b1fb6320ef72221d756.dd7876d22d807f87e619c0375dc80285.jpg?x-oss-process=image/quality,Q_80",
                    "冀教版·高中必修一",
                    false,
                    308,
                    0
                )
            )
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/tkdghk/168f1dc2c77b3d9a7bf339ce9df2ce2a.5fcb0bba9b49923584c9ed1502ed134a.jpg?x-oss-process=image/quality,Q_80",
                    "冀教版·高中必修二",
                    false,
                    254,
                    0
                )
            )
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/tkdghk/8df9bba385003f17ecd176cd5827c745.e22f947d835f68a3f6ab8e7c351e0584.jpg?x-oss-process=image/quality,Q_80",
                    "冀教版·高中必修三",
                    false,
                    197,
                    0
                )
            )
            add(
                ViewModel(
                    "https://media-image1.baydn.com/wordmaster_pub_image/verskb/1a02be0fc3b87becd3c1cfb9fbe189a5.645e445e11edd51c171bd8c4c9914e85.jpg?x-oss-process=image/quality,Q_80",
                    "译林新版高中词汇（必修一）",
                    false,
                    276,
                    0
                )
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        Content(Modifier)
    }
}