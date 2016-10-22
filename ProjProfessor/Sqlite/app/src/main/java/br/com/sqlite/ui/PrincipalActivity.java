package br.com.sqlite.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.sqlite.R;
import br.com.sqlite.datamodel.ItemLogin;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        TextView id = (TextView)findViewById(R.id.id);
        TextView email = (TextView)findViewById(R.id.email);
        TextView senha = (TextView)findViewById(R.id.senha);

        ItemLogin itemLogin = new ItemLogin();
        id.setText(itemLogin.getId_usuario());
        email.setText(itemLogin.getEmail_usuario());
        senha.setText(itemLogin.getSenha_usuario());
    }
}
