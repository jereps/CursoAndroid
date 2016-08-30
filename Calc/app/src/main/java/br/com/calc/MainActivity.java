package br.com.calc;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //variáveis globais
    Integer n1=0, n2=0, total=0;

    Button btnSoma;

    TextView txtResultado;

    EditText edt1, edt2;

    String teste1 = "Jeremias";

    //Boolean teste = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inicializar os componentes

        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        btnSoma = (Button) findViewById(R.id.btnSoma);
        txtResultado = (TextView) findViewById(R.id.txtResultado);


        //txtResultado.setText(teste1);

        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(edt1.getText().toString())){
                    Toast.makeText(getApplication(), "Os Campos Número 1 não Pode Ficar vazio", Toast.LENGTH_LONG).show();
                    edt1.requestFocus();
                    return;
                }
                else {
                    n1 = Integer.valueOf(edt1.getText().toString());


                }

                if(TextUtils.isEmpty(edt2.getText().toString())){
                    Toast.makeText(getApplication(), "Os Campos Número 2 não Pode Ficar vazio", Toast.LENGTH_LONG).show();
                    edt2.requestFocus();
                    return;
                }
                else {
                    n2 = Integer.valueOf(edt2.getText().toString());
                }

                total = n1 + n2;

                txtResultado.setText(total.toString());
                //Toast.makeText(getApplication(), "Jeremias"+n1+n2, Toast.LENGTH_LONG).show();

            }
        });
    }
}
