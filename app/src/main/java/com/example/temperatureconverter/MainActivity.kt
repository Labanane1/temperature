package com.example.temperatureconverter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

//création des fonctions
@Composable
fun TemperatureConverter() {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Température en Celsius") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )g
        Button(onClick = {
            val celsius = input.toFloatOrNull()
            if (celsius != null) {
                val fahrenheit = celsius * 9/5 + 32
                output = fahrenheit.toString()
            }
        }) {
            Text("Convertir en Fahrenheit")
        }
        Text(text = "Température en Fahrenheit: $output")
    }
}
// prévisualisation
@Preview
@Composable
fun PreviewTemperatureConverter() {
    TemperatureConverter()
}
