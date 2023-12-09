package com.pss.model.log;

import com.pss.model.LogModel;
import com.pss.model.usuario.UsuarioModel;

public class LogExclusaoUsuarioModel extends LogModel {
    public LogExclusaoUsuarioModel(UsuarioModel usuario) {
        super("Exclusão", "Usuario", usuario);
    }
}
