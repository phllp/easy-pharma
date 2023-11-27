package org.ws_solutions.controller;

import org.ws_solutions.model.Cargo;
import org.ws_solutions.model.Funcionario;

import java.util.Date;

public class ControllerFuncionario extends ControllerBase {


    public boolean criarFuncionario(String username, String password, String dataAdmissao, String salario) {
        Funcionario funcionario = new Funcionario();
        funcionario.setUsername(username);
        funcionario.setPassword(password);
        funcionario.setDataAdmissao(new Date());
        funcionario.setCargo(new Cargo());
        try {
            funcionario.setSalario(Double.parseDouble(salario));
        } catch (NumberFormatException ex) {
            System.out.println("O valor informado para o salário é inválido");
            return false;
        } catch (Exception ex) {
            System.out.println("Erro ao definir os dados do novo Funcionário. " + ex.getMessage());
        }

        funcionario.criar();

        return true;
    }

}
