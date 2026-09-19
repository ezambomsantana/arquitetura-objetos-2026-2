package br.edu.insper.equipamento.equipamento;

import br.edu.insper.equipamento.equipamento.Equipamento;
import br.edu.insper.equipamento.equipamento.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("/equipamentos")
    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentoService.getEquipamentos();
    }

    @PostMapping("/equipamentos")
    public Equipamento addEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.addEquipamento(equipamento);
    }

    @PutMapping("/equipamentos/{id}")
    public Equipamento editEquipamento(@PathVariable String id, @RequestBody Equipamento equipamento) {
        return equipamentoService.editEquipamento(id, equipamento);
    }

    @GetMapping("/equipamentos/{id}")
    public Equipamento getEquipamento(@PathVariable String id) {
        return equipamentoService.getEquipamento(id);
    }

    @DeleteMapping("/clietes/{id}")
    public void deleteEquipamento(@PathVariable String id) {
        equipamentoService.deleteEquipamento(id);
    }

}
