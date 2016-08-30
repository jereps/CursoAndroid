package br.com.Calc2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Estou setando o layout
        setContentView(R.layout.activity_main);

        //instanciando os componentes
        final EditText edtN1 = (EditText)findViewById(R.id.edtN1);
        final EditText edtN2 = (EditText)findViewById(R.id.edtN2);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        final TextView txvResult = (TextView) findViewById(R.id.txvResult);

        //criando evento do botão resultado
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //estou pegando o conteudo da caixa de texto e armazenando nas variaveis
                final String n1 = edtN1.getText().toString();
                final String n2 = edtN2.getText().toString();

                //aqui estou fazendo uma comparação para saber se o conteudo da variavel n1 é diferente de null
                if(n1.equals("")){

                    //imprimindo uma msg de alerta para o usuario
                    Toast.makeText(getApplicationContext(), "O campo número 1 não pode estar vazio!", Toast.LENGTH_LONG).show();

                    //direcionando o foco para o edittext
                    edtN1.requestFocus();

                    return;

                }else if(n2.equals("")){//aqui estou fazendo uma comparação para saber se o conteudo da variavel n2 é diferente de null

                    //imprimindo uma msg de alerta para o usuario
                    Toast.makeText(getApplicationContext(), "O campo número 2 não pode estar vazio!", Toast.LENGTH_LONG).show();

                    //direcionando o foco para o edittext
                    edtN2.requestFocus();

                    return;
                }

                //estou criando uma variavel do tipo Double(recebe números decimais e somando as 2 strings já convertendo para Double
                double result = Double.parseDouble(n1) + Double.parseDouble(n2);

                //estou pegando o conteudo da variavel total e setando no textview resultado
                txvResult.setText("Resultado: "+result);
            }
        });
    }
}