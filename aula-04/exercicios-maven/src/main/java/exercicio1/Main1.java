package exercicio1;

import java.time.LocalDate;

public class Main1 {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato("Brasileirão", 2024);

        Time flamengo = new Time("Flamengo", "Rio de Janeiro");
        Time palmeiras = new Time("Palmeiras", "São Paulo");
        Time santos = new Time("Santos", "São Paulo");
        Time vasco = new Time("Vasco", "Rio de Janeiro");

        campeonato.adicionarTime(flamengo);
        campeonato.adicionarTime(palmeiras);
        campeonato.adicionarTime(santos);
        campeonato.adicionarTime(vasco);

        Jogador j1 = new Jogador("Gabigol", 9, "Atacante", 27);
        Jogador j2 = new Jogador("Arrascaeta", 14, "Meia", 28);
        Jogador j3 = new Jogador("Diego Alves", 1, "Goleiro", 35);
        flamengo.adicionarJogador(j1);
        flamengo.adicionarJogador(j2);
        flamengo.adicionarJogador(j3);

        Jogador j4 = new Jogador("Neymar", 10, "Atacante", 31);
        Jogador j5 = new Jogador("Danilo", 13, "Lateral", 30);
        Jogador j6 = new Jogador("Weverton", 1, "Goleiro", 32);
        palmeiras.adicionarJogador(j4);
        palmeiras.adicionarJogador(j5);
        palmeiras.adicionarJogador(j6);

        Jogador j7 = new Jogador("Soteldo", 8, "Atacante", 23);
        Jogador j8 = new Jogador("Braga", 6, "Meia", 26);
        Jogador j9 = new Jogador("João Paulo", 1, "Goleiro", 33);
        santos.adicionarJogador(j7);
        santos.adicionarJogador(j8);
        santos.adicionarJogador(j9);

        Jogador j10 = new Jogador("Vegetti", 99, "Atacante", 32);
        Jogador j11 = new Jogador("Medina", 5, "Volante", 25);
        Jogador j12 = new Jogador("Léo Jardim", 1, "Goleiro", 31);
        vasco.adicionarJogador(j10);
        vasco.adicionarJogador(j11);
        vasco.adicionarJogador(j12);

        Partida p1 = new Partida(LocalDate.of(2024, 5, 10));
        p1.registrarTimes(flamengo, palmeiras);
        p1.registrarGol(2, 1);
        p1.registrarCartao(new Cartao(j5, 45, "AMARELO"));
        campeonato.adicionarPartida(p1);

        Partida p2 = new Partida(LocalDate.of(2024, 5, 12));
        p2.registrarTimes(santos, vasco);
        p2.registrarGol(1, 1);
        p2.registrarCartao(new Cartao(j10, 60, "AMARELO"));
        campeonato.adicionarPartida(p2);

        Partida p3 = new Partida(LocalDate.of(2024, 5, 15));
        p3.registrarTimes(flamengo, santos);
        p3.registrarGol(3, 0);
        p3.registrarCartao(new Cartao(j7, 30, "VERMELHO"));
        campeonato.adicionarPartida(p3);

        Partida p4 = new Partida(LocalDate.of(2024, 5, 18));
        p4.registrarTimes(palmeiras, vasco);
        p4.registrarGol(2, 0);
        campeonato.adicionarPartida(p4);

        Partida p5 = new Partida(LocalDate.of(2024, 5, 22));
        p5.registrarTimes(flamengo, vasco);
        p5.registrarGol(4, 1);
        p5.registrarCartao(new Cartao(j10, 70, "AMARELO"));
        campeonato.adicionarPartida(p5);

        Partida p6 = new Partida(LocalDate.of(2024, 5, 25));
        p6.registrarTimes(palmeiras, santos);
        p6.registrarGol(1, 2);
        campeonato.adicionarPartida(p6);

        campeonato.listarTimes();
        flamengo.listarJogadores();
        palmeiras.listarJogadores();
        santos.listarJogadores();
        vasco.listarJogadores();

        campeonato.listarPartidas();

        campeonato.exibirClassificacao();

    }
}
