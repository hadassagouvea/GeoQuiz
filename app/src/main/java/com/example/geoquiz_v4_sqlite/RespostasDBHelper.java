package com.example.geoquiz_v4_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.UUID;

public class RespostasDBHelper extends SQLiteOpenHelper {
    private static final int VERSAO = 2;
    private static final String NOME_DATABASE = "respostasDB";

    public RespostasDBHelper(Context context) {
        super(context, NOME_DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + RespostasDbSchema.RespostasTbl.NOME + " (" +
                "_id integer PRIMARY KEY autoincrement," +
                RespostasDbSchema.RespostasTbl.Cols.UUID + " INTEGER," +
                RespostasDbSchema.RespostasTbl.Cols.RESPOSTA_CORRETA + " INTEGER," +
                RespostasDbSchema.RespostasTbl.Cols.RESPOSTA_OFERECIDA + " INTEGER," +
                RespostasDbSchema.RespostasTbl.Cols.COLOU + " INTEGER" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        // Política de upgrade é simplesmente descartar o conteúdo e começar novamente
        db.execSQL("DROP TABLE IF EXISTS " + RespostasDbSchema.RespostasTbl.NOME);
        onCreate(db);
    }
}
