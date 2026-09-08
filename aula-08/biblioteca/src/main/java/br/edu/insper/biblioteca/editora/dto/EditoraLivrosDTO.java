package br.edu.insper.biblioteca.editora.dto;

public class EditoraLivrosDTO {

    private String nome;
    private int numeroLivros;

    public EditoraLivrosDTO(String nome, int numeroLivros) {
        this.nome = nome;
        this.numeroLivros = numeroLivros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroLivros() {
        return numeroLivros;
    }

    public void setNumeroLivros(int numeroLivros) {
        this.numeroLivros = numeroLivros;
    }
}
