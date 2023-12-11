package com.pss.model.log;

import com.pss.model.LogModel;

public class LogAlteracaoUsuarioModel extends LogModel {
    public LogAlteracaoUsuarioModel(String usuario) {
        super("Alteração", "Usuario", usuario);
    }
}
