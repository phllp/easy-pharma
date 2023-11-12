package org.ws_solutions.controller;

import org.ws_solutions.Principal;
import org.ws_solutions.model.Usuario;

public class ControllerLogin extends ControllerBase {

    public boolean login(String username, String password) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        boolean usuarioExiste = usuario.validaLogin();

        if (usuarioExiste) {
            Principal.setUsuarioSessao(usuario);
            return true;
        }
        return false;
    }
}
