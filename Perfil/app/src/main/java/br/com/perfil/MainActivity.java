package br.com.perfil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnPerfil;
    private EditText edtNomeCompleto;
    private EditText edtProfissao;
    private Spinner spnRenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPerfil = (Button) findViewById(R.id.btn_perfil);
        edtNomeCompleto = (EditText) findViewById(R.id.edt_nome_completo);
        edtProfissao = (EditText) findViewById(R.id.edt_profissao);
        spnRenda = (Spinner) findViewById(R.id.spn_renda);

        btnPerfil.setOnClickListener(new View.OnClickListener(){




            @Override
            public void onClick(View view) {

                String nome = edtNomeCompleto.getText().toString();
                String profissao = edtProfissao.getText().toString();
                int posicao = (int) spnRenda.getSelectedItemId();

                if (nome.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe seu nome", Toast.LENGTH_SHORT).show();
                }
                else if (posicao == 0) {
                    Toast.makeText(MainActivity.this, "Informe sua renda", Toast.LENGTH_SHORT).show();
                }
                else if (profissao.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Informe sua profissão", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(new Intent(MainActivity.this, PerfilActivity.class));
                }

            }
        });
    }
}
