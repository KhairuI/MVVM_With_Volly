package com.example.mvvm_basic.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm_basic.R;
import com.example.mvvm_basic.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.list_menu,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.name.setText(users[position].getLogin());
        holder.id.setText(String.valueOf(users[position].getId()));
        holder.repo.setText(users[position].getReposUrl());

        Glide.with(holder.imageView.getContext()).load(users[position].getAvatarUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        AppCompatImageView imageView;
        AppCompatTextView id,name,repo;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.imageId);
            id= itemView.findViewById(R.id.userId);
            name= itemView.findViewById(R.id.nameId);
            repo= itemView.findViewById(R.id.repoId);
        }
    }

}
