package com.example.unitconvertertesting

import org.junit.Assert.assertEquals
import org.junit.Test

//constants for testing
const val DELTA = 0.000001
const val F = "Fahrenheit"
const val C = "Celsius"
const val K = "Kelvin"

class ConversionsTest {

    @Test fun testFreezingPointOfWater() {
        assertEquals(32.0, celsiusToFahrenheit(0.0), DELTA)
        assertEquals(32.0, kelvinToFahrenheit(273.15), DELTA)
        assertEquals(0.0, fahrenheitToCelsius(32.0), DELTA)
        assertEquals(0.0, kelvinToCelsius(273.15), DELTA)
        assertEquals(273.15, fahrenheitToKelvin(32.0), DELTA)
        assertEquals(273.15, celsiusToKelvin(0.0), DELTA)
    }

    @Test fun testBoilingPointOfWater() {
        assertEquals(212.0, celsiusToFahrenheit(100.0), DELTA)
        assertEquals(212.0, kelvinToFahrenheit(373.15), DELTA)
        assertEquals(100.0, fahrenheitToCelsius(212.0), DELTA)
        assertEquals(100.0, kelvinToCelsius(373.15), DELTA)
        assertEquals(373.15, fahrenheitToKelvin(212.0), DELTA)
        assertEquals(373.15, celsiusToKelvin(100.0), DELTA)
    }

    @Test fun testNaNValue() {
        assertEquals(Double.NaN, celsiusToFahrenheit(Double.NaN), DELTA)
        assertEquals(Double.NaN, kelvinToFahrenheit(Double.NaN), DELTA)
        assertEquals(Double.NaN, fahrenheitToCelsius(Double.NaN), DELTA)
        assertEquals(Double.NaN, kelvinToCelsius(Double.NaN), DELTA)
        assertEquals(Double.NaN, fahrenheitToKelvin(Double.NaN), DELTA)
        assertEquals(Double.NaN, celsiusToKelvin(Double.NaN), DELTA)
    }

    @Test fun testPositiveInfinity() {
        assertEquals(Double.POSITIVE_INFINITY, celsiusToFahrenheit(Double.POSITIVE_INFINITY), DELTA)
        assertEquals(Double.POSITIVE_INFINITY, kelvinToFahrenheit(Double.POSITIVE_INFINITY), DELTA)
        assertEquals(Double.POSITIVE_INFINITY, fahrenheitToCelsius(Double.POSITIVE_INFINITY), DELTA)
        assertEquals(Double.POSITIVE_INFINITY, kelvinToCelsius(Double.POSITIVE_INFINITY), DELTA)
        assertEquals(Double.POSITIVE_INFINITY, fahrenheitToKelvin(Double.POSITIVE_INFINITY), DELTA)
        assertEquals(Double.POSITIVE_INFINITY, celsiusToKelvin(Double.POSITIVE_INFINITY), DELTA)
    }

    @Test fun testNegativeInfinity() {
        assertEquals(Double.NEGATIVE_INFINITY, celsiusToFahrenheit(Double.NEGATIVE_INFINITY), DELTA)
        assertEquals(Double.NEGATIVE_INFINITY, kelvinToFahrenheit(Double.NEGATIVE_INFINITY), DELTA)
        assertEquals(Double.NEGATIVE_INFINITY, fahrenheitToCelsius(Double.NEGATIVE_INFINITY), DELTA)
        assertEquals(Double.NEGATIVE_INFINITY, kelvinToCelsius(Double.NEGATIVE_INFINITY), DELTA)
        assertEquals(Double.NEGATIVE_INFINITY, fahrenheitToKelvin(Double.NEGATIVE_INFINITY), DELTA)
        assertEquals(Double.NEGATIVE_INFINITY, celsiusToKelvin(Double.NEGATIVE_INFINITY), DELTA)
    }

    @Test fun testNegativeInput() {
        assertEquals(-59.215, celsiusToFahrenheit(-50.675), DELTA)
        assertEquals(-640.462, kelvinToFahrenheit(-100.44), DELTA)
        assertEquals(-49.077777, fahrenheitToCelsius(-56.34), DELTA)
        assertEquals(-351.606, kelvinToCelsius(-78.456), DELTA)
        assertEquals(175.127777, fahrenheitToKelvin(-144.44), DELTA)
        assertEquals(250.57, celsiusToKelvin(-22.58), DELTA)
    }

    @Test fun testLargeInput() {
        assertEquals(18032.0, celsiusToFahrenheit(10000.0), DELTA)
        assertEquals(17540.33, kelvinToFahrenheit(10000.0), DELTA)
        assertEquals(5537.777777, fahrenheitToCelsius(10000.0), DELTA)
        assertEquals(9726.85, kelvinToCelsius(10000.0), DELTA)
        assertEquals(5810.927777, fahrenheitToKelvin(10000.0), DELTA)
        assertEquals(10273.15, celsiusToKelvin(10000.0), DELTA)
    }

    @Test fun convertTemperatureTest() {
        assertEquals(32.0, convertTemperature(0.0, C, F), DELTA)
        assertEquals(32.0, convertTemperature(273.15, K, F) , DELTA)
        assertEquals(0.0, convertTemperature(32.0, F, C), DELTA)
        assertEquals(0.0, convertTemperature(273.15, K, C), DELTA)
        assertEquals(273.15, convertTemperature(32.0, F, K), DELTA)
        assertEquals(273.15, convertTemperature(0.0, C, K), DELTA)
    }
}