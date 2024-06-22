public class Produto {
    private String codigo;
    private String nome;
    private int quantidade;
    private double valorUnitario;

    public Produto(String codigo, String nome, int quantidade, double valorUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return quantidade * valorUnitario;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-16s %-12d %-20s %-20s", codigo, nome, quantidade, String.format("R$ %,.2f", valorUnitario), String.format("R$ %,.2f", getValorTotal()));
    }
}