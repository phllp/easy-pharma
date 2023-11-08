package org.ws_solutions.model;

import java.util.Date;

public class Funcionario  extends Usuario {

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

    /**
     * Se a data da demissão for anterior à data atual então o funcionário está demitido
     * @return
     */
    public boolean isDemitido() {
        // TODO: 11/8/23 Implementar a lógica de comparação das datas
        return this.getDataAdmissao() != null;
    }
}
