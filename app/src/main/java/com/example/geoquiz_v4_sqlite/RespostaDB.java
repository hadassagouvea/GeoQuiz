package com.example.geoquiz_v4_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.UUID;

public class RespostaDB {
    private Context mContext;
    private static Context mStaticContext;
    private SQLiteDatabase mDatabase;

    public RespostaDB(Context contexto) {
        mContext = contexto.getApplicationContext();
        mStaticContext = mContext;
        mDatabase = new RespostasDBHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getValoresConteudo(Resposta r) {
        ContentValues valores = new ContentValues();
        
        // pares chave-valor: nomes das colunas - valores
        valores.put(RespostasDbSchema.RespostasTbl.Cols.UUID, r.getId().toString());
        valores.put(RespostasDbSchema.RespostasTbl.Cols.RESPOSTA_CORRETA, r.getRespostaCorreta());
        valores.put(RespostasDbSchema.RespostasTbl.Cols.RESPOSTA_OFERECIDA, r.isRespostaOferecida() ? 1 : 0);
        valores.put(RespostasDbSchema.RespostasTbl.Cols.COLOU, r.isColou() ? 1 : 0);
        
        return valores;
    }

    public void addResposta(Resposta r) {
        ContentValues valores = getValoresConteudo(r);
        mDatabase.insert(RespostasDbSchema.RespostasTbl.NOME, null, valores);
    }

    public void updateResposta(Resposta r) {
        String uuidString = r.getId().toString();
        ContentValues valores = getValoresConteudo(r);
        
        mDatabase.update(
                RespostasDbSchema.RespostasTbl.NOME,
                valores,
                RespostasDbSchema.RespostasTbl.Cols.UUID + " = ?",
                new String[]{uuidString}
        );
    }

    public Cursor queryResposta(String clausulaWhere, String[] argsWhere) {
        Cursor cursor = mDatabase.query(
                RespostasDbSchema.RespostasTbl.NOME,
                null,  // todas as colunas
                clausulaWhere,
                argsWhere,
                null, // sem group by
                null, // sem having
                null  // sem order by
        );
        return cursor;
    }

    public void limpaBanco() {

    }

    public void removeBanco() {
        mDatabase.delete(RespostasDbSchema.RespostasTbl.NOME, null, null);
    }
}