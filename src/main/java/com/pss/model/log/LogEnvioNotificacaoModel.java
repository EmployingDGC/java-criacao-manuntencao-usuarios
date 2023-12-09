package com.pss.model.log;

import com.pss.model.LogModel;
import com.pss.model.usuario.UsuarioModel;

public class LogEnvioNotificacaoModel extends LogModel {
    public LogEnvioNotificacaoModel(UsuarioModel usuario) {
        super("Envio", "Notificação", usuario);
    }
}
