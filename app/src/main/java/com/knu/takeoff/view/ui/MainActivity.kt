package com.knu.takeoff.view.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.knu.takeoff.view.ui.navigation.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val takeOffRouteScreens = listOf(
        NavigationItem.Calendar,
        NavigationItem.Person,
        NavigationItem.Chat,
        NavigationItem.Feed
    )
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TakeOffTopAppBar(
                navController = navController,
                takeOffRouteScreens = takeOffRouteScreens,
                currentDestination = backStackEntry?.destination,
            )
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Navigation(navController)
        }
    }
}

@Composable
fun TakeOffTopAppBar(
    navController: NavController,
    takeOffRouteScreens: List<NavigationItem>,
    currentDestination: NavDestination?
) {
    val currentTakeOffRouteScreen =
        takeOffRouteScreens.find { takeOffRouteScreen -> takeOffRouteScreen.route == currentDestination?.route }

    if (currentTakeOffRouteScreen != null) {
        TopAppBar(
            title = {
                Text(text = currentTakeOffRouteScreen.title)
            }
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Feed,
        NavigationItem.Calendar,
        NavigationItem.Chat,
        NavigationItem.Person
    )

    BottomNavigation(backgroundColor = Color.White, contentColor = Color.Black) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Feed.route) {
        composable(NavigationItem.Feed.route) {
            FeedScreen(NavigationItem.Feed.title)
        }
        composable(NavigationItem.Calendar.route) {
            CalendarScreen(NavigationItem.Calendar.title)
        }
        composable(NavigationItem.Chat.route) {
            ChatScreen(NavigationItem.Chat.title)
        }
        composable(NavigationItem.Person.route) {
            PersonScreen(NavigationItem.Person.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}