package com.pss.model.log;

import com.pss.model.LogModel;
import com.pss.model.usuario.UsuarioModel;

public class LogAutorizacaoUsuarioModel extends LogModel {
    public LogAutorizacaoUsuarioModel(UsuarioModel usuario) {
        super("Autorização", "Usuário", usuario);
    }
}
