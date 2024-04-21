package com.example.healthcare;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class doctormodel extends RecyclerView.Adapter {
    private doctorFragment doctorFragment;
    private ArrayList<doctormodel> doctorArrayList;
    int img;
    String name, rating, patients;
    public doctormodel(int img, String name, String rating, String patients){

            this.img=img;
            this.name=name;
            this.rating=rating;
            this.patients=patients;
    }

    public doctormodel(doctorFragment doctorFragment, ArrayList<doctormodel> doctorArrayList) {

        this.doctorFragment = doctorFragment;
        this.doctorArrayList = doctorArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return doctorArrayList.size();
    }
}
