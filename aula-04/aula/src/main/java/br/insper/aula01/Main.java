package br.insper.aula01;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static boolean buscaLivro(ArrayList<Livro> livros, String nomeLivro) {
        for (Livro l : livros) {
            if (l.getNome().equals(nomeLivro)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        EditoraService editoraService = new EditoraService();
        LivroService livroService = new LivroService();

        editoraService.criar("1", "Editora do Insper",
                "Rua Quata", 1999);

        editoraService.criar("2", "Editora da USP",
                "Rua X", 1999);

        Editora editora = editoraService.buscar("1");
        Editora editora2 = editoraService.buscar("2");

        livroService.criar("123", "Livro 1", 2020, editora);
        livroService.criar("234", "Livro 2", 1999, editora);

        livroService.criar("543", "Livro 3", 1999, editora2);

        editoraService.imprimirLivros("1");
        editoraService.imprimirLivros("2");




    }





}