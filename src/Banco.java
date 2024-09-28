
import java.util.HashMap;
import java.util.Map;

public class Banco {
    private  static final String  NOME= "Banco do Brasil";
    private Map<Integer, Conta> contas;

    
    public Map<Integer, Conta> getContas() {
        return contas;
    }

    public void setContas(Map<Integer, Conta> contas) {
        this.contas = contas;
    }
    
    public String getNome() {
        return NOME;
    }

    public Banco() {
        this.contas = new HashMap<>();
    }

    public void adicionarConta(Cliente cliente, String tipoConta) {
        if (tipoConta == "corrente") {
            Conta conta = new ContaCorrente(cliente);
            this.contas.put(conta.numero, conta);
        } else if (tipoConta == "poupanca") {
            Conta conta = new ContaPoupanca(cliente);
            this.contas.put(conta.numero, conta);
        }
    }

    public void removerConta(int numero){
        if(!contas.isEmpty()){
          contas.remove(numero);
        }else{
            System.out.println("\n!Não há contas cadastradas!");
        }
    }

    public Conta pesquisarPorNumero(int numero){
        if(contas.isEmpty()){
            System.out.println("\n!Não há contas cadastradas!");
            return null;
        }else if(contas.get(numero) == null){
            System.out.println("\n!Conta não encontrada!");
            return null;
        }else{
            return contas.get(numero);
        }
      
    }

    public void depositar(int numero, double valor){
        pesquisarPorNumero(numero).depositar(valor);
    }

    public void sacar(int numero, double valor){
        pesquisarPorNumero(numero).sacar(valor);
    }

    public void transferir(int numContaSaida, double valor, int numContaDestino){
        pesquisarPorNumero(numContaSaida).sacar(valor);
        pesquisarPorNumero(numContaDestino).depositar(valor);

    }
    public void exibirContas() {
        if (!contas.isEmpty()) {
          for(Conta  c: contas.values()){
            c.imprimirExtrato();
          }
        } else {
          System.out.println("!Não há contas cadastradas!");
        }
      }

  
    
}
