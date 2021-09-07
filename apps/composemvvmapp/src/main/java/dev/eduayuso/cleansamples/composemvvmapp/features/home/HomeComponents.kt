package dev.eduayuso.cleansamples.composemvvmapp.features.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.eduayuso.cleansamples.composemvvmapp.R
import dev.eduayuso.cleansamples.shared.impl.DataConstants

sealed class Screens(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {

    object Posts : Screens(
        route = DataConstants.Routes.posts,
        title = R.string.title_post_list,
        icon= R.drawable.ic_baseline_image_24
    )
    object Users : Screens(
        route = DataConstants.Routes.users,
        title = R.string.title_user_list,
        icon= R.drawable.ic_baseline_group_24
    )
    object Tags : Screens(
        route = DataConstants.Routes.tags,
        title = R.string.title_tag_list,
        icon= R.drawable.ic_baseline_tag_24
    )
}

@Composable
fun HomeBottomBar(navController: NavController) {

    val items = listOf(
        Screens.Posts,
        Screens.Users,
        Screens.Tags
    )

    BottomNavigation(elevation = 5.dp) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.map {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = stringResource(id = it.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(it.title)
                    )
                },
                selected = currentRoute == it.route,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.DarkGray,
                onClick = {
                    navController.navigate(it.route)
                }
            )
        }

    }
}

@Composable
fun HomeBottomBarMain(navController : NavHostController) {

    NavHost(navController, startDestination = Screens.Posts.route) {
        composable(Screens.Posts.route) {
            ScreenComposable(Screens.Posts)
        }
        composable(Screens.Users.route) {
            ScreenComposable(Screens.Users)
        }
        composable(Screens.Tags.route) {
            ScreenComposable(Screens.Tags)
        }
    }
}

@Composable
fun ScreenComposable(screen: Screens) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Text(
            text = stringResource(id = screen.title),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp
        )
    }
}