package Model;

public class Cliente {
    
    String nome;
    String cnpj;
    String endereco;
    String email;
    String numero;
    String cidade;
    String cep;
    String uf;
    String responsavel;
    String inscricaoEstadual;

    public Cliente(String nome, String cnpj, String endereco, String email, String numero, String cidade, String cep, 
            String uf, String responsavel, String inscricaoEstadual) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.responsavel = responsavel;
        this.inscricaoEstadual = inscricaoEstadual;
    }
   
    public Cliente(String nome, String cnpj, String numero, String cidade, String responsavel) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.numero = numero;
        this.cidade = cidade;
        this.responsavel = responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
}
