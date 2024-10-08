package com.example.geoquiz_v4_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuestoesDBHelper extends SQLiteOpenHelper {
    private static final int VERSAO = 2;
    private static final String NOME_DATABASE = "questoesDB";

    public QuestoesDBHelper(Context context) {
        super(context, NOME_DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ QuestoesDbSchema.QuestoesTbl.NOME+ "("+
                "_id integer PRIMARY KEY autoincrement,"+
                QuestoesDbSchema.QuestoesTbl.Cols.UUID+ ","+
                QuestoesDbSchema.QuestoesTbl.Cols.QUESTAO_CORRETA + ","+
                QuestoesDbSchema.QuestoesTbl.Cols.TEXTO_QUESTAO+ ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
            // Política de upgrade é simplesmente descartar o conteúdo e começar novamente
            db.execSQL("DROP TABLE IF EXISTS " + QuestoesDbSchema.QuestoesTbl.NOME);
            onCreate(db);
    }

    public Cursor QueryRepostas(String selection, String[] selectionArgs) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("Resposta", null, selection, selectionArgs, null, null, null);
    }

    public void LimpaRespostas() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Resposta");
    }
}