import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        ArrayList<Conta> ListadeContas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        double valor;
        boolean contaE = false;
        int opcao = 0;

        do {
            System.out.println("1 - Criar conta.");
            System.out.println("2 - Depositar.");
            System.out.println("3 - Sacar.");
            System.out.println("4 - Transferir.");
            System.out.println("5 - Exibir contas.");
            System.out.println("6 - Sair.");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                        System.out.println("Nome do cliente: ");
                        String nome = sc.nextLine();
                        System.out.println("Numero da conta: ");
                        int num = sc.nextInt();
                        System.out.println("Numero da agencia: ");
                        int numagen = sc.nextInt();
                        System.out.println("Conta corrente ou Conta Poupança. 1 - Corrente || 2 - Poupança");
                        int cp = sc.nextInt();
                        if (cp == 1) {
                            boolean tipo = true;
                            ListadeContas.add(new ContaCorrente(nome, num, numagen, tipo));
                        }
                        else if (cp == 2) {
                            boolean tipo = true;
                            ListadeContas.add(new ContaPoupanca(nome, num, numagen, tipo));
                        }
                        else{
                            System.out.println("Valor errado, escolha 1 ou 2.");
                            break;
                        }
                    break;
                case 2:
                        System.out.println("Numero da conta para deposito: ");
                        int numeroC = sc.nextInt();
                        contaE = false;
                        for (Conta conta : ListadeContas) {
                            if (conta.getNumC() == numeroC) {
                                System.out.println("Valor do deposito: ");
                                valor = sc.nextDouble();
                                conta.depositar(valor);
                                contaE = true;
                                break;
                            }
                        }
                        if (!contaE) {
                            System.out.println("Conta não encontrada.");
                        }
                    break;    
                case 3:
                        System.out.println("Numero da conta para saque: ");
                        numeroC = sc.nextInt();
                        contaE = false;
                        for (Conta conta : ListadeContas) {
                            if (conta.getNumC() == numeroC) {
                                System.out.println("Valor do saque: ");
                                valor = sc.nextDouble();
                                conta.sacar(valor);
                                contaE = true;
                                break;
                            }
                        }
                        if (!contaE) {
                            System.out.println("Conta não encontrada.");
                        }
                    break;   
                case 4:
                        System.out.println("Numero da conta para transferencia: ");
                        numeroC = sc.nextInt();

                        System.out.println("Numero da conta para receber a transferencia: ");
                        int numeroC1 = sc.nextInt();

                        System.out.println("Valor da transferencia: ");
                        valor = sc.nextDouble();

                        for (Conta conta : ListadeContas) {
                            if (conta.getNumC() == numeroC) {
                                for (Conta conta2 : ListadeContas) {
                                    if (conta2.getNumC() == numeroC1) {
                                        conta.transferir(conta2, valor);
                                        contaE = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!contaE) {
                            System.out.println("Conta não encontrada.");
                        }
                    break; 
                    
                case 5:
                        for (Conta conta : ListadeContas) {
                            conta.exibirContas();
                        }
                    break;            
                case 6:
                        System.out.println("Saindo...."); 
                    break;           
                default:
                        System.out.println("Opção invalida, olhe o menu.");
                    break;
            }

        } while (opcao != 6);
        sc.close();
    }
}
