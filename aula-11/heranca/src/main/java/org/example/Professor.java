package org.example;

import java.util.ArrayList;

public class Professor extends Pessoa implements Avaliar {

    private String departamento;
    private Double salario;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void apresentacao() {
        System.out.println(getNome());
        System.out.println(departamento);
    }


    @Override
    public void avaliar(Pessoa p) {

    }
}
