package br.edu.insper.biblioteca.editora.service;

import br.edu.insper.biblioteca.editora.dto.EditoraLivrosDTO;
import br.edu.insper.biblioteca.editora.exception.EditoraNaoEncontradaException;
import br.edu.insper.biblioteca.editora.model.Editora;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

//Singleton
@Service
public class EditoraService {

    private HashMap<String, Editora> editoras = new HashMap<>();

    public Editora criar(Editora editora) {

        if (editora.getNome() == null || editora.getNome().isEmpty()) {
            throw new RuntimeException("Nome da editora não pode ser null ou vazio");
        }

        editora.setId(UUID.randomUUID().toString());
        editoras.put(editora.getId(), editora);
        return editora;
    }

    public Editora buscar(String id) {
        Editora editora = editoras.get(id);
        if (editora == null) {
            throw new EditoraNaoEncontradaException("Editora não encontrada");
        }
        return editora;
    }

    public void excluir(String id) {
        buscar(id);
        editoras.remove(id);
    }

    public ArrayList<Editora> listar(String nome) {
        if (nome != null) {

            ArrayList<Editora> response = new ArrayList<>();
            for (Editora editora : editoras.values()) {

                if (editora.getNome().startsWith(nome)) {
                    response.add(editora);
                }
            }
            return response;


            /*
            editoras
                    .values()
                    .stream()
                    .filter(e -> e.getNome().startsWith(nome))
                    .toList();

             */

        }
        return new ArrayList<>(editoras.values());
    }


    public ArrayList<EditoraLivrosDTO> getNumeroLivrosEditora() {

        ArrayList<EditoraLivrosDTO> editorasLivro = new ArrayList<>();

        for (Editora editora : editoras.values()) {
            EditoraLivrosDTO livros =
                    new EditoraLivrosDTO(editora.getNome(),editora.contaLivros());
            editorasLivro.add(livros);
        }
        return editorasLivro;

    }

}
