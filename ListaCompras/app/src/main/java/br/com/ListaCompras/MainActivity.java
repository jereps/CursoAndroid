package br.com.ListaCompras;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.app.AlertDialog;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chbArroz, chbLeite, chbCarne, chbFeijao, chbRefri;
    Button btnTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chbArroz = (CheckBox) findViewById(R.id.chbArroz);
        chbLeite = (CheckBox) findViewById(R.id.chbLeite);
        chbCarne = (CheckBox) findViewById(R.id.chbCarne);
        chbFeijao = (CheckBox) findViewById(R.id.chbFeijao);
        chbRefri = (CheckBox) findViewById(R.id.chbRefri);

        btnTotal = (Button) findViewById(R.id.btnTotal);

        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double total = 0;

                if(chbArroz.isChecked())
                    total += 2.69;

                if(chbLeite.isChecked())
                    total += 5.00;

                if(chbCarne.isChecked())
                    total += 10.00;

                if(chbFeijao.isChecked())
                    total += 2.30;

                if(chbRefri.isChecked())
                    total += 2.00;

                Toast.makeText(getApplication(), "Total "+ total, Toast.LENGTH_LONG).show();
                //AlertDialog.Builder alertdialog = new AlertDialog.Builder(this).create();
                //AlertDialog alert = alertdialog.create();
                //alert.show();



                //showAlert("Valor Total da Compra", 0, String.valueOf(total), "OK", false);
            }
        });
    }
}
