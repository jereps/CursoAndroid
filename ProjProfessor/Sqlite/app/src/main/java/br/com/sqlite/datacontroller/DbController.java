package br.com.sqlite.datacontroller;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.DateFormat;

import br.com.sqlite.database.DbHelper;
import br.com.sqlite.datamodel.ItemLogin;

public class DbController {

    private static DbHelper dbHelper;
    private static SQLiteDatabase db;
    private static final String leitura = "leitura";
    private static final String escrita = "escrita";

    public DbController(Context context){
        dbHelper = new DbHelper(context);
    }

    //abre a conexão com o DB
    private static SQLiteDatabase openConn(String operacao){
        if (db == null || !db.isOpen())

            if (operacao.equals(escrita))
                db = dbHelper.getWritableDatabase();
            else
                db = dbHelper.getReadableDatabase();

        return db;
    }

    //fechar conexão com o DB
    private static void closseConn(){

        if (dbHelper != null) dbHelper.close();
        if(db != null) db.close();
    }

    //isert
    public String insertRegistro(String email, String senha){

        long resultado;

        openConn(escrita);
        ContentValues valores = new ContentValues();
        valores.put("email_usuario", email);
        valores.put("senha_usuario", senha);
        resultado = db.insertWithOnConflict("usuarios", null, valores, SQLiteDatabase.CONFLICT_REPLACE);
        closseConn();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";

    }

    //select
    public Boolean selectRegistro(String email, String senha){

        Boolean isValid = false;

        String where = " where email_usuario = '" +email+ "' ";
        String and = " and senha_usuario = '" +senha+ "' ";
        String query = " select * from usuario " + where + and;

        Cursor cursor = openConn(leitura).rawQuery(query, null);

        if (cursor != null){

            while (cursor.moveToNext()){
                ItemLogin itemLogin = new ItemLogin();
                itemLogin.setId_usuario(cursor.getInt(cursor.getColumnIndex("id_usuario")));
                itemLogin.setEmail_usuario(cursor.getString(cursor.getColumnIndex("email_usuario")));
                itemLogin.setSenha_usuario(cursor.getString(cursor.getColumnIndex("senha_usuario")));

            }
        }

        return isValid;
    }

}
