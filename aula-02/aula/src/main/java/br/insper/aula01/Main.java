package br.insper.aula01;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static boolean buscaLivro(ArrayList<Livro> livros, String nomeLivro) {
        for (Livro l : livros) {
            if (l.nome.equals(nomeLivro)) {
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

        Livro livro1 = new Livro("1984", "George Orwell", 1949);

        System.out.println("");
        livro1.emprestar();

        buscaLivro(null, null);
        Livro livro2 = new Livro();
        livro2.nome = "Duna";
        livro2.autor = "Frank Herbert";
        livro2.ano = 1965;

        Livro livro3 = new Livro("Neuromancer", "William Gibson", 1984);

        ArrayList<Livro> lista = new ArrayList<>();
        lista.add(livro1);
        lista.add(livro2);
        lista.add(livro3);

        System.out.println("===Livros===");
        for (Livro l : lista) {
            System.out.println(l.nome);
        }

        HashSet<String> autores = new HashSet<>();
        for (Livro l : lista) {
            autores.add(l.autor);
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