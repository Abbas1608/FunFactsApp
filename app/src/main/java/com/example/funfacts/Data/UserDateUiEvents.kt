package com.example.funfacts.Data

sealed class  UserDateUiEvents{

    data class UserNameEntered
        (var name : String): UserDateUiEvents()
    data class AnimalSelected (val animalSelected: String): UserDateUiEvents()
}