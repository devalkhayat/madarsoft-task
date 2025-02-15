package com.madarsoft.features.home.ui.screens.home


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.madarsoft.core.common.WindowInfo
import com.madarsoft.core.common.rememberWindowInfo

import com.google.android.gms.location.LocationServices
import com.madarsoft.core.common.components.AppTopBar
import com.madarsoft.core.common.components.InputField
import com.madarsoft.core.common.R
import com.madarsoft.core.common.components.AppButton
import com.madarsoft.core.common.components.ErrorDialog
import com.madarsoft.core.common.components.GendersDropDown
import com.madarsoft.core.common.components.LoadingDialog
import com.madarsoft.core.common.theme.colors
import com.madarsoft.core.navigation.HomeFeatureRoutes
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navHostController: NavHostController){
    val context=LocalContext.current
    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
    val snackBarHostState = remember{ SnackbarHostState() }
    val scope = rememberCoroutineScope()


    val result by homeScreenViewModel.addUserActionState
    val userInfo by homeScreenViewModel.userInputInfo

   Scaffold(topBar = {AppTopBar(caption = stringResource(R.string.register_form))}, snackbarHost = {SnackbarHost(snackBarHostState)}, modifier = Modifier
       .fillMaxSize()
       .padding(8.dp)) { innerPadding->

       Column(modifier = Modifier
           .fillMaxSize()
           .padding(paddingValues = innerPadding)
           .padding(16.dp)
           .verticalScroll(
               rememberScrollState()
           )) {

           Column(modifier = Modifier
               .fillMaxWidth()
               .weight(1f), verticalArrangement = Arrangement.spacedBy(16.dp)) {


               InputField(caption =stringResource(R.string.input_user_name_caption),stringResource(R.string.input_user_name_place_holder) ){
                   userInfo.name=it
               }

               InputField(caption =stringResource(R.string.job_title_caption),stringResource(R.string.job_title_place_holder) ){
                   userInfo.jobTitle=it
               }

               InputField(caption =stringResource(R.string.age_caption), stringResource(R.string.age_place_holder), action = ImeAction.Done, type = KeyboardType.Number){
                   userInfo.age=it.toInt()
               }


               GendersDropDown {
                   userInfo.gender=it.value
               }
           }


           AppButton(title = stringResource(R.string.proceed)){

                with(userInfo){
                    if(this.name.isNullOrEmpty() || this.jobTitle.isNullOrEmpty()){

                        scope.launch {

                            snackBarHostState.showSnackbar( context.getString(R.string.missing_data))
                        }
                    }else{
                        homeScreenViewModel.add()
                    }
                }




           }
       }


   }


    when(result) {
        HomeScreenStateHolder.Error -> ErrorDialog("something occurred")
        HomeScreenStateHolder.Loading -> LoadingDialog()
        HomeScreenStateHolder.Success ->
            navHostController.navigate(HomeFeatureRoutes.PreviewScreenRoute){
                popUpTo(HomeFeatureRoutes.HomeScreenRoute){inclusive=true}
            }

        HomeScreenStateHolder.Ideal -> {

        }
    }

}









