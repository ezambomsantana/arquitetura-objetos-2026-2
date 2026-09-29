package org.example;

public class Sala {


    private String nomeSala;
    private boolean disponivel = true;
    private String cpf;

    public void reservar(Pessoa p) {
        if (disponivel) {
            disponivel = false;
            cpf = p.getDocumento();

        }
    }

    public void finalizarReserva() {
        disponivel = true;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void imprimirSala() {
        System.out.println(nomeSala);
        System.out.println(disponivel);
        System.out.println(cpf);
    }
}
