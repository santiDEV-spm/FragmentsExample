package com.santidev.fragmentsexample;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.santidev.fragmentsexample.Fragments.DataFragment;
import com.santidev.fragmentsexample.Fragments.DetailsFragment;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    private boolean isMultipanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultipanel();
    }

    @Override
    public void sendData(String text) {
        // Llamar al metodo renderizarTexto del DetailsFragment,
        // pasandole el texto que recibamos por parametro en este mismo metodo
        if(this.isMultipanel) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        }else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);

        }
    }

    private void setMultipanel(){
        this.isMultipanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }
}