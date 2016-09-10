package br.com.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    TextView lbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        lbl = (TextView) findViewById(R.id.lbl);

        Intent intent = getIntent();

        String usuario = intent.getStringExtra("USUARIO");
        String senha = intent.getStringExtra("SENHA");
        lbl.setText("Bem Vindo! "+usuario+ "Senha: " +senha);


    }
}
