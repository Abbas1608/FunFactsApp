package com.example.funfacts.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import com.example.funfacts.Data.UserDateUiEvents
import com.example.funfacts.Data.UserInputScreenState

class UserInputViwModel: ViewModel() {

    companion object{
        const val TAG ="UserInputViwModel"
    }
   var uiState = mutableStateOf(UserInputScreenState())


    fun onEvent(event: UserDateUiEvents){

        when(event){
            is UserDateUiEvents.UserNameEntered ->
                {
                    uiState.value = uiState.value.copy(
                        nameEntered = event.name

                    )


                    Log.d(TAG, "onEvent:UserNameEntered->>")
                    Log.d(TAG, "${uiState.value}")
            }

            is UserDateUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalSelected
                )
                Log.d(TAG, "onEvent:AnimalSelected->>")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }

    fun isValidState():Boolean{
        if (!uiState.value.nameEntered.isNullOrEmpty()  && !uiState.value.animalSelected.isNullOrEmpty()){ return true }else{ return false }

    }
}

