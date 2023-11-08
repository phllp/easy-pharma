package org.ws_solutions;

import org.ws_solutions.db.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.logging.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("******* Running Easy Pharma Application *******");

        Connection con = ConnectionDB.conectar();

        String query =  "SELECT * FROM usuarios";
        try {
            ResultSet resultado = con.createStatement().executeQuery(query);
            while (resultado.next()) {
                // Recupere os valores das colunas do resultado
                String id = resultado.getString("id");
                String nome = resultado.getString("username");
                // Faça algo com os valores obtidos
                System.out.println("ID: " + id + ", Nome: " + nome);
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao buscar os dados" + ex.getMessage());
        }


        ConnectionDB.desconectar(con);


        System.out.println("******* Closing Easy Pharma Application *******");

    }
}