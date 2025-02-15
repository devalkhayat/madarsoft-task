package com.madarsoft.core.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.madarsoft.core.common.theme.colors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(caption:String,action: (() -> Unit?)? =null) {

    CenterAlignedTopAppBar(
        title = { PageTitle(caption) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colors.white),
        actions = {
            IconButton(onClick = {

            }) {

            }
        }
    )
}