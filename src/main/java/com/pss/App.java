package com.pss;

import com.pss.collection.UsuarioCollection;
import com.pss.model.usuario.AdministradorModel;
import com.pss.presenter.TelaPrincipalPresenter;

public final class App {
    public static void main(String[] args) {
        AdministradorModel u = new AdministradorModel("Employing", "admin", "senhaadministrador");
        u.aprovarCadastro();

        UsuarioCollection.getInstancia().add(u);
        new TelaPrincipalPresenter();
    }
}
