package com.manuni.fragmenttofragmentdatasending;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.manuni.fragmenttofragmentdatasending.databinding.ActivityMainBinding;
import com.manuni.fragmenttofragmentdatasending.fragments.DataReceivingFragment;
import com.manuni.fragmenttofragmentdatasending.fragments.DataSendingFragment;
import com.manuni.fragmenttofragmentdatasending.models.Person;

public class MainActivity extends AppCompatActivity implements DataSendingFragment.DataSendingListener {
    public static final String RECEIVER_FRAGMENT = "receiver_fragment";
    public static final String TAG = "MyTag";
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSendingFragment dataSendingFragment = new DataSendingFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerTwo,dataSendingFragment).commit();
            }
        });

        DataReceivingFragment receivingFragment = new DataReceivingFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerOne,receivingFragment,RECEIVER_FRAGMENT).commit();


    }

    @Override
    public void onDataSend(Person person) {

    DataReceivingFragment fragment = (DataReceivingFragment) getSupportFragmentManager().findFragmentByTag(RECEIVER_FRAGMENT);
    fragment.setData(person);

    }
}