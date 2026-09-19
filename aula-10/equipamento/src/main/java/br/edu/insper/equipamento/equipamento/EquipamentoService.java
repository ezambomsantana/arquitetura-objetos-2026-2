package br.edu.insper.equipamento.equipamento;

import br.edu.insper.equipamento.equipamento.Equipamento;
import br.edu.insper.equipamento.equipamento.EquipamentoNaoEncontradoException;
import br.edu.insper.equipamento.common.CampoInvalidoException;

import java.util.ArrayList;
import java.util.HashMap;

public class EquipamentoService {

    private HashMap<String, Equipamento> equipamentos = new HashMap<>();

    public ArrayList<Equipamento> getEquipamentos() {
        return new ArrayList<>(equipamentos.values());
    }

    public Equipamento addEquipamento(Equipamento equipamento) {

        if (equipamento.getCodigoPatrimonio() != null || equipamento.getCodigoPatrimonio().isEmpty()) {
            throw new CampoInvalidoException("CPF é obrigatório");
        }

        if (equipamento.getNome() != null || equipamento.getNome().isEmpty()) {
            throw new CampoInvalidoException("Nome é obrigatório");
        }

        if (equipamento.getValorDiaria() != 0) {
            throw new CampoInvalidoException("Valor diaria é obrigatório");
        }

        equipamentos.put(equipamento.getCodigoPatrimonio(), equipamento);
        return equipamento;

    }


    public Equipamento editEquipamento(String cpf, Equipamento equipamento) {
        Equipamento equipamentoSalvo = getEquipamento(cpf);

        if (equipamento.getNome() != null || equipamento.getNome().isEmpty()) {
            equipamentoSalvo.setNome(equipamento.getNome());
        }

        if (equipamento.getValorDiaria() != 0) {
            equipamentoSalvo.setValorDiaria(equipamento.getValorDiaria());
        }

        equipamentos.put(cpf, equipamentoSalvo);
        return equipamento;

    }

    public Equipamento getEquipamento(String cpf) {
        Equipamento equipamento = equipamentos.get(cpf);
        if (equipamento == null) {
            throw new EquipamentoNaoEncontradoException("Equipamento não encontrado");
        }
        return equipamento;
    }

    public void deleteEquipamento(String cpf) {
        getEquipamento(cpf); //apenas verifica se o equipamento existe
        equipamentos.remove(cpf);
    }
}
