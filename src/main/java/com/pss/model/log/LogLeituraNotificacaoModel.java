package com.pss.model.log;

import com.pss.model.LogModel;
import com.pss.model.usuario.UsuarioModel;

public class LogLeituraNotificacaoModel extends LogModel {
    public LogLeituraNotificacaoModel(UsuarioModel usuario) {
        super("Leitura", "Notificação", usuario);
    }
}
