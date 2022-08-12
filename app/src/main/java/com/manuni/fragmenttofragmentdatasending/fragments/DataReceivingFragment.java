package com.manuni.fragmenttofragmentdatasending.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manuni.fragmenttofragmentdatasending.R;
import com.manuni.fragmenttofragmentdatasending.databinding.FragmentDataReceivingBinding;
import com.manuni.fragmenttofragmentdatasending.models.Person;


public class DataReceivingFragment extends Fragment {

    //TextView nameTextView,genderTextView,ageTextView;
    FragmentDataReceivingBinding binding;


    public DataReceivingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDataReceivingBinding.inflate(inflater,container,false);
        return binding.getRoot();

        //View view = inflater.inflate(R.layout.fragment_data_receiving,container,false);
        /* nameTextView = view.findViewById(R.id.nameDataTxt);
         genderTextView = view.findViewById(R.id.genderDataTxt);
         ageTextView = view.findViewById(R.id.ageDataTxt);*/

        //return view;
        //binding = FragmentDataReceivingBinding.inflate(inflater,container,false);

        //return binding.getRoot();
    }


    //using fragment object
    public void setData(Person person){
       /* nameTextView.setText(person.getName());
        genderTextView.setText(person.getGender());
        ageTextView.setText(person.getAge()+"");*/

        binding.nameDataTxt.setText(person.getName());
        binding.genderDataTxt.setText(person.getGender());
        binding.ageDataTxt.setText(person.getAge()+"");
    }
}