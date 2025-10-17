package entities;

public class Casa extends Imovel {

    public Casa(int numero, double valorAluguel, Proprietario proprietario) {
        super(numero, valorAluguel, proprietario);
    }

    @Override
    public boolean isAlugado() {
        System.out.println("A casa "
                + numero
                + (alugado ? " está alugada." : " está disponível."));
        return alugado;
    }
}
