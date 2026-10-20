package br.insper.turismo.visitante;

import br.insper.turismo.atracao.Atracao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty(message = "Nome não pode ser vazio")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "CPF não pode ser nulo")
    @NotEmpty(message = "CPF não pode ser vazio")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Min(value = 0, message = "Idade tem que ser maior que 0")
    @Max(value = 150, message = "Idade tem que ser menor que 150")
    private int idade;

    @ManyToMany(mappedBy = "visitantes")
    private List<Atracao> atracaos = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Atracao> getAtracaos() {
        return atracaos;
    }

    public void setAtracaos(List<Atracao> atracaos) {
        this.atracaos = atracaos;
    }
}
