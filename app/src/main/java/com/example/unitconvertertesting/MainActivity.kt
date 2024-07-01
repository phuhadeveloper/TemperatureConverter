package com.example.unitconvertertesting

/*
* author: Phu Ha
* date: June 30th, 2024
*
* This program is a temperature conversion app where users can convert temperature
* from one unit to another.
*
* */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconvertertesting.ui.theme.UnitConverterTestingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTestingTheme {

                UnitConverter(
                )

            }
        }
    }
}

// main UI
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter(
    modifier: Modifier = Modifier,

) {
    // states
    // store user input
    var input by remember {
        mutableStateOf("")
    }

    // store conversion result
    var result by remember {
        mutableStateOf("")
    }

    // state of dropdown menu 1
    var expanded1 by remember {
        mutableStateOf(false)
    }

    // state of dropdown menu 2
    var expanded2 by remember {
        mutableStateOf(false)
    }

    // options for dropdown menu
    val options = listOf("Fahrenheit", "Celsius", "Kelvin")

    // option selected for dropdown menu 1
    var selectedOptionText1 by remember {
        mutableStateOf(options[0])
    }

    // option selected for dropdown menu 2
    var selectedOptionText2 by remember {
        mutableStateOf(options[0])
    }
    // end states

    // UI
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            fontSize = 25.sp,
            text = "Temperature Unit Converter"
        )

        Column(
        ) {

            Text(text = "From:")

            // for user input
            TextField(
                value = input,
                onValueChange = { input = it }
            )

            // first dropdown menu
            ExposedDropdownMenuBox(
                expanded = expanded1,
                onExpandedChange = {
                    expanded1 = !expanded1
                }
            ) {
                TextField(
                    modifier = modifier.padding(vertical = 10.dp).menuAnchor(),
                    readOnly = true,
                    value = selectedOptionText1,
                    onValueChange = {},
                    label = { Text("Temperature") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded1)
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )
                ExposedDropdownMenu(
                    expanded = expanded1,
                    onDismissRequest = { expanded1 = false }
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(text = selectionOption) },
                            onClick = {
                                selectedOptionText1 = selectionOption
                                expanded1 = false
                            }
                        )
                    }
                }
            }
        }


        Column {
            Text(text = "To:")

            // second dropdown menu
            ExposedDropdownMenuBox(
                modifier = modifier.padding(vertical = 10.dp),
                expanded = expanded2,
                onExpandedChange = {
                    expanded2 = !expanded2
                }
            ) {
                TextField(
                    modifier = modifier.menuAnchor(),
                    readOnly = true,
                    value = selectedOptionText2,
                    onValueChange = {},
                    label = { Text("Temperature") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded2)
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors()
                )
                ExposedDropdownMenu(
                    expanded = expanded2,
                    onDismissRequest = { expanded2 = false }
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(text = selectionOption) },
                            onClick = {
                                selectedOptionText2 = selectionOption
                                expanded2 = false
                            }
                        )
                    }
                }
            }

            // display result here
            TextField(
                value = result,
                onValueChange = { input = it },
                enabled = false
            )
        }


        // button that signal the conversion
        Button(onClick = {
            result = convertTemperature(input.toDouble(), selectedOptionText1, selectedOptionText2).toString()
        }) {
            Text(text = "Convert")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTestingTheme {

            UnitConverter()

    }
}