package com.santidev.fragmentsexample;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.santidev.fragmentsexample.Fragments.DataFragment;
import com.santidev.fragmentsexample.Fragments.DetailsFragment;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String text) {
        // Llamar al metodo renderizarTexto del DetailsFragment,
        // pasandole el texto que recibamos por parametro en este mismo metodo

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);

    }
}