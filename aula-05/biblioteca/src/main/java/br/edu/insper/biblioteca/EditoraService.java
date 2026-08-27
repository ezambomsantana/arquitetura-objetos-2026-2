package br.edu.insper.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class EditoraService {

    private HashMap<String, Editora> editoras = new HashMap<>();

    public Editora criar(Editora editora) {
        editora.setId(UUID.randomUUID().toString());
        editoras.put(editora.getId(), editora);
        return editora;
    }

    public Editora buscar(String id) {
        return editoras.get(id);
    }

    public boolean excluir(String id) {
        Editora editora = buscar(id);
        if (editora != null) {
            editoras.remove(id);
            return true;
        }
        return false;
    }

    public void imprimirLivros(String cnpj) {
        Editora editora = buscar(cnpj);
        System.out.println("#### Lista de Livros ####");
        editora.imprimirLivros();
    }

    public void contaLivros(String cnpj) {
        Editora editora = buscar(cnpj);
        System.out.println(editora.contaLivros());
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
}
