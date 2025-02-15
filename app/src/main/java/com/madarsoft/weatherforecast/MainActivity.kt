package com.madarsoft.task

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.madarsoft.core.common.theme.TaskTheme
import com.madarsoft.task.navigation.AppNavGraph
import com.madarsoft.task.navigation.NavigationProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskTheme {
                val navController= rememberNavController()
                App(navHostController = navController,navigationProvider)
            }
        }
    }
}



@Composable
fun App(navHostController: NavHostController, navigationProvider: NavigationProvider){

    Scaffold(modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {

            AppNavGraph(
                navController = navHostController,
                navigationProvider = navigationProvider
            )
        }

    }



}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskTheme {

    }
}