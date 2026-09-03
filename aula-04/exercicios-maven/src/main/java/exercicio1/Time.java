package exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private String cidade;
    private List<Jogador> jogadores;

    public Time(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogadores = new ArrayList<>();
    }

    public void adicionarJogador(Jogador jogador) {
        this.jogadores.add(jogador);
        jogador.setTime(this);
    }

    public void removerJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
    }

    public void listarJogadores() {
        System.out.println("\nJogadores do " + nome + ":");
        for (Jogador jogador : jogadores) {
            System.out.println("  " + jogador);
        }
    }

    public double mediaIdadeJogadores() {
        if (jogadores.isEmpty()) return 0;
        int somaIdades = 0;
        for (Jogador jogador : jogadores) {
            somaIdades += jogador.getIdade();
        }
        return (double) somaIdades / jogadores.size();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    @Override
    public String toString() {
        return nome + " (" + cidade + ")";
    }
}
