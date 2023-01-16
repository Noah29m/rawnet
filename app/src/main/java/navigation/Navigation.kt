package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost


@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route

    ){

    }
}




