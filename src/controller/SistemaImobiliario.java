package controller;

import entities.Imovel;
import entities.Proprietario;
import java.util.ArrayList;
import java.util.List;

public class SistemaImobiliario {

    private List<Imovel> imoveis = new ArrayList<>();
    private List<Proprietario> proprietarios = new ArrayList<>();

    // Adicionando Proprietario e conferindo duplicidades de CPF
    public boolean adicionarProprietario(Proprietario proprietario) {
        if (proprietario == null || proprietario.getCpf() == null) {
            return false;
        }
        for (Proprietario existente : proprietarios) {
            if (existente != null && existente.getCpf() != null
                    && existente.getCpf().equals(proprietario.getCpf())) {
                return false; // Se o CPF já existir.
            }
        }
        proprietarios.add(proprietario);
        return true;
    }
    // Removendo Proprietario pelo CPF
    public boolean removerProprietario(String cpf) {
        if (cpf == null) return false;
        Proprietario p = buscarProprietarioPorCpf(cpf);
        if (p != null) {
            proprietarios.remove(p);
            return true;
        }
        return false;
    }
    // Adicionando Imovel e conferindo duplicidade de número
    public boolean adicionarImovel(Imovel imovel) {
        if (imovel == null) return false;
        if (buscarImovelPorNumero(imovel.getNumero()) != null) {
            return false; // Número já existe
        }
        imoveis.add(imovel);
        return true;
    }
    // Removendo Imovel pelo número
    public boolean removerImovel(int numero) {
        Imovel i = buscarImovelPorNumero(numero);
        if (i != null) {
            imoveis.remove(i);
            return true;
        }
        return false;
    }
    // Buscando Proprietario pelo CPF
    public Proprietario buscarProprietarioPorCpf(String cpf) {
        if (cpf == null) return null;
        for (Proprietario p : proprietarios) {
            if (p != null && p.getCpf() != null && p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }
    // Buscando Imovel pelo número
    public Imovel buscarImovelPorNumero(int numero) {
        for (Imovel i : imoveis) {
            if (i != null && i.getNumero() == numero) {
                return i;
            }
        }
        return null;
    }
    // Alugando Imovel aqui podemos conferir se já está alugado
    public boolean alugarImovel(Imovel imovel) {
        if (imovel == null) return false;
        if (!imovel.isAlugado()) {
            imovel.setAlugado(true);
            return true;
        }
        return false; // Já está alugado
    }
    // Desalugando Imovel aqui podemos conferir se está desalugado
    public boolean desalugarImovel(Imovel imovel) {
        if (imovel == null) return false;
        if (imovel.isAlugado()) {
            imovel.setAlugado(false);
            return true;
        }
        return false; // Já está desalugado
    }
    // Disponibilizando imóvel para aluguel pelo número
    public boolean disponibilizarImovel(int numero) {
        Imovel i = buscarImovelPorNumero(numero);
        if (i != null && i.isAlugado()) {
            i.setAlugado(false);
            return true;
        }
        // Verificando se já está disponível ou não existe, retorna false
        return false;
    }
    // Calculando valor total do aluguel de um imóvel por meses
    public double calcularAluguelTotal(Imovel imovel, int meses) {
        if (imovel == null || meses < 1) return 0.0;
        return imovel.getValorAluguel() * meses;
    }
    // Calculando valor total de todos os imóveis alugados em X meses
    public double calcularAluguelTotalTodos(int meses) {
        if (meses < 0) return 0.0;
        double total = 0.0;
        for (Imovel i : imoveis) {
            if (i != null && i.isAlugado()) {
                total += i.getValorAluguel() * meses;
            }
        }
        return total;
    }
    // Retornando cópia da lista de imoveis
    public List<Imovel> getImoveis() {
        return new ArrayList<>(imoveis);
    }
    // Retornando cópia da lista de proprietarios
    public List<Proprietario> getProprietarios() {
        return new ArrayList<>(proprietarios);
    }
    // Retornar Imoveis disponíveis
    public List<Imovel> getImoveisDisponiveis() {
        List<Imovel> disponiveis = new ArrayList<>();
        for (Imovel i : imoveis) {
            if (i != null && !i.isAlugado()) {
                disponiveis.add(i);
            }
        }
        return disponiveis;
    }
}
