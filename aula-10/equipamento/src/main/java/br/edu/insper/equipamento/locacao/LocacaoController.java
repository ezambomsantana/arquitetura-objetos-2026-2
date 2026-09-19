package br.edu.insper.equipamento.locacao;

import br.edu.insper.equipamento.locacao.Locacao;
import br.edu.insper.equipamento.locacao.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class LocacaoController {


    @Autowired
    private LocacaoService locacaoService;

    @GetMapping("/locacaos")
    public ArrayList<Locacao> getLocacoes() {
        return locacaoService.getLocacoes();
    }

    @PostMapping("/locacaos")
    public Locacao addLocacao(@RequestBody Locacao locacao) {
        return locacaoService.addLocacao(locacao);
    }

    @PutMapping("/locacaos/{id}")
    public Locacao editLocacao(@PathVariable String id, @RequestBody Locacao locacao) {
        return locacaoService.editLocacao(id, locacao);
    }

    @GetMapping("/locacaos/{id}")
    public Locacao getLocacao(@PathVariable String id) {
        return locacaoService.getLocacao(id);
    }

    @DeleteMapping("/clietes/{id}")
    public void deleteLocacao(@PathVariable String id) {
        locacaoService.deleteLocacao(id);
    }

}
