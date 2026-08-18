package br.insper.aula01;

import java.util.ArrayList;

public class Editora {

    private String nome;
    private String endereco;
    private int anoFundacao;

    private ArrayList<Livro> livros;

    public Editora(String nome, String endereco, int anoFundacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.anoFundacao = anoFundacao;
        this.livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }


    public void addLivro(Livro livro) {
        if (livro == null  || livro.getNome() == null) {
            return;
        }
        this.livros.add(livro);
    }

    public void printLivros() {
        System.out.println(livros);
    }

}
