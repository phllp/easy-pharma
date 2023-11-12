package org.ws_solutions.model;

import org.postgresql.util.OSUtil;
import org.ws_solutions.db.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

public class Funcionario extends Usuario {

    private String id;
    private Cargo cargo;
    private Date dataAdmissao;
    private Date dataDemissao;
    private double salario;

    public Funcionario() {
    }

    // TODO: 11/8/23 Conferir se esses overrides estão coerentes
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean criar() {


        String uuidUsuario = "\'" + UUID.randomUUID().toString() + "\'";
        String usernameUsuario = "\'" + this.getUsername() + "\'";
        String passwordUsuario = "\'" + this.getPassword() + "\'";

        String insertUsuario = "INSERT INTO usuarios (id, username, password) " +
                "VALUES (" + uuidUsuario + ", " + usernameUsuario + ", " + passwordUsuario + ")";


        String uuidFuncionario = "\'" + UUID.randomUUID().toString() + "\'";
        String uuidCargo = "\'" + "fbe4c65b-4e2a-4979-bd61-cfcab936b886" + "\'";
        Double salarioFuncionario = this.getSalario();
        String dataAdmissaoFuncionario = "\'" + this.getDataAdmissao().toString() + "\'";

        //TODO Remover cargo default


        String insertFuncionario = "INSERT INTO funcionario " +
                "(id, usuarioid, cargoid, dataadmissao, datademissao, salario) " +
                "VALUES " +
                "(" + uuidFuncionario + ", " + uuidUsuario + ", " + uuidCargo + ", " + dataAdmissaoFuncionario + ", " + null + ", " + salarioFuncionario + ")";


        System.out.println(insertUsuario);
        System.out.println("=====================");
        System.out.println(insertFuncionario);


        Connection con = ConnectionDB.conectar();
        try {
            boolean resultadoUsuario = con.createStatement().execute(insertUsuario);
            boolean resultadoFuncionario = con.createStatement().execute(insertFuncionario);
            ConnectionDB.desconectar(con);
            return resultadoUsuario && resultadoFuncionario;
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao inserir os dados do usuário" + ex.getMessage());
            ConnectionDB.desconectar(con);
            return false;
        } catch (Exception ex) {
            System.out.println("Erro ao inserir dados do Funcionario. " + ex.getMessage());
            return false;
        }


    }

    /**
     * Se a data da demissão for anterior à data atual então o funcionário está demitido
     *
     * @return
     */
    public boolean isDemitido() {
        // TODO: 11/8/23 Implementar a lógica de comparação das datas
        return this.getDataAdmissao() != null;
    }
}
