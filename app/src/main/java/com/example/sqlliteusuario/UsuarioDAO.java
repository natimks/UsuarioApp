package com.example.sqlliteusuario;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UsuarioDAO {
    SQLiteDatabase sqLiteDataBase;
    Context mContext;

    public UsuarioDAO(Context c) {
        mContext = c;
        sqLiteDataBase = c.openOrCreateDatabase("UsuarioDB", c.MODE_PRIVATE, null);
        sqLiteDataBase.execSQL("CREATE TABLE IF NOT EXISTS " +
                "usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome VARCHAR);");
    }

    public void inserir(Usuario u) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", u.nome);
        sqLiteDataBase.insert("usuario", null, contentValues);
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> listaUsuariosResult = new ArrayList<Usuario>();

        Cursor cursor = sqLiteDataBase.rawQuery("SELECT * FROM  usuario", null);
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            listaUsuariosResult.add(
                    new Usuario(cursor.getInt(cursor.getColumnIndex("id")),
                            cursor.getString(cursor.getColumnIndex("nome"))
                    )
            );
        }
        return listaUsuariosResult;
    }
}
