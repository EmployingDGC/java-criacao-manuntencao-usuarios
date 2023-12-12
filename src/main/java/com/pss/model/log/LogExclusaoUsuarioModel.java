package com.pss.model.log;

import com.pss.model.LogModel;

public class LogExclusaoUsuarioModel extends LogModel {
    public LogExclusaoUsuarioModel(String usuario) {
        super("Exclusão", "Usuario", usuario);
    }
}
