package br.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;

public class DbHelper extends SQLiteOpenHelper {

    //Nome do banco de dados
    private static final String database_nome = "Teste.db";

    //Versão da base de dados
    private static final int database_versao = 1;

    //Criando tabelas
    private static final String tabela0 = "CREATE TABLE IF NOT EXISTS" + getVersionTable(0) + " ("
            + "id_usuario INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            + "email_usuario varchar(2) NOT NULL, "
            + "senha_usuario varchar(2) NOT NULL);";

    //Construtor
    public DbHelper(Context context) {
        super(context, database_nome, null, database_versao);
    }

    //Métodos Obrigatórios do SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tabela0);
        onUpgrade(db, 0, database_versao);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //Essa função retorna o nome da tabela passando a posição que ela esta no Array
    static String getVersionTable(int posicao){
        final String[] database_table = {"usuario","produtos"};
        return database_table[posicao];
    }


}
