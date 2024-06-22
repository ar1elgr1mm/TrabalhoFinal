import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu de Gerenciamento de Estoque:");
            System.out.println("1. Adicionar Novo Produto");
            System.out.println("2. Atualizar Quantidade e Valor Unitário de Produto Existente");
            System.out.println("3. Remover Quantidade de Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Buscar Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    if (!codigo.matches("\\d+")) {
                        System.out.println(COLOR_RED + "Código inválido. Deve conter apenas números." + COLOR_RESET);
                        break;
                    }
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    int quantidade = 0;
                    double valorUnitario = 0;
                    try {
                        System.out.print("Quantidade: ");
                        quantidade = scanner.nextInt();
                        System.out.print("Valor Unitário: ");
                        valorUnitario = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println(COLOR_RED + "Entrada inválida. Quantidade e Valor Unitário devem ser números." + COLOR_RESET);
                        scanner.nextLine();
                        break;
                    }
                    Produto produto = new Produto(codigo, nome, quantidade, valorUnitario);
                    estoque.adicionarProduto(produto);
                    break;
                case 2:
                    System.out.print("Código do produto a atualizar: ");
                    codigo = scanner.nextLine();
                    if (!codigo.matches("\\d+")) {
                        System.out.println(COLOR_RED + "Código inválido. Deve conter apenas números." + COLOR_RESET);
                        break;
                    }
                    try {
                        System.out.print("Nova Quantidade: ");
                        quantidade = scanner.nextInt();
                        System.out.print("Novo Valor Unitário: ");
                        valorUnitario = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println(COLOR_RED + "Entrada inválida. Quantidade e Valor Unitário devem ser números." + COLOR_RESET);
                        scanner.nextLine();
                        break;
                    }
                    estoque.atualizarProduto(codigo, quantidade, valorUnitario);
                    break;
                case 3:
                    System.out.print("Código do produto para remover quantidade: ");
                    codigo = scanner.nextLine();
                    if (!codigo.matches("\\d+")) {
                        System.out.println(COLOR_RED + "Código inválido. Deve conter apenas números." + COLOR_RESET);
                        break;
                    }
                    System.out.print("Quantidade a remover: ");
                    try {
                        quantidade = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println(COLOR_RED + "Entrada inválida. Quantidade deve ser um número." + COLOR_RESET);
                        scanner.nextLine();
                        break;
                    }
                    estoque.removerQuantidadeProduto(codigo, quantidade);
                    break;
                case 4:
                    estoque.listarProdutos();
                    break;
                case 5:
                    System.out.print("Código do produto a buscar: ");
                    codigo = scanner.nextLine();
                    if (!codigo.matches("\\d+")) {
                        System.out.println(COLOR_RED + "Código inválido. Deve conter apenas números." + COLOR_RESET);
                        break;
                    }
                    Produto p = estoque.buscarProduto(codigo);
                    if (p != null) {
                        estoque.exibirProduto(p);
                    } else {
                        System.out.println(COLOR_RED + "Produto não encontrado." + COLOR_RESET);
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println(COLOR_RED + "Opção inválida." + COLOR_RESET);
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
