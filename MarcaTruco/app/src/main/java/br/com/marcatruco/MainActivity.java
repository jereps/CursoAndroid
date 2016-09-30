package br.com.marcatruco;

import android.app.AlertDialog;
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

    Button button,button1,button2,button3,button4;
    Button button6,button7,button8,button9,button10;
    int totalTime1 = 0, totalTime2 = 0;
    TextView txtTotal1,txtTotal2;
    EditText edtNome1,edtNome2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configurações Para Time 1
        edtNome1 = (EditText) findViewById(R.id.edtNome1);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(onClickTime1);

        button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(onClickTime1);

        button2 = (Button) findViewById(R.id.button4);
        button2.setOnClickListener(onClickTime1);

        button3 = (Button) findViewById(R.id.button5);
        button3.setOnClickListener(onClickTime1);

        button4 = (Button) findViewById(R.id.button3);
        button4.setOnClickListener(onClickTime1);

        txtTotal1 = (TextView) findViewById(R.id.txtTotal1);

        //Configurações Para Time 2
        edtNome2 = (EditText) findViewById(R.id.edtNome2);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(onClickTime2);

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(onClickTime2);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(onClickTime2);

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(onClickTime2);

        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(onClickTime2);

        txtTotal2 = (TextView) findViewById(R.id.txtTotal2);
    }

    //função OnClick para Time 1
    private View.OnClickListener onClickTime1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(TextUtils.isEmpty(edtNome1.getText().toString())){
                Toast.makeText(getApplication(), "Digite Um Nome Para o Primeiro Time", Toast.LENGTH_LONG).show();
                edtNome1.requestFocus();
                return;
            }
            switch(v.getId()){
                case R.id.button:
                    totalTime1 += 1;
                    atualiza();
                    break;

                case R.id.button2:
                    totalTime1 += 3;
                    atualiza();
                    break;

                case R.id.button4:
                    totalTime1 += 6;
                    atualiza();
                    break;

                case R.id.button3:
                    totalTime1 += 9;
                    atualiza();
                    break;

                case R.id.button5:
                    totalTime1 += 12;
                    atualiza();
                    break;

            }

        }
    };

    //Função para setar a Soma Total do Time 1
    private void atualiza(){
        if(totalTime1 < 12){
            txtTotal1.setText(String.valueOf(totalTime1));
        }
        else {
            txtTotal1.setText(String.valueOf(totalTime1));
            alertaDialog(edtNome1.getText().toString());
            //Toast.makeText(getApplication(),"Time: "+ edtNome1.getText()+ " Ganhou",Toast.LENGTH_LONG).show();
        }

    }


    //função OnClick para Time 2
    private View.OnClickListener onClickTime2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(TextUtils.isEmpty(edtNome2.getText().toString())){
                Toast.makeText(getApplication(), "Digite Um Nome Para o Segundo Time", Toast.LENGTH_LONG).show();
                edtNome2.requestFocus();
                return;
            }

            switch(v.getId()){
                case R.id.button6:
                    totalTime2 += 1;
                    atualiza2();
                    break;

                case R.id.button7:
                    totalTime2 += 3;
                    atualiza2();
                    break;

                case R.id.button8:
                    totalTime2 += 6;
                    atualiza2();
                    break;

                case R.id.button10:
                    totalTime2 += 9;
                    atualiza2();
                    break;

                case R.id.button9:
                    totalTime2 += 12;
                    atualiza2();
                    break;

            }

        }
    };

    //Função para setar a Soma Total do Time 2
    private void atualiza2(){
        if(totalTime2 < 12){
            txtTotal2.setText(String.valueOf(totalTime2));
        }
        else {
            txtTotal2.setText(String.valueOf(totalTime2));
            alertaDialog(edtNome2.getText().toString());
            //Toast.makeText(getApplication(),"Time: "+ edtNome2.getText()+ " Ganhou",Toast.LENGTH_LONG).show();
        }

    }

    private void alertaDialog(String time) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);//Cria o gerador do AlertDialog
        builder.setTitle("Fim De Jogo!");//define o titulo
        builder.setMessage("O Time: "+time+" Ganhou! "+ "\nDeseja Jogar Novamente?");//define a mensagem
        //define um botão como positivo
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                totalTime1 = 0;
                totalTime2 = 0;
                edtNome1.setText("");
                edtNome2.setText("");
                txtTotal1.setText("0");
                txtTotal2.setText("0");
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();//Exibe
    }
}
