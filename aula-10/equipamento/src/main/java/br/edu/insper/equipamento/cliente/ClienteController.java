package br.edu.insper.equipamento.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ArrayList<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping("/clientes")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        return clienteService.addCliente(cliente);
    }

    @PutMapping("/clientes/{id}")
    public Cliente editCliente(@PathVariable String id, @RequestBody Cliente cliente) {
        return clienteService.editCliente(id, cliente);
    }

    @GetMapping("/clientes/{id}")
    public Cliente getCliente(@PathVariable String id) {
        return clienteService.getCliente(id);
    }

    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable String id) {
        clienteService.deleteCliente(id);
    }

}
