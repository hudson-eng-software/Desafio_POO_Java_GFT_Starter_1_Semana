package entities;

public class Apartamento extends Imovel {

    public Apartamento(int numero, double valorAluguel, Proprietario proprietario) {
        super(numero, valorAluguel, proprietario);
    }

    @Override
    public boolean isAlugado() {
        System.out.println("O apartamento "
                + numero
                + (alugado ? " está alugado." : " está disponível."));
        return alugado;
    }
}
