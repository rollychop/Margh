package com.brohit.margh.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.brohit.margh.R
import com.brohit.margh.ui.screen.MainScreen
import com.brohit.margh.ui.theme.MarghTheme

enum class Screen(
    @DrawableRes
    val icon: Int,
    @DrawableRes val selectedIcon: Int,
    val title: String
) {
    Home(R.drawable.home_outlined, R.drawable.home, "Home"),
    Saved(R.drawable.heart, R.drawable.heart_filled, "Saved"),
    Profile(R.drawable.user, R.drawable.user_filled, "Profile");
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarghTheme(
                darkTheme = false,
                dynamicColor = false
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }


}
