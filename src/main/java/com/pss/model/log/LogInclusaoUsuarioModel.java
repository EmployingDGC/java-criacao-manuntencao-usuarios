package com.pss.model.log;

import com.pss.model.LogModel;

public class LogInclusaoUsuarioModel extends LogModel {
    public LogInclusaoUsuarioModel(String usuario) {
        super("Inclusão", "Usuario", usuario);
    }
}
