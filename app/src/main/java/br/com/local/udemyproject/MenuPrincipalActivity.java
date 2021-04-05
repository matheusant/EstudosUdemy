package br.com.local.udemyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal_layout);
    }

    public void appAbastecimento(View view){

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void appGorjeta(View view){

        startActivity(new Intent(getApplicationContext(), GorjetaActivity.class));
    }

}