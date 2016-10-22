package br.com.sqlite.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.sqlite.R;
import br.com.sqlite.datacontroller.DbController;

public class LoginActivity extends AppCompatActivity {

    private String email_usuario;
    private String senha_usuario;
    private DbController db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        db = new DbController(getBaseContext());

        final EditText edtEmailLogin = (EditText)findViewById(R.id.edtEmailLogin);
        final EditText edtSenhaLogin = (EditText)findViewById(R.id.edtSenhaLogin);
        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int error = 0;

                email_usuario = edtEmailLogin.getText().toString().trim();
                senha_usuario = edtSenhaLogin.getText().toString().trim();


                if (email_usuario.equals("")) {
                    edtEmailLogin.setError("Esté campo não pode estar vazio\n" +
                            " This field is not empty!");
                    edtEmailLogin.requestFocus();
                    error = 1;
                }else if (senha_usuario.equals("")){
                    edtSenhaLogin.setError("Esté campo não pode estar vazio\n" +
                            " This field is not empty!");
                    edtSenhaLogin.requestFocus();
                    error = 1;
                }


                if (error == 0){
                    Intent it2;

                    db.selectRegistro(email_usuario, senha_usuario);

                    //Intent it = new Intent(LoginActivity.this, CadastroActivity.class);
                    //startActivity(it);
                }


            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }
}