package org.ws_solutions.model;

import org.ws_solutions.db.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Usuario {
    private String id;
    private String username;
    private String password;

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validaLogin() {
        String usernameUsuario = "\'" + this.getUsername() + "\'";
        String passwordUsuario = "\'" + this.getPassword() + "\'";

        String sql =  "SELECT * FROM usuarios WHERE username = " + usernameUsuario+ " AND password = " + passwordUsuario +";";
        Connection con = ConnectionDB.conectar();
        try {
            ResultSet resultadoUsuario = con.createStatement().executeQuery(sql);
            ConnectionDB.desconectar(con);
            boolean usuarioEncontrado = resultadoUsuario.next();
            return usuarioEncontrado;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro de SQL ao validar o login do usuário. " + ex.getMessage());
            ConnectionDB.desconectar(con);
            return false;
        } catch (Exception ex) {
            System.out.println("Erro ao ao validar o login do usuário. " + ex.getMessage());
            return false;
        }
    }

}
