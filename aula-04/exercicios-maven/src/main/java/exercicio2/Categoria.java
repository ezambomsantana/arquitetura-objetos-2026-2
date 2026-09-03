package exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private int codigo;
    private String nome;
    private List<Produto> produtos;

    public Categoria(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void listarProdutos() {
        System.out.println("\nProdutos da categoria " + nome + ":");
        for (Produto produto : produtos) {
            System.out.println("  " + produto);
        }
    }

    public double calcularPrecoMedio() {
        if (produtos.isEmpty()) return 0;
        double soma = 0;
        for (Produto produto : produtos) {
            soma += produto.getPreco();
        }
        return soma / produtos.size();
    }

    public Produto buscarProdutoMaisCaro() {
        if (produtos.isEmpty()) return null;
        Produto maisCaro = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getPreco() > maisCaro.getPreco()) {
                maisCaro = produto;
            }
        }
        return maisCaro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return nome;
    }
}
