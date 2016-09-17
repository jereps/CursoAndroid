package br.com.marcatruco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String tento1 = "1";
    int totalTime1 = 0;
    TextView txtSoma1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSoma1 = (TextView) findViewById(R.id.txtSoma1);
        txtSoma1.setText(String.valueOf(totalTime1));




    }

    public void um(View v){
        Button button = (Button) findViewById(v.getId());
        totalTime1 += 1;
        Log.d("TAG","Valor " + totalTime1);
    }
}
