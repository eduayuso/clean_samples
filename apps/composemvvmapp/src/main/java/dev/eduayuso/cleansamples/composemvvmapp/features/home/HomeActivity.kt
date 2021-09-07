package dev.eduayuso.cleansamples.composemvvmapp.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import dev.eduayuso.cleansamples.composemvvmapp.theme.CleanSamplesTheme

class HomeActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            CleanSamplesTheme(darkTheme = false) {
                HomeView()
            }
        }
    }

    @Composable
    fun HomeView() {

        val navController = rememberNavController()
        Scaffold (
            bottomBar = {
                HomeBottomBar(
                    navController
                )
            }
        )
        {
            HomeBottomBarMain(navController)
        }

    }
}