package com.example.vid2.presentation

import androidx.lifecycle.ViewModel
import com.example.vid2.data.repository.UserRepositoryImpl
import com.example.vid2.data.storage.SharedPrefUserStorage
import com.example.vid2.domain.models.SaveUserNameParam
import com.example.vid2.domain.usecase.GetUserNameUseCase
import com.example.vid2.domain.usecase.SaveUserNameUseCase

class MainVM(private val getUserNameUseCase : GetUserNameUseCase,
             private val saveUsernameUseCase:SaveUserNameUseCase):ViewModel() {


    fun save(text: String):String{
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUsernameUseCase.execute(param = params)
        return result.toString()

    }

    fun load():String{
        val userName = getUserNameUseCase.execute()
        return "${userName.firstName},${userName.lastName}"
    }

}