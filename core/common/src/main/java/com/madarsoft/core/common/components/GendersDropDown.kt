package com.madarsoft.core.common.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.madarsoft.core.common.R
import com.madarsoft.core.common.theme.colors

@Composable
fun GendersDropDown(action:(selected:GenderTypes)->Unit){

    val list= listOf(GenderTypes.Male,GenderTypes.Female)
    val isExpandend = rememberSaveable  {
        mutableStateOf(false)
    }
    var currentValue by rememberSaveable  {
        mutableStateOf(list[0])
    }

    Column(modifier = Modifier.fillMaxWidth(),verticalArrangement = Arrangement.spacedBy(8.dp)) {

        LabelInputFieldCaption(caption = stringResource(R.string.gender_caption))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(MaterialTheme.colors.white)
            .border(width = 0.5.dp, color = MaterialTheme.colors.gray, shape = MaterialTheme.shapes.medium)
            .padding(vertical = 8.dp, horizontal = 8.dp)
            , contentAlignment = Alignment.CenterStart){




            Row(modifier = Modifier.fillMaxWidth().clickable { isExpandend.value = !isExpandend.value }, verticalAlignment = Alignment.CenterVertically) {

                LabelDropDown(caption =currentValue.value , modifier = Modifier.weight(1f), icon = currentValue.icon)

                Spacer(modifier = Modifier.width(8.dp))

                Icon(painter = painterResource(id = R.drawable.ic_arrow_down), contentDescription = "drop", tint = MaterialTheme.colors.gray )

                Spacer(modifier = Modifier.width(8.dp))

                DropdownMenu(
                    expanded = isExpandend.value,
                    onDismissRequest = { isExpandend.value = false }) {

                    list.forEach { DropdownMenuItem(
                        text = {LabelDropDown(caption = it.name, icon = it.icon)},
                        onClick = {
                            currentValue = it
                            isExpandend.value = false
                            action(it)
                        }
                    ) }


                }
            }

        }

    }

}


enum class GenderTypes(var value:String,@DrawableRes var  icon:Int){
    Male("Male",R.drawable.ic_male),Female("Female",R.drawable.ic_female)
}