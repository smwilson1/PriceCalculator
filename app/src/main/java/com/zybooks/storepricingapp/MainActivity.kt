package com.zybooks.storepricingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions


import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.storepricingapp.ui.theme.StorePricingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StorePricingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PriceApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PriceApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Price Calculator",
            fontSize = 40.sp,
            lineHeight = 50.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {

            Text(
                text = "Insert the prices of each item.",
                fontSize = 20.sp,
                color = Color.White
            )
        }
        Price()
    }


}

@Preview(showBackground = true)
@Composable
fun Price(modifier: Modifier = Modifier) {
    var item1 by remember { mutableStateOf("") }
    var item2 by remember { mutableStateOf("") }
    var item3 by remember { mutableStateOf("") }

    var subPrice = (item1.toDoubleOrNull() ?: 0.0) +
            (item2.toDoubleOrNull() ?: 0.0) +
            (item3.toDoubleOrNull() ?: 0.0)
    var tax by remember { mutableStateOf(0.0) }
    var total by remember { mutableStateOf(0.0) }


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = item1,
            onValueChange = { item1 = it },
            label = { Text("Item 1") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(8.dp)
        )
        TextField(
            value = item2,
            onValueChange = { item2 = it },
            label = { Text("Item 2") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(8.dp)
        )
        TextField(
            value = item3,
            onValueChange = { item3 = it },
            label = { Text("Item 3") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.padding(8.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Subtotal: $subPrice",
                fontSize = 20.sp,
                color = Color.Red
            )
            Text(
                text = "Tax: $tax",
                fontSize = 20.sp,
                color = Color.Red
            )
            Text(
                text = "Total Price: $total",
                fontSize = 20.sp,
                color = Color.Red
            )

            Button(
                onClick = {
                    ((item1.toDoubleOrNull() ?: 0.0) +
                            (item2.toDoubleOrNull() ?: 0.0) +
                            (item3.toDoubleOrNull() ?: 0.0))
                    tax = subPrice * 0.06
                    total = subPrice + tax
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Calculate")
            }

        }

    }
}
