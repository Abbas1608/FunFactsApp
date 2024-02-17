package com.example.funfacts.ui.theme

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Utils {

    fun generateRandomColor(): Color{
        return Color(
            red = Random.nextFloat(),
            green = Random.nextFloat(),
            blue =Random.nextFloat() ,
            alpha = 1f
        )
    }
}