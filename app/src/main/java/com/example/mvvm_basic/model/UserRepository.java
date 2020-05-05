package com.example.mvvm_basic.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserRepository {
    String url ="https://api.github.com/users";
    Application application;
    User[] users;
    MutableLiveData<User[]> mutableLiveData;

    public UserRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<User[]> getUserdata(){

        if(mutableLiveData==null){
            mutableLiveData= new MutableLiveData<>();
        }
        RequestQueue queue = Volley.newRequestQueue(application);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder gsonBuilder= new GsonBuilder();
                        Gson gson= gsonBuilder.create();
                        users= gson.fromJson(response,User[].class);
                        mutableLiveData.setValue(users);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);
            return mutableLiveData;
    }
}
