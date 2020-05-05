package com.example.mvvm_basic.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvm_basic.R;
import com.example.mvvm_basic.adapter.UserAdapter;
import com.example.mvvm_basic.model.User;
import com.example.mvvm_basic.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recycleViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);


            mainActivityViewModel.getAllUser().observe(this, new Observer<User[]>() {
                @Override
                public void onChanged(User[] users) {

                    recyclerView.setAdapter(new UserAdapter(users));
                }
            });
    }
}
