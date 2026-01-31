package com.example.coffeeapp.screens.HomeScreen

import android.R.attr.onClick
import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.LightBrown

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchBar(){

    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        TextField(
            value = searchText,
            onValueChange = { searchText = it},
            placeholder = { Text("Search Coffee", color = Color.Gray) },
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            leadingIcon = {
                Icon(

                    painter = painterResource(R.drawable.search),
                    contentDescription = "Search",
                    modifier = Modifier.size(20.dp),
                    tint = Color.White
                )
            },
            shape = RoundedCornerShape(
                topStart = 12.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 0.dp
            ),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFF2A2A2A),
                focusedContainerColor = Color(0xFF2A2A2A),
                cursorColor = Color.Gray
            )

        )

        Spacer(modifier = Modifier.width(6.dp))

        IconButton(
            onClick = {  },
            modifier = Modifier
                .size(55.dp)
                .background(color = LightBrown,
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 14.dp, bottomStart = 0.dp, bottomEnd = 14.dp)
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.filter),
                contentDescription = "filter",
                modifier = Modifier.size(35.dp),
                tint = Color.White
            )
        }
    }
}