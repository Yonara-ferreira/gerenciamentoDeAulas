package com.gerenciamento.aulas.exception;

public class SolicitacaoNaoEncontrada extends RuntimeException{

    private String msg;

    public SolicitacaoNaoEncontrada(String msg){
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
}
