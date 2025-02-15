package com.madarsoft.features.home.ui.screens.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.madarsoft.core.common.R
import com.madarsoft.core.common.components.AppButton
import com.madarsoft.core.common.components.ErrorDialog
import com.madarsoft.core.common.components.GenderTypes
import com.madarsoft.core.common.components.LabelHeader
import com.madarsoft.core.common.components.LabelIcon
import com.madarsoft.core.common.components.LabelNormal
import com.madarsoft.core.common.components.LoadingDialog
import com.madarsoft.core.common.rememberWindowInfo
import com.madarsoft.core.navigation.HomeFeatureRoutes
import com.madarsoft.features.home.domain.model.UserModel

@Composable
fun PreviewScreen(navController: NavHostController) {
    val previewScreenViewModel = hiltViewModel<PreviewScreenViewModel>()
    val result by previewScreenViewModel.getUserActionState
    LaunchedEffect(true) {
        previewScreenViewModel.getData()
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(
            rememberScrollState()
        )) {

       Content(modifier = Modifier.weight(1f),result)

        AppButton(title = stringResource(R.string.another_try)){
            navController.navigate(HomeFeatureRoutes.HomeScreenRoute)
        }
    }

}

@Composable
fun Content(modifier: Modifier = Modifier, result: PreviewScreenStateHolder<UserModel>) {

    Column(modifier = modifier
        .fillMaxWidth()
        , verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painterResource(R.drawable.ic_success),contentDescription = null, modifier = Modifier.size(128.dp))

        when(result){
            is PreviewScreenStateHolder.Error -> ErrorDialog("something occurred")
            is PreviewScreenStateHolder.Ideal -> null
            is PreviewScreenStateHolder.Loading -> LoadingDialog()
            is PreviewScreenStateHolder.Success ->
                result.rs?.apply {
                    LabelHeader(caption = this.userName)
                    LabelNormal(caption = this.jobTitle)
                    LabelNormal(caption = "${this.age} ${stringResource(R.string.years_old)}")

                    val ic=when(this.gender) {
                        GenderTypes.Male.value -> R.drawable.ic_male
                        GenderTypes.Female.value -> R.drawable.ic_female
                        else -> R.drawable.ic_male
                    }
                    LabelIcon(caption = this.gender, icon = ic)

                }

        }

    }
}

