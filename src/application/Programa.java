package application;

import controller.SistemaImobiliario;
import entities.Apartamento;
import entities.Casa;
import entities.Imovel;
import entities.Proprietario;
import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class Programa {

    public static void main(String[] args) {

        SistemaImobiliario sistema = new SistemaImobiliario();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n==== SISTEMA IMOBILIARIO ====");
            System.out.println("1. Adicionar Proprietário");
            System.out.println("2. Remover Proprietário");
            System.out.println("3. Adicionar Imóvel");
            System.out.println("4. Remover Imóvel");
            System.out.println("5. Alugar Imóvel");
            System.out.println("6. Desalugar Imóvel");
            System.out.println("7. Listar Imóveis Disponíveis");
            System.out.println("8. Buscar Proprietário por CPF");
            System.out.println("9. Calcular Aluguel Total");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: // Adicionando o Proprietário
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    Proprietario p = new Proprietario(nome, telefone, cpf);
                    if (sistema.adicionarProprietario(p)) {
                        System.out.println("O Proprietário foi adicionado com sucesso!");
                    } else {
                        System.out.println("O CPF já existe.");
                    }
                    break;

                case 2: // Removendo o Proprietário
                    System.out.print("Insira o CPF do Proprietário que deseja  remover: ");
                    String cpfRemover = scanner.nextLine();
                    if (sistema.removerProprietario(cpfRemover)) {
                        System.out.println("O Proprietário foi removido com sucesso!");
                    } else {
                        System.out.println("O Proprietário não pode ser encontrado.");
                    }
                    break;

                case 3: // Adicionando um Imóvel
                    System.out.print("Insira o número do imóvel: ");
                    int numero = scanner.nextInt();

                    System.out.print("Insira o valor do aluguel: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Insira o CPF do Proprietário: ");
                    String cpfProp = scanner.nextLine();
                    Proprietario proprietario = sistema.buscarProprietarioPorCpf(cpfProp);

                    if (proprietario != null) {
                        System.out.print("Escolha o tipo de imóvel (1 - Casa / 2 - Apartamento): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        Imovel imovel = null;

                        if (tipo == 1) {
                            imovel = new Casa(numero, valor, proprietario);
                        } else if (tipo == 2) {
                            imovel = new Apartamento(numero, valor, proprietario);
                        } else {
                            System.out.println("Tipo inserido está inválido!");
                            break;
                        }
                        if (sistema.adicionarImovel(imovel)) {
                            System.out.println("O Imóvel foi adicionado com sucesso!");
                        } else {
                            System.out.println("Número do imóvel já existe.");
                        }

                    } else {
                        System.out.println("O Proprietário não pode ser encontrado.");
                    }
                    break;


                case 4: // Removendo um Imóvel
                    System.out.print("Insira o número do imóvel que deseja remover: ");
                    int numRemover = scanner.nextInt();
                    scanner.nextLine(); // Para consumir pressione enter
                    if (sistema.removerImovel(numRemover)) {
                        System.out.println("O Imóvel foi removido com sucesso!");
                    } else {
                        System.out.println("O Imóvel não pode ser encontrado.");
                    }
                    break;

                case 5: // Alugando um Imóvel
                    System.out.print("Insira o número do imóvel que deseja alugar: ");
                    int numAlugar = scanner.nextInt();
                    scanner.nextLine();
                    Imovel imovelAlugar = sistema.buscarImovelPorNumero(numAlugar);
                    if (imovelAlugar != null) {
                        if (sistema.alugarImovel(imovelAlugar)) {
                            System.out.println("Imóvel alugado com sucesso!");
                        } else {
                            System.out.println("Imóvel já está alugado.");
                        }
                    } else {
                        System.out.println("Imóvel não encontrado.");
                    }
                    break;

                case 6: // Desalugando um  Imóvel
                    System.out.print("Insira o número do imóvel que deseja desalugar: ");
                    int numDesalugar = scanner.nextInt();
                    scanner.nextLine();
                    Imovel imovelDesalugar = sistema.buscarImovelPorNumero(numDesalugar);
                    if (imovelDesalugar != null) {
                        if (sistema.desalugarImovel(imovelDesalugar)) {
                            System.out.println("Imóvel desalugado com sucesso!");
                        } else {
                            System.out.println("O Imóvel já estava disponível.");
                        }
                    } else {
                        System.out.println("O Imóvel não pode ser encontrado.");
                    }
                    break;

                case 7: // Listando Imóveis Disponíveis
                    System.out.println("\nImóveis disponíveis:");
                    for (Imovel i : sistema.getImoveisDisponiveis()) {
                        System.out.println("Número: "
                                + i.getNumero()
                                + " | Valor: R$ "
                                +  nf.format(i.getValorAluguel())
                                +
                                " | Proprietário: "
                                + i.getProprietario().getNome());
                    }
                    break;

                case 8: // Buscando Proprietários por CPF
                    System.out.print("Insira o CPF do Proprietário: ");
                    String cpfBusca = scanner.nextLine();
                    Proprietario encontrado = sistema.buscarProprietarioPorCpf(cpfBusca);
                    if (encontrado != null) {
                        System.out.println("O Proprietário foi encontrado: " + encontrado.getNome());
                    } else {
                        System.out.println("O Proprietário não pode ser encontrado.");
                    }
                    break;

                case 9: // Calculando valor total de um  Aluguel
                    System.out.print("Insira o número do imóvel: ");
                    int numCalc = scanner.nextInt();
                    System.out.print("Meses: ");
                    int meses = scanner.nextInt();
                    scanner.nextLine();
                    Imovel imovelCalc = sistema.buscarImovelPorNumero(numCalc);
                    if (imovelCalc != null) {
                        double total = sistema.calcularAluguelTotal(imovelCalc, meses);
                        System.out.println("O valor total do aluguel para será: R$ " + nf.format(total));
                    } else {
                        System.out.println("Imóvel não encontrado.");
                    }
                    break;

                case 0:
                    sair = true;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
