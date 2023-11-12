package org.ws_solutions;

import org.ws_solutions.model.Usuario;

public class Principal {

    private static Usuario usuarioSessao;

    public static Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    public static void setUsuarioSessao(Usuario usuarioSessao) {
        Principal.usuarioSessao = usuarioSessao;
    }

}
