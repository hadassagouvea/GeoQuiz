package com.example.geoquiz_v4_sqlite;

import java.util.UUID;

public class RespostasDbSchema {
    public static final class RespostasTbl {
        public static final String NOME = "Respostas"; 
        public static final class Cols { // Identificação das colunas da tabela Respostas
            public static final String UUID = "uuid"; 
            public static final String RESPOSTA_CORRETA = "resposta_correta"; 
            public static final String RESPOSTA_OFERECIDA = "resposta_oferecida"; 
            public static final String COLOU = "colou"; 
        }
    }
}
