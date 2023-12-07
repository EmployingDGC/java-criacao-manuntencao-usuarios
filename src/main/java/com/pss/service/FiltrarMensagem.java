package com.pss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.pss.model.MensagemModel;
import com.pss.model.usuario.UsuarioModel;

public class FiltrarMensagem {
    static public List<MensagemModel> filtrarMensagem(List<MensagemModel> mensagens, String conteudo) {
        List<MensagemModel> mensagensFiltradas = new ArrayList<MensagemModel>();

        String regex = String.format(".*%s.*", conteudo);
        Pattern pattern = Pattern.compile(regex);

        for (MensagemModel msg : mensagens) {
            if (pattern.matcher(msg.getMensagem()).matches()) {
                mensagensFiltradas.add(msg);
            }
        }

        return mensagensFiltradas;
    }

    static public List<MensagemModel> filtrarMensagemPorRemetente(List<MensagemModel> mensagens, String remetente) {
        List<MensagemModel> mensagensFiltradas = new ArrayList<MensagemModel>();

        String regex = String.format(".*%s.*", remetente);
        Pattern pattern = Pattern.compile(regex);

        for (MensagemModel msg : mensagens) {
            String nomeMaisUsuario = String.format(
                "%s%s",
                msg.getRemetente().getNome(),
                msg.getRemetente().getUsuario()
            );

            if (pattern.matcher(nomeMaisUsuario).matches()) {
                mensagensFiltradas.add(msg);
            }
        }

        return mensagensFiltradas;
    }

    static public List<MensagemModel> filtrarMensagemPorRemetente(List<MensagemModel> mensagens, UsuarioModel remetente) {
        List<MensagemModel> mensagensFiltradas = new ArrayList<MensagemModel>();

        for (MensagemModel msg : mensagens) {
            if (msg.getRemetente() == remetente) {
                mensagensFiltradas.add(msg);
            }
        }

        return mensagensFiltradas;
    }

    static public List<MensagemModel> filtrarMensagemPorDestinatario(List<MensagemModel> mensagens, String destinatario) {
        List<MensagemModel> mensagensFiltradas = new ArrayList<MensagemModel>();

        String regex = String.format(".*%s.*", destinatario);
        Pattern pattern = Pattern.compile(regex);

        for (MensagemModel msg : mensagens) {
            String nomeMaisUsuario = String.format(
                "%s%s",
                msg.getDestinatario().getNome(),
                msg.getDestinatario().getUsuario()
            );

            if (pattern.matcher(nomeMaisUsuario).matches()) {
                mensagensFiltradas.add(msg);
            }
        }

        return mensagensFiltradas;
    }

    static public List<MensagemModel> filtrarMensagemPorDestinatario(List<MensagemModel> mensagens, UsuarioModel destinatario) {
        List<MensagemModel> mensagensFiltradas = new ArrayList<MensagemModel>();

        for (MensagemModel msg : mensagens) {
            if (msg.getDestinatario() == destinatario) {
                mensagensFiltradas.add(msg);
            }
        }

        return mensagensFiltradas;
    }

    static public List<MensagemModel> filtrarMensagemLida(List<MensagemModel> mensagens) {
        return filtrarMensagemLida(mensagens, false);
    }

    static public List<MensagemModel> filtrarMensagemLida(List<MensagemModel> mensagens, boolean inverter) {
        List<MensagemModel> mensagensFiltradas = new ArrayList<MensagemModel>();

        boolean foiLida = true;

        if (inverter) {
            foiLida = false;
        }

        for (MensagemModel msg : mensagens) {
            if (msg.isLida() == foiLida) {
                mensagensFiltradas.add(msg);
            }
        }

        return mensagensFiltradas;
    }
}
