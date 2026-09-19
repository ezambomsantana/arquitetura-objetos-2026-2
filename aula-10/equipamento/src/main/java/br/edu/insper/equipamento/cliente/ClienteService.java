package br.edu.insper.equipamento.cliente;

import br.edu.insper.equipamento.common.CampoInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ClienteService {

    private HashMap<String, Cliente> clientes = new HashMap<>();

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes.values()) {
            if (!cliente.isDeleted()) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    public Cliente addCliente(Cliente cliente) {

        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new CampoInvalidoException("CPF é obrigatório");
        }

        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new CampoInvalidoException("Nome é obrigatório");
        }

        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new CampoInvalidoException("E-mail é obrigatório");
        }

        if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new CampoInvalidoException("Telefone é obrigatório");
        }

        clientes.put(cliente.getCpf(), cliente);
        return cliente;

    }


    public Cliente editCliente(String cpf, Cliente cliente) {
        Cliente clienteSalvo = getCliente(cpf);

        if (cliente.getNome() != null && !cliente.getNome().isEmpty()) {
            clienteSalvo.setNome(cliente.getNome());
        }

        if (cliente.getEmail() != null && !cliente.getEmail().isEmpty()) {
            clienteSalvo.setEmail(cliente.getEmail());
        }

        if (cliente.getTelefone() != null && !cliente.getTelefone().isEmpty()) {
            clienteSalvo.setTelefone(cliente.getTelefone());
        }

        clientes.put(cpf, clienteSalvo);
        return clienteSalvo;

    }

    public Cliente getCliente(String cpf) {
        Cliente cliente = clientes.get(cpf);
        if (cliente == null || cliente.isDeleted()) {
            throw new ClienteNaoEncontradoException("Cliente não encontrado");
        }
        return cliente;
    }

    public void deleteCliente(String cpf) {
        Cliente cliente = getCliente(cpf);
        cliente.setDeleted(true);
    }
}
