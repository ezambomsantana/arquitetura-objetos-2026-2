package exercicio1;

public class Jogador {
    private String nome;
    private int numero;
    private String posicao;
    private Time time;
    private int idade;

    public Jogador(String nome, int numero, String posicao, int idade) {
        this.nome = nome;
        this.numero = numero;
        this.posicao = posicao;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return numero + " - " + nome + " (" + posicao + ") - " + idade + " anos";
    }
}
