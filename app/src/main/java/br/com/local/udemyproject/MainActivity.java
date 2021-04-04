package br.com.local.udemyproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtPrecoAlcool, edtPrecoGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPrecoAlcool        = findViewById(R.id.edtPrecoAlcool);
        edtPrecoGasolina      = findViewById(R.id.edtPrecoGasolina);
        txtResultado          = findViewById(R.id.txtResultado);


    }

    public void botaoCalcular(View view){
        String precoAlcool      = edtPrecoAlcool.getText().toString();
        String precoGasolina    = edtPrecoGasolina.getText().toString();

        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if ( camposValidados ){
            alertDialog();
        }else{
            Toast.makeText(getApplicationContext(),
                    "Insira todos os campos!!",
                    Toast.LENGTH_SHORT).show();

            limpar();
        }
    }

    public void calcularPreco(){

        String precoAlcool      = edtPrecoAlcool.getText().toString();
        String precoGasolina    = edtPrecoGasolina.getText().toString();

        boolean camposValidados = validarCampos(precoAlcool, precoGasolina);

        if ( camposValidados ){
            Double vAlcool      = Double.parseDouble(precoAlcool);
            Double vGasolina    = Double.parseDouble(precoGasolina);

            if ( vAlcool / vGasolina >= 0.7  ){
                txtResultado.setText("Melhor utilizar gasolina");
            }else{
                txtResultado.setText("Melhor utilizar álcool");
            }

        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina){

        boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ){

            camposValidados = false;

        }else if ( pGasolina == null || pGasolina.equals("") ){

            camposValidados = false;

        }

        return camposValidados;
    }

    public void limpar(){
        txtResultado.setText("Melhor a ser utilizado");
        edtPrecoAlcool.setText("");
        edtPrecoGasolina.setText("");
    }

    public void alertDialog(){

        String precoAlcool      = edtPrecoAlcool.getText().toString();
        String precoGasolina    = edtPrecoGasolina.getText().toString();

        // instanciando a classe
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // configurando titulo e mensagem
        dialog.setTitle("Confirmação");
        dialog.setMessage("Preço Álcool: R$ " + precoAlcool  + "\nPreço Gasolina: R$ " + precoGasolina);

        // configurando cancelamento
        dialog.setCancelable(false);

        // configurando ícones
        dialog.setIcon( android.R.drawable.ic_dialog_alert );

        // configurando botões
        dialog.setPositiveButton("Calcular", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                calcularPreco();
            }
        });

        dialog.setNegativeButton("Corrigir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                limpar();
            }
        });

        // criação e visualização
        dialog.create();
        dialog.show();

    }

}