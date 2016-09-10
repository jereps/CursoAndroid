package br.com.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario, edtSenha;
    Button btnLogin;

    String usuario = "aula7";
    String senha = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        eventoBtn();


    }

    public void eventoBtn(){

        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(edtUsuario.getText().toString().trim().equals(usuario) && edtSenha.getText().toString().equals(senha)){

                    Toast.makeText(getApplicationContext(), "Login Aceito", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), SegundaTela.class);
                    //intent.putExtra("ID", id);
                    intent.putExtra("USUARIO", usuario);
                    intent.putExtra("SENHA",senha);
                    startActivity(intent);

                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Acesso Negado!", Toast.LENGTH_LONG).show();
                    return;
                }

            }
        });

    }
}
