package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        List<Avaliar> avaliadores = new ArrayList<>();
        avaliadores.add(new Professor());
        avaliadores.add(new Aluno());

        for (Avaliar a : avaliadores) {
            a.avaliar();
        }

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Professor());
        pessoas.add(new Aluno());
        pessoas.add(new Coordenador());


        for (Pessoa p : pessoas) {
            p.apresentacao();
        }

        Sala sala = new Sala();
        sala.setNomeSala("311");

        sala.reservar(p);
        sala.imprimirSala();



    }



}