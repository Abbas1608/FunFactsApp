package com.example.funfacts.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.funfacts.ui.theme.UserInputViwModel

private val NavBackStackEntry.first: String
    get() {
        TODO(" yet implemented")
    }
private val NavBackStackEntry.second: String
    get() {
        TODO(" yet implemented")
    }


@Composable
fun FunFactsNavigationGraph(userInputViwModel: UserInputViwModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USERINPUTSCREES) {

        composable(Routes.USERINPUTSCREES) {

            UserInputScreens(userInputViwModel, ShowWelcomeScreens ={
                println("Coming_inside_showWelcomeScreen")
                println(it.first)
                println(it.second)
                navController.navigate(Routes.WELCOMESCREENS+ "/${it.first}/${it.second}")
            })
        }

        composable("${Routes.WELCOMESCREENS}/ {${Routes.USER_NAME}}/{${Routes.ANIMAL_SELECTED}}",
            arguments = listOf(
                navArgument(name=Routes.USER_NAME){ type= NavType.StringType },
                        navArgument(name=Routes.ANIMAL_SELECTED){ type= NavType.StringType }

            )

        ) {
          val username= it?.arguments?.getString(Routes.USER_NAME)
            val animalselected= it?.arguments?.getString(Routes.ANIMAL_SELECTED)
            WelcomeScreens(username,animalselected)
        }

    }
}


