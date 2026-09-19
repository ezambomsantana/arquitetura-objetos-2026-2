package br.edu.insper.equipamento.locacao;

import br.edu.insper.equipamento.cliente.Cliente;
import br.edu.insper.equipamento.cliente.ClienteService;
import br.edu.insper.equipamento.equipamento.Equipamento;
import br.edu.insper.equipamento.equipamento.EquipamentoService;
import br.edu.insper.equipamento.locacao.Locacao;
import br.edu.insper.equipamento.locacao.LocacaoNaoEncontradoException;
import br.edu.insper.equipamento.common.CampoInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class LocacaoService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EquipamentoService equipamentoService;

    private HashMap<String, Locacao> locacoes = new HashMap<>();

    public ArrayList<Locacao> getLocacoes() {
        ArrayList<Locacao> resultado = new ArrayList<>();
        for (Locacao locacao : locacoes.values()) {
            if (!locacao.isDeleted()) {
                resultado.add(locacao);
            }
        }
        return resultado;
    }

    public Locacao addLocacao(Locacao locacao) {

        if (locacao.getDataFim() == null) {
            throw new CampoInvalidoException("Data fim é obrigatória");
        }

        if (locacao.getDataInicio() == null) {
            throw new CampoInvalidoException("Data início é obrigatória");
        }

        if (locacao.getCliente() == null || locacao.getCliente().getCpf() == null) {
            throw new CampoInvalidoException("Cliente é obrigatório");
        }

        Cliente cliente = clienteService.getCliente(locacao.getCliente().getCpf());
        locacao.setCliente(cliente);

        Equipamento equipamento = equipamentoService.getPrimeiroDisponivel();
        equipamento.setDisponivel(false);
        locacao.setEquipamento(equipamento);

        locacao.setId(UUID.randomUUID().toString());

        locacoes.put(locacao.getId(), locacao);
        return locacao;

    }


    public Locacao editLocacao(String id, Locacao locacao) {
        Locacao locacaoSalvo = getLocacao(id);

        if (locacao.getDataFim() != null) {
            locacaoSalvo.setDataFim(locacao.getDataFim());
        }

        if (locacao.getDataInicio() != null) {
            locacaoSalvo.setDataInicio(locacao.getDataInicio());
        }

        locacoes.put(id, locacaoSalvo);
        return locacaoSalvo;

    }

    public Locacao getLocacao(String id) {
        Locacao locacao = locacoes.get(id);
        if (locacao == null || locacao.isDeleted()) {
            throw new LocacaoNaoEncontradoException("Locação não encontrada");
        }
        return locacao;
    }

    public void deleteLocacao(String id) {
        Locacao locacao = getLocacao(id);
        locacao.setDeleted(true);
    }
}
