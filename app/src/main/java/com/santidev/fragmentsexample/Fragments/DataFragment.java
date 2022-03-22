package com.santidev.fragmentsexample.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.santidev.fragmentsexample.R;


public class DataFragment extends Fragment {

    private EditText textName;
    private Button btnSend;
    private DataListener callback;

    public DataFragment(){

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            callback = (DataListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        textName = (EditText) view.findViewById(R.id.editTextData);
        btnSend = (Button) view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSend = textName.getText().toString();
                callback.sendData(textToSend);
            }
        });

        return view;
    }


    public interface DataListener{
        void sendData(String text);
    }
}