package com.example.calculator


import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

val  buttonList=listOf(
    "C","(",")","/",
    "7","8","9","*",
    "4","5","6","+",
    "1","2","3","-",

)


@Composable
fun Calculator(modifier: Modifier,viewModel: CalculatorViewModel) {

    val equationText = viewModel.equationText.observeAsState()
    val resultText = viewModel.resultText.observeAsState()
    Box() {
        Column (modifier=Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End){
            Text(text = equationText.value?:"",
                style = TextStyle(fontSize = 30.sp),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis)
            Spacer(modifier=Modifier.weight(1f))

            Text(text = resultText.value?:"",
                style = TextStyle(fontSize = 50.sp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)

            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
            ) {
                items(buttonList){
                    CalculatorButton(btn = it, onClick = {
                        viewModel.onButtonClick(it)
                    })
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(btn: String,onClick : ()-> Unit){
    Box(modifier = Modifier.padding(8.dp)){

        FloatingActionButton(
            onClick = onClick,modifier = Modifier.size(60.dp),
            shape = CircleShape,
            contentColor = colorResource(R.color.darker_gray),
            containerColor = getColor(btn)

        ) {
            Text(text = btn
            , fontWeight = FontWeight.Bold)
        }
    }
}

fun getColor(btn: String):Color{
    if (btn=="C"|| btn =="AC")
        return Color(0xFF44336)
    if (btn=="("||btn==")")
        return Color.Blue
    if (btn=="/"||btn=="*"||btn=="+"||btn=="-"||btn=="=")
        return Color.Yellow
    return Color.DarkGray
}