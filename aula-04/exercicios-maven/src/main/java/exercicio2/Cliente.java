package exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private List<Pedido> pedidos;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void listarPedidos() {
        System.out.println("\nPedidos do cliente " + nome + ":");
        for (Pedido pedido : pedidos) {
            System.out.println("  " + pedido);
        }
    }

    public double calcularTotalGasto() {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularTotal();
        }
        return total;
    }

    public Pedido buscarPedidoMaisCaro() {
        if (pedidos.isEmpty()) return null;
        Pedido maisCaro = pedidos.get(0);
        for (Pedido pedido : pedidos) {
            if (pedido.calcularTotal() > maisCaro.calcularTotal()) {
                maisCaro = pedido;
            }
        }
        return maisCaro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return nome + " (" + cpf + ")";
    }
}
