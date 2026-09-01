package br.edu.insper.biblioteca;

import java.util.ArrayList;

public class Autor {

    private String nome;
    private String localNascimento;
    private int idade;

    private ArrayList<Livro> livros;

    public Autor(String nome, String localNascimento, int idade) {
        this.nome = nome;
        this.localNascimento = localNascimento;
        this.idade = idade;
        livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalNascimento() {
        return localNascimento;
    }

    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }


}
