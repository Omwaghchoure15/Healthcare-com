package com.example.healthcare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class homeFragment extends Fragment {

    public homeFragment() {
        // Required empty public constructor
    }
    View doctor, pharmacy, labTest;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the View by its ID
        doctor= root.findViewById(R.id.doctorView);
        pharmacy = root.findViewById(R.id.PharmacyView);
        labTest = root.findViewById(R.id.LabTestView);

        // Set click listener to the View
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref= getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= pref.edit();
                editor.putBoolean("flag",false);
                editor.apply();
                Intent intent = new Intent(getActivity(), SetupActivity.class);
                startActivity(intent);
            }
        });
        // When the button is clicked,  start the MainActivity
        return root;
    }
}