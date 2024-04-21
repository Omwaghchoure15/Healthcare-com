package com.example.healthcare;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class doctorFragment extends Fragment {

    private ArrayList<doctormodel> doctorArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_doctor, container, false);

        RecyclerView recyclerView=rootView.findViewById(R.id.recyclerView);


        doctorArrayList.add(new doctormodel(R.drawable.a,"aaa","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.b,"bbb","34 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.c,"aaa","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.d,"ddd","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.e,"eee","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.a,"aaa","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.a,"aaa","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.a,"ffff","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.a,"cccc","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.a,"rrrr","3.4 out of 5","340"));
        doctorArrayList.add(new doctormodel(R.drawable.a,"3333","3.4 out of 5","340"));

        doctormodel adapter=new doctormodel(this, doctorArrayList);
        recyclerView.setAdapter(adapter);
        return rootView;
    }


}