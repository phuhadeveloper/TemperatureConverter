package com.example.unitconvertertesting

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter(
    modifier: Modifier = Modifier,

) {
    // states
    var input by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    var expanded1 by remember {
        mutableStateOf(false)
    }

    var expanded2 by remember {
        mutableStateOf(false)
    }

    val options = listOf("Fahrenheit", "Celsius", "Kelvin")

    var selectedOptionText1 by remember {
        mutableStateOf(options[0])
    }

    var selectedOptionText2 by remember {
        mutableStateOf(options[0])
    }

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
            TextField(
                value = input,
                onValueChange = { input = it }
            )
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

            TextField(
                value = result,
                onValueChange = { input = it },
                enabled = false
            )
        }



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