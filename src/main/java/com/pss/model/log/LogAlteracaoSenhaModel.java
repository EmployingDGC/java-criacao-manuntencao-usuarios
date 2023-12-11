package com.pss.model.log;

import com.pss.model.LogModel;

public class LogAlteracaoSenhaModel extends LogModel {
    public LogAlteracaoSenhaModel(String usuario) {
        super("Alteração", "Senha", usuario);
    }
}
