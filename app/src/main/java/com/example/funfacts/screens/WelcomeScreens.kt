package com.example.funfacts.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfacts.ui.theme.FactComposable
import com.example.funfacts.ui.theme.FactsViewModel
import com.example.funfacts.ui.theme.TextComponent
import com.example.funfacts.ui.theme.TextWidthShadow
import com.example.funfacts.ui.theme.Topbar

@Composable
fun WelcomeScreens(username: String?, animalselected: String?) {
    println("=====Inside+WelcomeScreen")
    println("=====$username and $animalselected")

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ){
            Topbar(value = " Welcome $username \uD83D\uDE0D")
            TextComponent(textValue = "Thank You! for sharing your data", textsize = 24.sp)
            Spacer(modifier = Modifier.size(60.dp))

            val finalText = if (
                animalselected== "Cat") "You are a Cat lover \uD83D\uDC36" else "You are a Dog lover"
            TextWidthShadow(value = finalText)
            val factsViewModel : FactsViewModel = viewModel()
            FactComposable(
                value = factsViewModel.generatRomdomFact(animalselected!!)
            )


        }
}
}



@Preview
@Composable
fun WelcomeScreenpreview() {
    WelcomeScreens("username","animalselected")

}
