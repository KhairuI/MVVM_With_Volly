package com.example.mvvm_basic.viewmodel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_basic.model.User;
import com.example.mvvm_basic.model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {

    public UserRepository userRepository;

    public  MainActivityViewModel(Application application) {
        super(application);

        userRepository= new UserRepository(application);
    }


    public LiveData<User[]> getAllUser(){

        return userRepository.getUserdata();
    }
}
