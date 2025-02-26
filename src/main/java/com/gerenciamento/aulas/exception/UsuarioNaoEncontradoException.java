package com.gerenciamento.aulas.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    private String msg;

    public UsuarioNaoEncontradoException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
