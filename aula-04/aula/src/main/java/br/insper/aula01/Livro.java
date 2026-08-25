package br.insper.aula01;

import java.util.ArrayList;

public class Livro {

    private String isbn;
    private String nome;
    private int ano;
    private boolean disponivel;

    private Editora editora;
    private ArrayList<Autor> autores;

    public Livro() {
        nome = "Teste";
    }

    public Livro(String isbn, String nome, int ano) {
        this.isbn = isbn;
        this.nome = nome;
        this.ano = ano;
        this.disponivel = true;
        this.autores = new ArrayList<>();
    }

    public String emprestar() {
        if (this.disponivel) {
            this.disponivel = false;
            return "Livro emprestado com sucesso";
        } else {
            return "Livro já está emprestado";
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return this.nome.toUpperCase();
    }

    public void setNome(String nome) {
        if (nome.length() < 3) {
            return;
        }
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public String toString() {
        return nome + " " + ano + "  " + editora.getNome();
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }



}
