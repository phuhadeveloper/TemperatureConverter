package com.example.unitconvertertesting

fun celsiusToFahrenheit(temp: Double): Double {
    return (temp * 9.0/5.0) + 32
}

fun celsiusToKelvin(temp: Double): Double {
    return temp + 273.15
}

fun fahrenheitToCelsius(temp: Double): Double {
    return (temp - 32)*5.0/9.0
}

fun fahrenheitToKelvin(temp: Double): Double {
    return (temp - 32)*5.0/9.0 + 273.15
}

fun kelvinToFahrenheit(temp: Double): Double {
    return (temp - 273.15)*9.0/5.0 + 32
}

fun kelvinToCelsius(temp: Double): Double {
    return (temp - 273.15)
}

// function to convert unit
fun convertTemperature(
    temp: Double,
    from: String,
    to: String
) : Double {
    // if from and to are equal
    if (from == to) {
        return temp
    }

    if (from == "Celsius") {
        if (to == "Fahrenheit") {
            return celsiusToFahrenheit(temp)
        }
        if (to == "Kelvin") {
            return celsiusToKelvin(temp)
        }
    }
    if (from == "Fahrenheit") {
        if (to == "Celsius") {
            return fahrenheitToCelsius(temp)
        }
        if (to == "Kelvin") {
            return fahrenheitToKelvin(temp)
        }
    }
    if (from == "Kelvin") {
        if (to == "Fahrenheit") {
            return kelvinToFahrenheit(temp)
        }
        if (to == "Celsius") {
            return kelvinToCelsius(temp)
        }
    }

    return Double.NaN
}