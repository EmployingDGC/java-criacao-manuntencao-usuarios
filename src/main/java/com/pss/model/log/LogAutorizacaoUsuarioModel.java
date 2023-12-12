package com.pss.model.log;

import com.pss.model.LogModel;

public class LogAutorizacaoUsuarioModel extends LogModel {
    public LogAutorizacaoUsuarioModel(String usuario) {
        super("Autorização", "Usuário", usuario);
    }
}
