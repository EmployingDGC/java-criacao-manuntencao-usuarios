package com.pss.model.log;

import com.pss.model.LogModel;
import com.pss.model.usuario.UsuarioModel;

public class LogAlteracaoSenhaModel extends LogModel {
    public LogAlteracaoSenhaModel(UsuarioModel usuario) {
        super("Alteração", "Senha", usuario);
    }
}
