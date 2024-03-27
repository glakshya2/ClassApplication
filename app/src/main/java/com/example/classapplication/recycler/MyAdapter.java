package com.example.classapplication.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.classapplication.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    @NonNull
    Context context;
    List<Person> personList;


    public MyAdapter(@NonNull Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.datacard, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(personList.get(position).getName());
        holder.ageTextView.setText(Integer.toString(personList.get(position).getAge()));
        holder.emailTextView.setText(personList.get(position).getEmail());
        Glide.with(context).load(personList.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, ageTextView, emailTextView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.datacardname);
            ageTextView = itemView.findViewById(R.id.datacardage);
            emailTextView = itemView.findViewById(R.id.datacardemail);
            imageView = itemView.findViewById(R.id.datacardiv);
        }
    }
}
