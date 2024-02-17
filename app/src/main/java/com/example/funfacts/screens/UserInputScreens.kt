package com.example.funfacts.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.Data.UserDateUiEvents
import com.example.funfacts.R
import com.example.funfacts.ui.theme.AnimalCard
import com.example.funfacts.ui.theme.ButtonComponenent
import com.example.funfacts.ui.theme.TextComponent

import com.example.funfacts.ui.theme.TextFieldComponent

import com.example.funfacts.ui.theme.Topbar
import com.example.funfacts.ui.theme.UserInputViwModel

@Composable
fun UserInputScreens(userInputViwModel: UserInputViwModel, ShowWelcomeScreens: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        )
        {
            Topbar("Hi there \uD83D\uDE0A")

            TextComponent(
                textValue = " Let's learn about you !",
                textsize = 24.sp
            )
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(
                textValue = "This app will prepare a details page on input provided by you ",
                textsize = 18.sp
            )
            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textsize = 18.sp)
            Spacer(modifier = Modifier.size(20.dp))


            TextFieldComponent(onTextChanged = {

                userInputViwModel.onEvent(
                    UserDateUiEvents.UserNameEntered(it)
                )
            })
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(textValue = "What do you like ", textsize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard(image = R.drawable.catlogo, animalSelecter = {
                    userInputViwModel.onEvent(
                        UserDateUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViwModel.uiState.value.animalSelected == "cat")

                AnimalCard(image = R.drawable.doglogo, animalSelecter = {
                    userInputViwModel.onEvent(
                        UserDateUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViwModel.uiState.value.animalSelected == "Dog")

            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViwModel.isValidState()) {
                ButtonComponenent(
                    goToDetailsScreen = {
                      println("=============ComingHere")
                        println("=============${userInputViwModel.uiState.value.nameEntered} and ${userInputViwModel.uiState.value.animalSelected}")

                    }
                )
            }
        }}}



@Preview
@Composable
fun UserInputScreensPreview() {
    UserInputScreens(UserInputViwModel()) {
    }
}


