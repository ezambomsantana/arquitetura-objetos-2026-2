package exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private String status;

    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = "Pendente";
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        ItemPedido item = new ItemPedido(produto, quantidade);
        this.itens.add(item);
    }

    public void removerProduto(Produto produto) {
        ItemPedido itemRemover = null;
        for (ItemPedido item : itens) {
            if (item.getProduto() == produto) {
                itemRemover = item;
                break;
            }
        }
        if (itemRemover != null) {
            itens.remove(itemRemover);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public int calcularQuantidadeItens() {
        int quantidade = 0;
        for (ItemPedido item : itens) {
            quantidade += item.getQuantidade();
        }
        return quantidade;
    }

    public ItemPedido buscarItemMaisCaro() {
        if (itens.isEmpty()) return null;
        ItemPedido maisCaro = itens.get(0);
        for (ItemPedido item : itens) {
            if (item.calcularSubtotal() > maisCaro.calcularSubtotal()) {
                maisCaro = item;
            }
        }
        return maisCaro;
    }

    public void alterarStatus(String status) {
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido #" + numero + " - " + status + " - Total: R$ " + String.format("%.2f", calcularTotal());
    }
}
