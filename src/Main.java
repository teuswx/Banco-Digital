import java.util.Scanner;

public class Main {
    public static void main(String[] args) {   
        char c = ' ';
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        while (c != 's') {
            do {
                System.out.println("\nDigite uma letra para realizar sua respectiva função: \na-Cadastrar conta\nb-Depositar\nc-Sacar\nd-Trasferir saldo\ne-Excluir conta\nf-Exibir contas\ns-Sair");
                c = scanner.next().charAt(0);
              
                if(c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c != 'f'  && c != 's'){
                    System.out.println("\n!Digite uma opção válida!\n");
                }     
            } while (c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c != 'f' && c != 's');
       

            switch (c) {
                case 'a':
                    
                    System.out.println("\nDigite o nome do cliente: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    Cliente cliente = new Cliente(nome);
                    String tipoContaAux ="";
                    char tipoConta = 'c';
                    do {
                        System.out.println("\nSelecione uma opção de conta:\na-Conta corrente\nb-conta poupança");
                        tipoConta = scanner.nextLine().charAt(0);
                        if (tipoConta == 'a') {
                            tipoContaAux = "corrente";
                        } else if (tipoConta == 'b') {
                            tipoContaAux = "poupanca";
                        }
                       
                        if(tipoConta != 'a' && tipoConta != 'b' ){
                            System.out.println("\n!Digite uma opção válida!\n");
                        }     
                    } while (tipoConta != 'a' && tipoConta != 'b' );
                    
                    System.out.println(cliente);
                    System.out.println(tipoContaAux);
                    banco.adicionarConta(cliente, tipoContaAux);
                   
                    break;
                case 'b':
                    int numeroConta = 0;
                    double valor = 0;

                    System.out.println("\nDigite o número da conta: ");
                    scanner.nextLine();
                    numeroConta = scanner.nextInt();
                    System.out.println("\nDigite o valor do depósito: ");
                    scanner.nextLine();
                    valor = scanner.nextDouble();

                    banco.depositar(numeroConta, valor);
                    break;
                case 'c':
                    numeroConta = 0;
                    valor = 0;

                    System.out.println("\nDigite o número da conta: ");
                    scanner.nextLine();
                    numeroConta = scanner.nextInt();
                    System.out.println("\nDigite o valor de saque: ");
                    scanner.nextLine();
                    valor = scanner.nextDouble();

                    banco.sacar(numeroConta, valor);
                    break;
                case 'd':
                int numeroContadestino = 0;
                numeroConta = 0;
                valor = 0;

                System.out.println("\nDigite o número da conta de saída: ");
                scanner.nextLine();
                numeroConta = scanner.nextInt();
                System.out.println("\nDigite o número da conta de destino: ");
                scanner.nextLine();
                numeroContadestino = scanner.nextInt();
                System.out.println("\nDigite o valor da transferência: ");
                scanner.nextLine();
                valor = scanner.nextDouble();

                banco.transferir(numeroConta, valor, numeroContadestino);
                    break;
                case 'e':
                    numeroConta = 0;
                    System.out.println("\nDigite o número da conta: ");
                    scanner.nextLine();
                    numeroConta = scanner.nextInt();
                    banco.removerConta(numeroConta);
                    break;
                case 'f':
                    banco.exibirContas();
                    break;
                case 's':
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
