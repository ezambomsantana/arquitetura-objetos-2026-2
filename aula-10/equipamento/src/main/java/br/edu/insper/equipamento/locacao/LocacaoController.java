package br.edu.insper.equipamento.locacao;

import br.edu.insper.equipamento.locacao.Locacao;
import br.edu.insper.equipamento.locacao.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LocacaoController {


    @Autowired
    private LocacaoService locacaoService;

    @GetMapping("/locacoes")
    public ArrayList<Locacao> getLocacoes() {
        return locacaoService.getLocacoes();
    }

    @PostMapping("/locacoes")
    public Locacao addLocacao(@RequestBody Locacao locacao) {
        return locacaoService.addLocacao(locacao);
    }

    @PutMapping("/locacoes/{id}")
    public Locacao editLocacao(@PathVariable String id, @RequestBody Locacao locacao) {
        return locacaoService.editLocacao(id, locacao);
    }

    @GetMapping("/locacoes/{id}")
    public Locacao getLocacao(@PathVariable String id) {
        return locacaoService.getLocacao(id);
    }

    @DeleteMapping("/locacoes/{id}")
    public void deleteLocacao(@PathVariable String id) {
        locacaoService.deleteLocacao(id);
    }

}
