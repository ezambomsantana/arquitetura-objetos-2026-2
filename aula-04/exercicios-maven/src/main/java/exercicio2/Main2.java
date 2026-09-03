package exercicio2;

public class Main2 {
    public static void main(String[] args) {
        Loja loja = new Loja("Tech Store");

        Categoria eletronicos = new Categoria(1, "Eletrônicos");
        Categoria livros = new Categoria(2, "Livros");
        Categoria roupas = new Categoria(3, "Roupas");

        Produto p1 = new Produto(101, "Notebook", 3500.00, eletronicos);
        Produto p2 = new Produto(102, "Mouse", 50.00, eletronicos);
        Produto p3 = new Produto(103, "Teclado", 150.00, eletronicos);
        Produto p4 = new Produto(104, "Monitor", 800.00, eletronicos);

        Produto p5 = new Produto(201, "Clean Code", 89.90, livros);
        Produto p6 = new Produto(202, "Design Patterns", 75.50, livros);
        Produto p7 = new Produto(203, "Java Effective", 95.00, livros);

        Produto p8 = new Produto(301, "Camiseta", 45.00, roupas);

        eletronicos.adicionarProduto(p1);
        eletronicos.adicionarProduto(p2);
        eletronicos.adicionarProduto(p3);
        eletronicos.adicionarProduto(p4);

        livros.adicionarProduto(p5);
        livros.adicionarProduto(p6);
        livros.adicionarProduto(p7);

        roupas.adicionarProduto(p8);

        loja.adicionarProduto(p1);
        loja.adicionarProduto(p2);
        loja.adicionarProduto(p3);
        loja.adicionarProduto(p4);
        loja.adicionarProduto(p5);
        loja.adicionarProduto(p6);
        loja.adicionarProduto(p7);
        loja.adicionarProduto(p8);

        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", "joao@email.com");
        Cliente cliente2 = new Cliente("Maria Santos", "987.654.321-11", "maria@email.com");
        Cliente cliente3 = new Cliente("Pedro Oliveira", "456.789.123-22", "pedro@email.com");

        loja.adicionarCliente(cliente1);
        loja.adicionarCliente(cliente2);
        loja.adicionarCliente(cliente3);

        Pedido pedido1 = new Pedido(1001, cliente1);
        pedido1.adicionarProduto(p1, 1);
        pedido1.adicionarProduto(p2, 2);
        pedido1.adicionarProduto(p5, 1);
        cliente1.adicionarPedido(pedido1);

        Pedido pedido2 = new Pedido(1002, cliente1);
        pedido2.adicionarProduto(p3, 1);
        pedido2.adicionarProduto(p6, 2);
        cliente1.adicionarPedido(pedido2);

        Pedido pedido3 = new Pedido(2001, cliente2);
        pedido3.adicionarProduto(p4, 1);
        pedido3.adicionarProduto(p7, 3);
        cliente2.adicionarPedido(pedido3);

        Pedido pedido4 = new Pedido(3001, cliente3);
        pedido4.adicionarProduto(p1, 1);
        pedido4.adicionarProduto(p8, 5);
        cliente3.adicionarPedido(pedido4);

        loja.listarProdutos();

        loja.listarProdutosPorCategoria(eletronicos);
        loja.listarProdutosPorCategoria(livros);
        loja.listarProdutosPorCategoria(roupas);

        cliente1.listarPedidos();
        cliente2.listarPedidos();
        cliente3.listarPedidos();

        System.out.println("\n========== Detalhes dos Pedidos ==========");
        System.out.println(pedido1);
        for (ItemPedido item : pedido1.getItens()) {
            System.out.println("  " + item);
        }

        System.out.println(pedido2);
        for (ItemPedido item : pedido2.getItens()) {
            System.out.println("  " + item);
        }

        System.out.println(pedido3);
        for (ItemPedido item : pedido3.getItens()) {
            System.out.println("  " + item);
        }

        System.out.println(pedido4);
        for (ItemPedido item : pedido4.getItens()) {
            System.out.println("  " + item);
        }

        System.out.println("\n========== Total Gasto por Cliente ==========");
        System.out.println(cliente1.getNome() + ": R$ " + String.format("%.2f", cliente1.calcularTotalGasto()));
        System.out.println(cliente2.getNome() + ": R$ " + String.format("%.2f", cliente2.calcularTotalGasto()));
        System.out.println(cliente3.getNome() + ": R$ " + String.format("%.2f", cliente3.calcularTotalGasto()));

        System.out.println("\n========== Produto Mais Caro por Categoria ==========");
        Produto maisCaro1 = eletronicos.buscarProdutoMaisCaro();
        if (maisCaro1 != null) {
            System.out.println("Eletrônicos: " + maisCaro1);
        }
        Produto maisCaro2 = livros.buscarProdutoMaisCaro();
        if (maisCaro2 != null) {
            System.out.println("Livros: " + maisCaro2);
        }
        Produto maisCaro3 = roupas.buscarProdutoMaisCaro();
        if (maisCaro3 != null) {
            System.out.println("Roupas: " + maisCaro3);
        }

        System.out.println("\n========== Preço Médio por Categoria ==========");
        System.out.println("Eletrônicos: R$ " + String.format("%.2f", eletronicos.calcularPrecoMedio()));
        System.out.println("Livros: R$ " + String.format("%.2f", livros.calcularPrecoMedio()));
        System.out.println("Roupas: R$ " + String.format("%.2f", roupas.calcularPrecoMedio()));
    }
}
