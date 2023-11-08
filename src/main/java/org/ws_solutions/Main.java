package org.ws_solutions;

import org.ws_solutions.db.ConnectionDB;
import java.sql.Connection;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("******* Running Easy Pharma Application *******");

        Connection con = ConnectionDB.conectar();
        ConnectionDB.desconectar(con);


        System.out.println("******* Closing Easy Pharma Application *******");

    }
}