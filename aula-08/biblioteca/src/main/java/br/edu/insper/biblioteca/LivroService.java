package br.edu.insper.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class LivroService {

    @Autowired
    private EditoraService editoraService;
    public HashMap<String, Livro> livros = new HashMap<>();

    public Livro criar(Livro livro) {

        Editora editora = editoraService.buscar(livro.getEditora().getId());

        if (editora == null) {
            return null;
        }

        livro.setEditora(editora);
        editora.addLivro(livro);
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
