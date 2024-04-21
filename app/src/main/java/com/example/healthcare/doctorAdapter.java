package com.example.healthcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class doctorAdapter extends RecyclerView.Adapter<doctorAdapter.viewHolder> {

    Context context;
    ArrayList<doctormodel> doctorArrayList;

    doctorAdapter(Context context, ArrayList<doctormodel> doctorArrayList){
        this.context=context;
        this.doctorArrayList=doctorArrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.doctorprofile,parent,false);
        RecyclerView.ViewHolder viewHolder = new viewHolder(view);
        return new  viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        doctormodel doctormodel= doctorArrayList.get(position);
        holder.DoctorImg.setImageResource(doctorArrayList.get(position).img);
        holder.DoctorName.setText(doctorArrayList.get(position).name);
        holder.viewRating.setText(doctorArrayList.get(position).rating);
        holder.viewPatients.setText(doctorArrayList.get(position).patients);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageView DoctorImg;
        TextView DoctorName, viewRating, viewPatients;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            DoctorImg=itemView.findViewById(R.id.DoctorImg);
            DoctorName =itemView.findViewById(R.id.DoctorName);
            viewRating =itemView.findViewById(R.id.ViewRating);
            viewPatients =itemView.findViewById(R.id.ViewPatients);
        }
    }
}
