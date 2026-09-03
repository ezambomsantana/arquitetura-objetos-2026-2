package exercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Partida {
    private LocalDate data;
    private Time timeMandante;
    private Time timeVisitante;
    private int golMandante;
    private int golVisitante;
    private List<Cartao> cartoes;
    private Campeonato campeonato;

    public Partida(LocalDate data) {
        this.data = data;
        this.golMandante = 0;
        this.golVisitante = 0;
        this.cartoes = new ArrayList<>();
    }

    public void registrarTimes(Time timeMandante, Time timeVisitante) {
        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
    }

    public void registrarGol(int golMandante, int golVisitante) {
        this.golMandante = golMandante;
        this.golVisitante = golVisitante;
    }

    public void registrarCartao(Cartao cartao) {
        this.cartoes.add(cartao);
        cartao.setPartida(this);
    }

    public Time buscarVencedor() {
        if (golMandante > golVisitante) return timeMandante;
        if (golVisitante > golMandante) return timeVisitante;
        return null;
    }

    public void exibirPlacar() {
        System.out.println("\n" + data + " - " + timeMandante.getNome() + " " + golMandante + " x " + golVisitante + " " + timeVisitante.getNome());
        if (!cartoes.isEmpty()) {
            System.out.println("Cartões:");
            for (Cartao cartao : cartoes) {
                System.out.println("  " + cartao);
            }
        }
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Time getTimeMandante() {
        return timeMandante;
    }

    public void setTimeMandante(Time timeMandante) {
        this.timeMandante = timeMandante;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(Time timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public int getGolMandante() {
        return golMandante;
    }

    public void setGolMandante(int golMandante) {
        this.golMandante = golMandante;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
}
