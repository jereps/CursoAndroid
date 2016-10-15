package br.com.sqlite.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.sqlite.R;

public class CadastroActivity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastro);

        EditText edtEmailCadastro = (EditText)findViewById(R.id.edtEmailCadastro);
        EditText edtSenhaCadastro = (EditText)findViewById(R.id.edtSenhaCadastro);
        EditText edtSenha2Cadastro = (EditText)findViewById(R.id.edtSenha2Cadastro);
        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

        }
        });
        }
        }