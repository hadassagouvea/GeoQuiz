package com.example.geoquiz_v4_sqlite;

import java.util.UUID;

public class Resposta {
    private UUID id; 
    private int respostaCorreta; 
    private boolean respostaOferecida; 
    private boolean colou; 

    public Resposta(UUID id, int respostaCorreta, boolean respostaOferecida, boolean colou) {
        this.id = id;
        this.respostaCorreta = respostaCorreta;
        this.respostaOferecida = respostaOferecida;
        this.colou = colou;
    }

    public UUID getId() {
        return id;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public boolean isRespostaOferecida() {
        return respostaOferecida;
    }

    public boolean isColou() {
        return colou;
    }
}
