package Model;

public class Produto {
    
    String codigo;
    String descricao;
    double preco;
    double PrecoTotal;
    int ipi;
    int quantidade;
    
    public Produto(int quantidade, String codigo, String descricao, double preco, int ipi) {
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.ipi = ipi;
    }
    
    public Produto(String codigo, String descricao, double preco, int ipi) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.ipi = ipi;
    }

    public Produto(String codigo, String descricao, double preco, double PrecoTotal, int ipi, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.PrecoTotal = PrecoTotal;
        this.ipi = ipi;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoTotal() {
        return PrecoTotal;
    }

    public void setPrecoTotal(double PrecoTotal) {
        this.PrecoTotal = PrecoTotal;
    }

    public int getIpi() {
        return ipi;
    }

    public void setIpi(int ipi) {
        this.ipi = ipi;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
