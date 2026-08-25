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
        


        String nomeBiblioteca = "Biblioteca do Insper";
        int anoAtual = 2026;
        boolean aberta = true;

        System.out.println(nomeBiblioteca);
        System.out.println(String.format("Ano %s", anoAtual));
        System.out.println();

        Editora editora = new Editora("Editora do Insper",
                "Rua Quata", 2000);

        editora.addLivro(null);

        Autor autor = new Autor("Joao", "Sao Paulo", 30);

        editora.printLivros();

        Livro livro1 = new Livro("1984", 1949);
        livro1.setEditora(editora);
        editora.addLivro(livro1);

        livro1.getAutores().add(autor);
        autor.getLivros().add(livro1);

        editora.printLivros();

        System.out.println("");
        livro1.emprestar();

        Livro livro2 = new Livro("Duna",  1965);
        livro2.setEditora(editora);

        editora.addLivro(livro2);

        System.out.println(livro2.getNome());
        editora.printLivros();

        Livro livro3 = new Livro("Neuromancer", 1984);
        livro3.setEditora(editora);
        editora.addLivro(livro3);


        ArrayList<Livro> lista = new ArrayList<>();
        lista.add(livro1);
        lista.add(livro2);
        lista.add(livro3);

        System.out.println("===Livros===");
        for (Livro l : lista) {
            System.out.println(l.getNome());
        }

        HashSet<String> autores = new HashSet<>();
        for (Livro l : lista) {
            for (Autor a :l.getAutores()) {
                autores.add(a.getNome());
            }
        }



        HashMap<String, String> usuarios = new HashMap<>();
        usuarios.put("1", "Ana");
        usuarios.put("2", "Bruno");
        usuarios.put("3", "Carla");

        for (String chave : usuarios.keySet()) {
            String valor = usuarios.get(chave);
            System.out.println(valor);
        }

        if (aberta) {
            System.out.println("Biblioteca esta aberta");
        } else {
            System.out.println("Biblioteca esta fechada");
        }

        System.out.println(buscaLivro(lista, "Teste"));


        System.out.println(lista.size());
        // System.out.println(livro1.length());

    }





}