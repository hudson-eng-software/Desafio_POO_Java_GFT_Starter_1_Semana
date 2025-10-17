package entities;

public abstract class Imovel {

    protected String endereco;
    protected int numero;
    protected double valorAluguel;
    protected boolean alugado;
    protected Proprietario proprietario;

    public Imovel(int numero, double valorAluguel, Proprietario proprietario) {
        this.numero = numero;
        this.valorAluguel = valorAluguel;
        this.proprietario = proprietario;
        this.alugado = false;
        this.endereco = "O endereço não foi informado";
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public int getNumero() {
        return numero;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    @Override
    public String toString() {
        return "Imóvel nº "
                + numero
                + " | Valor: R$ "
                + valorAluguel
                +
                " | "
                + (alugado ? "Alugado" : "Disponível") +
                " | Proprietário: "
                + proprietario.getNome();
    }
}
