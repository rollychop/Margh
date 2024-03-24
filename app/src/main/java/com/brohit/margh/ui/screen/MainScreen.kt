package com.brohit.margh.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brohit.margh.ui.Screen
import com.brohit.margh.ui.theme.MarghTheme

@Composable
fun MainScreen() {
    var currentScreen by remember {
        mutableStateOf(Screen.Home)
    }

    BackHandler(currentScreen != Screen.Home) {
        currentScreen = Screen.Home
    }

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .navigationBarsPadding()
                    .background(Color.White)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Screen.entries.forEach {
                    val selected = it == currentScreen

                    Surface(
                        modifier = Modifier.weight(1f),
                        onClick = { currentScreen = it },
                        selected = selected,
                        contentColor = if (selected) LocalContentColor.current else LocalContentColor.current.copy(
                            .6f
                        ),
                        interactionSource = remember {
                            MutableInteractionSource()
                        },
                        shape = MaterialTheme.shapes.extraLarge
                    ) {
                        Column(
                            modifier = Modifier.padding(vertical = 4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Icon(
                                painter = painterResource(
                                    id = if (selected) it.selectedIcon
                                    else it.icon
                                ),
                                contentDescription = it.title,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(
                                text = it.title,
                                style = if (selected) MaterialTheme.typography.labelLarge
                                else MaterialTheme.typography.labelSmall
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            AnimatedContent(
                targetState = currentScreen,
                label = "Screen Container"
            ) { screen ->
                when (screen) {
                    Screen.Home -> HomeScreen()
                    Screen.Saved -> SavedScreen()
                    Screen.Profile -> ProfileScreen()
                }
            }
        }

    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MarghTheme {
        Surface {
            MainScreen()
        }
    }
}