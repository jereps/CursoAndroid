package br.com.sqlite.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.sqlite.R;
import br.com.sqlite.datacontroller.DbController;
import br.com.sqlite.datamodel.ItemLogin;
import br.com.sqlite.recycleview.ItemAdapter;

public class PrincipalActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private DbController db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        recyclerView = (RecyclerView) findViewById(R.id.lista);

        db = new DbController(getBaseContext());

        itemAdapter = new ItemAdapter(getBaseContext(), new ArrayList<ItemLogin>());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);

        itemAdapter = new ItemAdapter(getBaseContext(), db.selectAllRegistros());
        recyclerView.setAdapter(itemAdapter);

        //db.selectAllRegistros();
    }
}
