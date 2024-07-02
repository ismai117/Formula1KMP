package org.ncgroup.formula1kmp.main


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import navigation.main.MainNavigation


@Composable
fun MainScreen(){

    val navController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MainNavigation(
            navController = navController
        )
    }

}
