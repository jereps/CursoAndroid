package br.com.sqlite.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.sqlite.R;
import br.com.sqlite.datacontroller.DbController;

public class CadastroActivity extends AppCompatActivity {

    private String email_usuario;
    private String senha_usuario;
    private String senha2;
    private DbController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastro);

        final EditText edtEmailCadastro = (EditText) findViewById(R.id.edtEmailCadastro);
        final EditText edtSenhaCadastro = (EditText) findViewById(R.id.edtSenhaCadastro);
        final EditText edtSenha2Cadastro = (EditText) findViewById(R.id.edtSenha2Cadastro);
        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int error = 0;

                email_usuario = edtEmailCadastro.getText().toString().trim();
                senha_usuario = edtSenhaCadastro.getText().toString().trim();
                senha2 = edtSenha2Cadastro.getText().toString().trim();

                if (email_usuario.equals("")) {
                    edtEmailCadastro.setError("Esté campo não pode estar vazio\n" +
                            " This field is not empty!");
                    edtEmailCadastro.requestFocus();
                    error = 1;
                }else if (senha_usuario.equals("")){
                    edtSenhaCadastro.setError("Esté campo não pode estar vazio\n" +
                            " This field is not empty!");
                    edtSenhaCadastro.requestFocus();
                    error = 1;
                }else if (senha2.equals("")){
                    edtSenha2Cadastro.setError("Esté campo não pode estar vazio\n" +
                            " This field is not empty!");
                    edtSenha2Cadastro.requestFocus();
                    error = 1;
                }else if (!senha2.equals(senha_usuario)){
                    edtSenha2Cadastro.setError("As Senhas não coincidem!\n" +
                            " Passwords do not match!");
                    edtSenha2Cadastro.setText("");
                    edtSenha2Cadastro.requestFocus();
                    error = 1;
                }


                if (error == 0){
                    Intent it2;

                    dbController.insertRegistro(email_usuario, senha_usuario);
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        dbController = new DbController(getBaseContext());
    }
}

