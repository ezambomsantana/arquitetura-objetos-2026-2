package exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String nome;
    private List<Produto> produtos;
    private List<Cliente> clientes;

    public Loja(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Produto buscarProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarProdutos() {
        System.out.println("\nProdutos da loja " + nome + ":");
        for (Produto produto : produtos) {
            System.out.println("  " + produto);
        }
    }

    public void listarProdutosPorCategoria(Categoria categoria) {
        System.out.println("\nProdutos da categoria " + categoria.getNome() + ":");
        for (Produto produto : produtos) {
            if (produto.getCategoria() == categoria) {
                System.out.println("  " + produto);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public String toString() {
        return nome;
    }
}
