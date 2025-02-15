package com.madarsoft.core.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.madarsoft.core.common.R
import com.madarsoft.core.common.theme.colors

@Composable
fun LoadingDialog(onDismiss: (() -> Unit?)? =null,modifier: Modifier = Modifier) {

    Dialog(onDismissRequest = {
        if (onDismiss != null) {
            onDismiss()
        }
    }) {

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier,
            elevation = CardDefaults.elevatedCardElevation(8.dp)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(12.dp)
            ) {
                Text(
                    text = "Loading.. Please wait..",
                    Modifier
                        .padding(8.dp), textAlign = TextAlign.Center
                )

                CircularProgressIndicator(
                    strokeWidth = 4.dp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun ErrorDialog(error:String,modifier: Modifier = Modifier) {

    Dialog(onDismissRequest = {

    }) {

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier,
            elevation = CardDefaults.elevatedCardElevation(8.dp)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(12.dp)
            ) {
                Text(
                    text = error,
                    Modifier
                        .padding(8.dp), textAlign = TextAlign.Center
                )

                Icon(painterResource(R.drawable.ic_error), tint = MaterialTheme.colors.blue,modifier = Modifier.size(80.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp), contentDescription = null)

            }
        }
    }
}