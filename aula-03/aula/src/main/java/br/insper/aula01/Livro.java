package br.insper.aula01;

import java.util.ArrayList;

public class Livro {

    String nome;
    String autor;
    int ano;
    boolean disponivel;

    public Livro() {
        nome = "Teste";
    }

    public Livro(String nome, String autor, int ano) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }





    public String emprestar() {
        if (this.disponivel) {
            this.disponivel = false;
            return "Livro emprestado com sucesso";
        } else {
            return "Livro já está emprestado";
        }
    }

}
