package com.dreamgyf.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import java.text.DecimalFormat

class NewsActivity : ComponentActivity() {

    private val mDecimalFormat = DecimalFormat("##0.0")

    private var mCategory by mutableStateOf("")

    private var mTitleEn by mutableStateOf("")

    private var mTitleCn by mutableStateOf("")

    private var mPicUrl by mutableStateOf("")

    private var mReadCount by mutableStateOf(0)

    private var mTag by mutableStateOf("")

    private var mLength by mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Content(mCategory, mTitleEn, mTitleCn, mPicUrl, mReadCount, mTag, mLength)
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = { updateData() }) {
                    Text(
                        text = "模拟网络数据",
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
    fun Content(
        category: String,
        titleEn: String,
        titleCn: String,
        picUrl: String,
        readCount: Int,
        tag: String,
        length: Int
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(24.dp, 16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            )
            {
                Text(
                    text = "- 搭配阅读听力 提升更快 -",
                    fontSize = 10.sp,
                    letterSpacing = 2.sp,
                    color = Color(0xff999999),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(13.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    painter = painterResource(id = R.drawable.tag),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = category, fontSize = 12.sp, color = Color(0xff91c954))
            }
            Spacer(modifier = Modifier.height(2.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = titleEn,
                        fontSize = 16.sp,
                        color = Color(0xff333333),
                        maxLines = 2,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = titleCn,
                        fontSize = 12.sp,
                        color = Color(0xff999999),
                        maxLines = 1
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Box(contentAlignment = Alignment.BottomEnd) {
                    Image(
                        modifier = Modifier
                            .size(68.dp, 68.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        contentScale = ContentScale.Crop,
                        painter = rememberImagePainter(picUrl),
                        contentDescription = null
                    )
                    Column {
                        Row {
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0x66000000))
                                    .padding(4.dp, 0.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_book),
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(2.dp))
                                val readCountStr = if (readCount >= 10000) {
                                    mDecimalFormat.format(readCount.toDouble() / 10000) + "万"
                                } else {
                                    "${readCount}人"
                                }
                                Text(
                                    text = readCountStr,
                                    fontSize = 10.sp,
                                    color = Color(0xffffffff),
                                    maxLines = 1
                                )
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color(0x1a91c954))
                        .padding(4.dp, 0.dp)
                ) {
                    Text(
                        text = tag,
                        fontSize = 11.sp,
                        color = Color(0xff91c954),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.vocab_count),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${length}词",
                    fontSize = 11.sp,
                    color = Color(0xff666666)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                JumpCard(
                    Modifier.weight(1f),
                    backgroundColor = Color(0xffe6faf4),
                    textColor = Color(0xff00c1a3),
                    iconPainter = painterResource(id = R.drawable.icon_walkman),
                    title = "随身听",
                    subtitle = "听词磨耳朵"
                ) {
                    Toast.makeText(this@NewsActivity, "跳转随身听", Toast.LENGTH_SHORT).show()
                }
                Spacer(modifier = Modifier.width(8.dp))
                JumpCard(
                    Modifier.weight(1f),
                    backgroundColor = Color(0xfff7f5ff),
                    textColor = Color(0xff7a71c2),
                    iconPainter = painterResource(id = R.drawable.icon_phrase),
                    title = "短语",
                    subtitle = "写作必备"
                ) {
                    Toast.makeText(this@NewsActivity, "跳转短语", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    @Composable
    fun JumpCard(
        modifier: Modifier,
        backgroundColor: Color,
        textColor: Color,
        iconPainter: Painter,
        title: String,
        subtitle: String,
        onClick: () -> Unit
    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(backgroundColor)
                .then(modifier)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(12.dp))
            Image(painter = iconPainter, contentDescription = null)
            Column {
                Text(
                    text = title,
                    fontSize = 12.sp,
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subtitle,
                    fontSize = 10.sp,
                    color = textColor
                )
            }
        }
    }

    private fun updateData() {
        val index = mDataIndex
        if (++mDataIndex >= mMockDataList.size) {
            mDataIndex = 0
        }

        val data = mMockDataList[index]

        mCategory = data.category
        mTitleEn = data.titleEn
        mTitleCn = data.titleCn
        mPicUrl = data.picUrl
        mReadCount = data.readCount
        mTag = data.tag
        mLength = data.length
    }

    private val mMockDataList by lazy {
        mutableListOf<ViewModel>().apply {
            add(
                ViewModel(
                    "科普",
                    "An Extra 1.2 Hours of Sleep May Help You Eat Fewer Calories",
                    "减肥新思路：睡饱觉能降低卡路里摄入",
                    "https://media-image1.baydn.com/9d8b66ea8e30dce4954d4148102a085e5c4ec73b8e2e4a394ceddfd826e70f1d.png?x-oss-process=image/quality,Q_80",
                    19465,
                    "GMAT词汇16个，地道表达12个",
                    386
                )
            )
            add(
                ViewModel(
                    "热点",
                    "Why Don't Figure Skaters Get Dizzy When They Spin",
                    "每秒旋转数圈，花滑运动员为啥不晕？",
                    "https://media-image1.baydn.com/7932c8a4652c8d14cc253a4fb549f7669afd7115dc600179f3dc57beb4915ade.png?x-oss-process=image/quality,Q_80",
                    140860,
                    "GMAT词汇9个，地道表达9个",
                    355
                )
            )
            add(
                ViewModel(
                    "科学",
                    "The Art and Beauty of General Relativity",
                    "广义相对论的艺术与美感",
                    "https://media-image1.baydn.com/1b3002fbaefdb862cace4bfaf7052567a0bb76d9530ae0832ceafef4dca9b10f.png?x-oss-process=image/quality,Q_80",
                    49983,
                    "GMAT词汇19个，地道表达20个",
                    711
                )
            )
        }
    }

    private var mDataIndex = 0

    data class ViewModel(
        var category: String,
        var titleEn: String,
        var titleCn: String,
        var picUrl: String,
        var readCount: Int,
        var tag: String,
        var length: Int
    )

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        Content(
            "科普",
            "An Extra 1.2 Hours of Sleep May Help You Eat Fewer Calories",
            "减肥新思路：睡饱觉能降低卡路里摄入",
            "https://media-image1.baydn.com/9d8b66ea8e30dce4954d4148102a085e5c4ec73b8e2e4a394ceddfd826e70f1d.png?x-oss-process=image/quality,Q_80",
            19465,
            "GMAT词汇16个，地道表达12个",
            386
        )
    }
}