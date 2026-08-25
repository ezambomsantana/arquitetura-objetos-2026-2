package br.insper.aula01;

import java.util.HashMap;

public class EditoraService {

    private HashMap<String, Editora> editoras = new HashMap<>();

    public void criar(String cnpj, String nome, String endereco, int anoFundacao) {
        Editora editora = new Editora(cnpj, nome, endereco, anoFundacao);
        editoras.put(cnpj, editora);
    }

    public Editora buscar(String cnpj) {
        return editoras.get(cnpj);
    }

    public boolean excluir(String cnpj) {
        Editora editora = buscar(cnpj);
        if (editora != null) {
            editoras.remove(cnpj);
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



}
