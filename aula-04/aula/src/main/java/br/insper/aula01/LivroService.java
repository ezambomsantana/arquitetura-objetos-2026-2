package br.insper.aula01;

import java.util.HashMap;

public class LivroService {

    public HashMap<String, Livro> livros = new HashMap<>();

    public void criar(String isbn, String nome, int ano, Editora editora) {
        Livro livro = new Livro(isbn, nome, ano);
        livro.setEditora(editora);
        editora.addLivro(livro);
        livros.put(isbn, livro);
    }

    public Livro buscar(String isbn) {
        return livros.get(isbn);
    }

    public boolean excluir(String isbn) {
        Livro livro = buscar(isbn);
        if (livro != null) {
            livros.remove(isbn);
            return true;
        }
        return false;
    }

}
