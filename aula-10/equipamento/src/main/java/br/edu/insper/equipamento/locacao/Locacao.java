package br.edu.insper.equipamento.locacao;

import br.edu.insper.equipamento.cliente.Cliente;
import br.edu.insper.equipamento.equipamento.Equipamento;

import java.time.LocalDate;

public class Locacao {
    private String id;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    private Equipamento equipamento;
    private Cliente cliente;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
