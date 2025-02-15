package com.madarsoft.core.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.madarsoft.core.common.theme.colors
import com.madarsoft.core.common.theme.labels


@Composable
fun PageTitle(caption:String,modifier: Modifier=Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.title)
}

@Composable
fun LabelHeader(caption:String,modifier: Modifier=Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.header)
}

@Composable
fun LabelNormal(caption:String,modifier: Modifier=Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.normal)
}

@Composable
fun LabelButton(caption:String,modifier: Modifier=Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.button)
}

@Composable
fun LabelInputFieldCaption(caption:String,modifier: Modifier=Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.inputFieldCaption)
}

@Composable
fun LabelInputFieldPlaceholder(caption:String,modifier: Modifier=Modifier){

    Text(text = caption, modifier = modifier, style = MaterialTheme.labels.inputFieldPlaceHolder)
}

@Composable
fun LabelDropDown(caption:String,modifier: Modifier=Modifier,@DrawableRes icon:Int){

   Row(modifier=modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
       Icon(painterResource(icon), contentDescription = null,modifier=Modifier.size(28.dp), tint = MaterialTheme.colors.blue)
       Text(text = caption, modifier = modifier, style = MaterialTheme.labels.dropDownLabel)
   }
}

@Composable
fun LabelIcon(caption:String,modifier: Modifier=Modifier,@DrawableRes icon:Int){

    Row(modifier=modifier.wrapContentWidth(), verticalAlignment = Alignment.CenterVertically){
        Icon(painterResource(icon), contentDescription = null,modifier=Modifier.size(28.dp), tint = MaterialTheme.colors.blue)
        Text(text = caption, style = MaterialTheme.labels.normal)
    }
}









