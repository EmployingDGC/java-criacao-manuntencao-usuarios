package com.pss.model.log;

import com.pss.model.LogModel;
import com.pss.model.usuario.UsuarioModel;

public class LogInclusaoUsuarioModel extends LogModel {
    public LogInclusaoUsuarioModel(UsuarioModel usuario) {
        super("Inclusão", "Usuario", usuario);
    }
}
