package com.brohit.margh.ui.screen

import android.graphics.BitmapFactory
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.palette.graphics.Palette
import com.brohit.margh.R
import com.brohit.margh.domain.model.FakeQuotes
import com.brohit.margh.ui.theme.MarghTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Wake up and live your dreams.",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                        text = "Random quotes",
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                Surface(
                    onClick = {},
                    shape = CircleShape,
                    border = BorderStroke(2.dp, LocalContentColor.current.copy(.5f))
                ) {
                    Row(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "search icon"
                        )
                        Spacer(
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.mic),
                            contentDescription = "search icon"
                        )
                    }
                }
            }
        }

        val context = LocalContext.current

        VerticalPager(state = rememberPagerState { FakeQuotes.size }) { page ->
            val model = FakeQuotes[page]
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .drawBehind {
                        Palette
                            .from(BitmapFactory.decodeResource(context.resources, model.image))
                            .generate().dominantSwatch?.rgb?.let {
                                drawRect(Color(it.red, it.green, it.blue))
                            }
                    }

            ) {
                Image(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .weight(1f),
                    painter = painterResource(id = model.image),
                    contentDescription = model.title,
                    contentScale = ContentScale.Crop
                )
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    shadowElevation = 5.dp,
                    tonalElevation = 5.dp,
                    color = Color.White
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 32.dp, vertical = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Surface(
                            onClick = {},
                            color = Color.White
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.heart),
                                    contentDescription = "save ${model.title}",
                                    modifier = Modifier.size(32.dp)
                                )
                                Text(text = "Save")

                            }
                        }
                        Surface(
                            onClick = {},
                            color = Color.White
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.rounded_download),
                                    contentDescription = "download ${model.title}",
                                    modifier = Modifier.size(32.dp)
                                )
                                Text(text = "Download")

                            }
                        }
                        Surface(
                            onClick = {},
                            color = Color.White
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.share),
                                    contentDescription = "share ${model.title}",
                                    modifier = Modifier.size(32.dp)
                                )
                                Text(text = "Share")

                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MarghTheme {
        Surface {
            HomeScreen()
        }
    }
}