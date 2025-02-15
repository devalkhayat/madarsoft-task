package com.madarsoft.core.common.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.madarsoft.core.common.theme.colors

@Composable
fun InputField(caption:String,placeholder:String,type:KeyboardType=KeyboardType.Text,action:ImeAction=ImeAction.Next,modifier: Modifier=Modifier,onChanged:(newText:String)->Unit){

    var text by rememberSaveable { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager= LocalFocusManager.current
    val textDefaults=TextFieldDefaults.colors(
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        disabledContainerColor = Color.White,
        focusedTextColor = Color.Gray,
        focusedTrailingIconColor = Color.Gray,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedPlaceholderColor = Color.Gray,
        unfocusedPlaceholderColor = Color.Gray,
    )

    Column(modifier=Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {

        LabelInputFieldCaption(caption=caption)
        TextField(
            value = text,
            onValueChange = {
                text=it
                onChanged(it)
                            },
            placeholder = { LabelInputFieldPlaceholder(caption=placeholder) },
            singleLine = true,
            modifier = modifier.fillMaxWidth().border(width = 0.5.dp, color = MaterialTheme.colors.gray, shape = MaterialTheme.shapes.medium),
            shape = MaterialTheme.shapes.medium,
            colors =textDefaults ,
            keyboardOptions = KeyboardOptions(
                imeAction = action,
                keyboardType = type
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)

                },
                onDone = {
                    keyboardController?.hide()
                }
            ),

            )

    }


}