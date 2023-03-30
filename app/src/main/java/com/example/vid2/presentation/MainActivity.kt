package com.example.vid2.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.vid2.data.repository.UserRepositoryImpl
import com.example.vid2.data.storage.SharedPrefUserStorage
import com.example.vid2.data.storage.UserStorage
import com.example.vid2.databinding.ActivityMainBinding
import com.example.vid2.domain.models.SaveUserNameParam
import com.example.vid2.domain.usecase.GetUserNameUseCase
import com.example.vid2.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    val mainVM: MainVM by viewModels { MainVMFactory(this) }


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.sendButton.setOnClickListener {

            binding.dataTextView.text = mainVM.save(binding.dataEditText.text.toString())
        }
        binding.receiveButton.setOnClickListener {
            binding.dataTextView.text = mainVM.load()
        }

    }
}