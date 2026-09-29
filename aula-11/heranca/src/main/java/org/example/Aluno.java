package org.example;

import java.util.ArrayList;

public class Aluno extends Pessoa implements Avaliar {

    private String ra;
    private String curso;
    private int anoIngresso;
    private int semestreIngresso;

    @Override
    public String getDocumento() {
        return ra;
    }

    public void apresentacao() {
        System.out.println(getNome());
        System.out.println(curso);
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public int getSemestreIngresso() {
        return semestreIngresso;
    }

    public void setSemestreIngresso(int semestreIngresso) {
        this.semestreIngresso = semestreIngresso;
    }

    @Override
    public void avaliar(Pessoa p) {

    }
}
