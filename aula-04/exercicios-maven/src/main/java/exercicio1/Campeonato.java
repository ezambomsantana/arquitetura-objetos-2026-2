package exercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Campeonato {
    private String nome;
    private int ano;
    private List<Time> times;
    private List<Partida> partidas;

    public Campeonato(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
        this.times = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    public void adicionarTime(Time time) {
        this.times.add(time);
    }

    public void adicionarPartida(Partida partida) {
        this.partidas.add(partida);
        partida.setCampeonato(this);
    }

    public void listarTimes() {
        System.out.println("\nTimes do " + nome + ":");
        for (Time time : times) {
            System.out.println("  " + time);
        }
    }

    public void listarPartidas() {
        System.out.println("\nPartidas do " + nome + ":");
        for (Partida partida : partidas) {
            partida.exibirPlacar();
        }
    }

    public Time buscarTime(String nome) {
        for (Time time : times) {
            if (time.getNome().equalsIgnoreCase(nome)) {
                return time;
            }
        }
        return null;
    }

    public void exibirClassificacao() {
        Map<Time, Integer> pontos = new HashMap<>();

        for (Time time : times) {
            pontos.put(time, 0);
        }

        for (Partida partida : partidas) {
            int mandante = partida.getGolMandante();
            int visitante = partida.getGolVisitante();

            if (mandante > visitante) {
                pontos.put(partida.getTimeMandante(), pontos.get(partida.getTimeMandante()) + 3);
            } else if (visitante > mandante) {
                pontos.put(partida.getTimeVisitante(), pontos.get(partida.getTimeVisitante()) + 3);
            } else {
                pontos.put(partida.getTimeMandante(), pontos.get(partida.getTimeMandante()) + 1);
                pontos.put(partida.getTimeVisitante(), pontos.get(partida.getTimeVisitante()) + 1);
            }
        }

        System.out.println("\n========== Classificação " + nome + " " + ano + " ==========");

        List<Time> timesOrdenados = new ArrayList<>();
        for (Time time : times) {
            timesOrdenados.add(time);
        }

        for (int i = 0; i < timesOrdenados.size(); i++) {
            for (int j = i + 1; j < timesOrdenados.size(); j++) {
                Time t1 = timesOrdenados.get(i);
                Time t2 = timesOrdenados.get(j);
                if (pontos.get(t1) < pontos.get(t2)) {
                    Time temp = t1;
                    timesOrdenados.set(i, t2);
                    timesOrdenados.set(j, temp);
                }
            }
        }

        for (Time time : timesOrdenados) {
            System.out.println(time.getNome() + " - " + pontos.get(time) + " pontos");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Time> getTimes() {
        return times;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }
}
