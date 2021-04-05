package br.com.local.udemyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class GorjetaActivity extends AppCompatActivity {

    private TextView txtPorcentagem;
    private TextView txtValorGorjeta;
    private TextView txtValorTotal;
    private TextInputEditText edtValor;
    private SeekBar seekBarPorcentagem;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gorjeta_layout);


        txtPorcentagem      = findViewById(R.id.txtPorcentagem);
        txtValorGorjeta     = findViewById(R.id.txtValorGorjeta);
        txtValorTotal       = findViewById(R.id.txtValorTotal);
        seekBarPorcentagem  = findViewById(R.id.seekBarPorcentagem);
        edtValor            = findViewById(R.id.edtValor);


        seekBarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                porcentagem = i;
                txtPorcentagem.setText( Math.round( porcentagem ) + "%" );
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){

        String valorRecuperado = edtValor.getText().toString();
        if ( valorRecuperado == null || valorRecuperado.equals("") ){

            Toast.makeText(
                    getApplicationContext(),
                    "Digite o valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();

        }else{

            double valorDigitado = Double.parseDouble( valorRecuperado );

            // calculando a gorjeta

            double gorjeta = valorDigitado * (porcentagem/100);

            double total = gorjeta + valorDigitado;


            txtValorGorjeta.setText( "R$ " + Math.round( gorjeta ) );

            txtValorTotal.setText( "R$ " + Math.round( total ) );


        }

    }
}