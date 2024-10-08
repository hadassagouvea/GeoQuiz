package com.example.geoquiz_v4_sqlite;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class RegistraRespostaActivity extends AppCompatActivity {
    private RespostaDB mRespostaDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRespostaDB = new RespostaDB(this);

        Intent intent = getIntent();
        boolean respostaCorreta = intent.getBooleanExtra("respostaCorreta", false);

        int resposta = respostaCorreta ? 1 : 0;

        Resposta novaResposta = new Resposta(UUID.randomUUID(), resposta, true, false);
        
        mRespostaDB.addResposta(novaResposta);

        Intent resultadoIntent = new Intent();
        resultadoIntent.putExtra("respostaPressionada", respostaCorreta); 
        setResult(RESULT_OK, resultadoIntent);
        
        finish();
    }
}
