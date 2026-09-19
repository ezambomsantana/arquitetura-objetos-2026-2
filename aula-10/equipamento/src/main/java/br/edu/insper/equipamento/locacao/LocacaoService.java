package br.edu.insper.equipamento.locacao;

import br.edu.insper.equipamento.cliente.Cliente;
import br.edu.insper.equipamento.cliente.ClienteService;
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

    public ArrayList<Locacao> getLocacaos() {
        return new ArrayList<>(locacoes.values());
    }

    public Locacao addLocacao(Locacao locacao) {

        if (locacao.getDataFim() != null) {
            throw new CampoInvalidoException("Data fim é obrigatório");
        }

        if (locacao.getDataInicio() != null) {
            throw new CampoInvalidoException("Nome é obrigatório");
        }

        locacao.setId(UUID.randomUUID().toString());

        locacoes.put(locacao.getId(), locacao);
        return locacao;

    }


    public Locacao editLocacao(String id, Locacao locacao) {
        Locacao locacaoSalvo = getLocacao(id);

        if (locacao.getDataFim() != null) {
            locacaoSalvo.setDataFim(locacao.getDataFim());
        }

        locacoes.put(id, locacaoSalvo);
        return locacao;

    }

    public Locacao getLocacao(String id) {
        Locacao locacao = locacoes.get(id);
        if (locacao == null) {
            throw new LocacaoNaoEncontradoException("Locacao não encontrado");
        }
        return locacao;
    }

    public void deleteLocacao(String id) {
        getLocacao(id); //apenas verifica se o locacao existe
        locacoes.remove(id);
    }
}
