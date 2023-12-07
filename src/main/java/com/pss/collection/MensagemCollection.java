package com.pss.collection;

import java.util.ArrayList;
import java.util.List;

import com.pss.model.MensagemModel;

public class MensagemCollection {
    private List<MensagemModel> mensagens;

    private static MensagemCollection instancia;

    private MensagemCollection() {
        this.mensagens = new ArrayList<MensagemModel>();
    }

    public static MensagemCollection getInstancia() {
        if (instancia == null) {
            instancia = new MensagemCollection();
        }

        return instancia;
    }

    public List<MensagemModel> getMensagens() {
        return this.mensagens;
    }

    public void add(MensagemModel mensagem) {
        this.mensagens.add(mensagem);
    }
}
