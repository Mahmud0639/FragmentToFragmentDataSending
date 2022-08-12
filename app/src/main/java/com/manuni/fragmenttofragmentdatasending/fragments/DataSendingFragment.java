package com.manuni.fragmenttofragmentdatasending.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.manuni.fragmenttofragmentdatasending.MainActivity;
import com.manuni.fragmenttofragmentdatasending.R;
import com.manuni.fragmenttofragmentdatasending.databinding.FragmentDataSendingBinding;
import com.manuni.fragmenttofragmentdatasending.models.Person;


public class DataSendingFragment extends Fragment {
    FragmentDataSendingBinding binding;
    private DataSendingListener listener;



    public DataSendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDataSendingBinding.inflate(inflater,container,false);

        binding.sendDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameDataValue = binding.nameET.getText().toString();
                String genderDataValue = binding.genderET.getText().toString();
                int ageDataValue = Integer.parseInt(binding.ageET.getText().toString());

                Person person = new Person(nameDataValue,genderDataValue,ageDataValue);
                Log.d(MainActivity.TAG, "onClick: "+person.getName());
                Log.d(MainActivity.TAG, "onClick: "+person.getGender());

                listener.onDataSend(person);

            }
        });


        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DataSendingListener){
            listener = (DataSendingListener) context;
        }
    }

    public interface DataSendingListener{
        void onDataSend(Person person);
    }
}