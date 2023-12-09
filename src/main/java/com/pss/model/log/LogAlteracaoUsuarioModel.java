package com.pss.model.log;

import com.pss.model.LogModel;
import com.pss.model.usuario.UsuarioModel;

public class LogAlteracaoUsuarioModel extends LogModel {
    public LogAlteracaoUsuarioModel(UsuarioModel usuario) {
        super("Alteração", "Usuario", usuario);
    }
}
