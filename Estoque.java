import java.util.LinkedHashMap;
import java.util.Map;

public class Estoque {
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String TITULO = String.format("%-15s %-16s %-12s %-20s %-20s", "Código", "Nome", "Quantidade", "Valor Unitário", "Valor Total");

    private Map<String, Produto> produtos;

    public Estoque() {
        this.produtos = new LinkedHashMap<>();
    }

    public void adicionarProduto(Produto produto) {
        if (produtos.containsKey(produto.getCodigo())) {
            System.out.println(COLOR_RED + "Produto com código " + produto.getCodigo() + " já existe." + COLOR_RESET);
            return;
        }

        for (Produto p : produtos.values()) {
            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
                System.out.println(COLOR_RED + "Produto com nome " + produto.getNome() + " já existe." + COLOR_RESET);
                return;
            }
        }

        produtos.put(produto.getCodigo(), produto);
    }

    public void atualizarProduto(String codigo, int quantidade, double valorUnitario) {
        Produto produto = produtos.get(codigo);
        if (produto != null) {
            produto.setQuantidade(quantidade);
            produto.setValorUnitario(valorUnitario);
        } else {
            System.out.println(COLOR_RED + "Produto não encontrado." + COLOR_RESET);
        }
    }

    public Produto buscarProduto(String codigo) {
        return produtos.get(codigo);
    }

    public void listarProdutos() {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(TITULO);
        System.out.println("------------------------------------------------------------------------------------");
        for (Produto produto : produtos.values()) {
            System.out.println(produto);
        }
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void exibirProduto(Produto produto) {
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(TITULO);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(produto);
        System.out.println("------------------------------------------------------------------------------------");
    }

    public void removerQuantidadeProduto(String codigo, int quantidade) {
        Produto produto = produtos.get(codigo);
        if (produto != null) {
            if (produto.getQuantidade() >= quantidade) {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
                System.out.println("Quantidade de " + quantidade + " removida do produto com código " + codigo + ".");
            } else {
                System.out.println(COLOR_RED + "Quantidade a remover excede a quantidade em estoque." + COLOR_RESET);
            }
        } else {
            System.out.println(COLOR_RED + "Produto com código " + codigo + " não encontrado." + COLOR_RESET);
        }
    }
}
