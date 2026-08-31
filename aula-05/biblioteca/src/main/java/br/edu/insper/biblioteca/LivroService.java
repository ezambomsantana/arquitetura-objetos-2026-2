package br.edu.insper.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class LivroService {

    public HashMap<String, Livro> livros = new HashMap<>();

    public Livro criar(Livro livro) {
        //livro.setEditora(null);
        //editora.addLivro(livro);
        livros.put(livro.getIsbn(), livro);
        return livro;
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

    public ArrayList<Livro> listar(String nome) {

        if (nome != null) {

            ArrayList<Livro> response = new ArrayList<>();
            for (Livro livro : livros.values()) {

                if (livro.getNome().startsWith(nome)) {
                    response.add(livro);
                }
            }
            return response;
        }
        return new ArrayList<>(livros.values());
    }
}
