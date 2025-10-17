package entities;

public class Proprietario {

    private String nome;
    private String telefone;
    private String cpf;

    public Proprietario(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Proprietario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Proprietário: "
                + nome
                + " | Telefone: "
                + telefone
                + " | CPF: "
                + cpf;
    }
}
