package com.example.booking.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.booking.R
import com.example.booking.widgets.DateRangePickerWidget
import kotlinx.coroutines.launch

@Composable
fun HomeView(){
    val viewModel: HomeViewModel = hiltViewModel()
    LaunchedEffect(true){
       viewModel.onUiEvent(HomeViewUiEvent.ScreenLoaded())
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFFFFF))) {
        TopBar()
        SearchBox()
    }

}

@Composable
fun TopBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF01347F))
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Booking.com",
            textAlign = TextAlign.Center,
            style = TextStyle(color = Color(0xFFFFFFFF), fontSize = 24.sp, fontWeight = FontWeight.W600)
        )
    }
}


@Composable
fun SearchBox(
    onSearchChanged: (String) -> Unit = {}
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .border(2.dp, Color(0xFFFFD330), RoundedCornerShape(5.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 16.sp),
            value = "",
            onValueChange = onSearchChanged,
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = ""
                )
            })

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 16.sp),
            value = "",
            onValueChange = onSearchChanged,
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = ""
                )
            })
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
            onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF01347F))) {
            Text(text = "Search", style = TextStyle(Color(0xFFFFFFFF)))
        }
    }
//    DatePickerRow()
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun DatePickerRow(){
    val state = rememberDateRangePickerState()
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(800.dp)
                    .background(Color.White)
            ) {
                DateRangePickerWidget()
                Button(
                    onClick = {
                        coroutineScope.launch {
                            bottomSheetState.hide()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black, contentColor = Color.White),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 16.dp)
                ) {
                    Text("Select", color = Color.White)
                }
            }
        },
        content = {
            Column {
                Button(onClick = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }, modifier = Modifier.padding(16.dp)) {
                    Text(text = "Open Date Picker")
                }
            }

        },
        scrimColor = Color.Black.copy(alpha = 0.5f),
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
    )
}

@Preview
@Composable
fun PreviewHomeView(){
    HomeView()
}

@Preview
@Composable
fun PreviewSearchBox(){
    SearchBox()
}
