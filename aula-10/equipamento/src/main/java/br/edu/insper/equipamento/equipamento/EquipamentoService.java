package br.edu.insper.equipamento.equipamento;

import br.edu.insper.equipamento.common.CampoInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class EquipamentoService {

    private HashMap<String, Equipamento> equipamentos = new HashMap<>();

    public ArrayList<Equipamento> getEquipamentos() {
        ArrayList<Equipamento> resultado = new ArrayList<>();
        for (Equipamento equipamento : equipamentos.values()) {
            if (!equipamento.isDeleted()) {
                resultado.add(equipamento);
            }
        }
        return resultado;
    }

    public Equipamento addEquipamento(Equipamento equipamento) {

        if (equipamento.getCodigoPatrimonio() == null || equipamento.getCodigoPatrimonio().isEmpty()) {
            throw new CampoInvalidoException("Código patrimônio é obrigatório");
        }

        if (equipamento.getNome() == null || equipamento.getNome().isEmpty()) {
            throw new CampoInvalidoException("Nome é obrigatório");
        }

        if (equipamento.getCategoria() == null || equipamento.getCategoria().isEmpty()) {
            throw new CampoInvalidoException("Categoria é obrigatória");
        }

        if (equipamento.getValorDiaria() <= 0) {
            throw new CampoInvalidoException("Valor diária é obrigatório");
        }

        equipamentos.put(equipamento.getCodigoPatrimonio(), equipamento);
        return equipamento;

    }


    public Equipamento editEquipamento(String codigoPatrimonio, Equipamento equipamento) {
        Equipamento equipamentoSalvo = getEquipamento(codigoPatrimonio);

        if (equipamento.getNome() != null && !equipamento.getNome().isEmpty()) {
            equipamentoSalvo.setNome(equipamento.getNome());
        }

        if (equipamento.getCategoria() != null && !equipamento.getCategoria().isEmpty()) {
            equipamentoSalvo.setCategoria(equipamento.getCategoria());
        }

        if (equipamento.getValorDiaria() > 0) {
            equipamentoSalvo.setValorDiaria(equipamento.getValorDiaria());
        }

        equipamentos.put(codigoPatrimonio, equipamentoSalvo);
        return equipamentoSalvo;

    }

    public Equipamento getEquipamento(String codigoPatrimonio) {
        Equipamento equipamento = equipamentos.get(codigoPatrimonio);
        if (equipamento == null || equipamento.isDeleted()) {
            throw new EquipamentoNaoEncontradoException("Equipamento não encontrado");
        }
        return equipamento;
    }

    public void deleteEquipamento(String codigoPatrimonio) {
        Equipamento equipamento = getEquipamento(codigoPatrimonio);
        equipamento.setDeleted(true);
    }

    public Equipamento getPrimeiroDisponivel() {

        for (Equipamento equipamento : equipamentos.values()) {
            if (!equipamento.isDeleted() && equipamento.isDisponivel()) {
                return equipamento;
            }
        }

        throw new EquipamentoNaoEncontradoException("Nenhum equipamento disponível");

    }
}
