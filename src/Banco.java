import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Cliente cliente, String tipoConta) {
        if (tipoConta == "corrente") {
            Conta conta = new ContaCorrente(cliente);
            this.contas.add(conta);
        } else if (tipoConta == "poupanca") {
            Conta conta = new ContaPoupanca(cliente);
            this.contas.add(conta);
        }
    }

    public void removerConta(int numero){
        if(!contas.isEmpty()){
            for(Conta i : contas){
                if(i.getNumero() == numero){
                    contas.remove(i);
                }
            }
        }else{
            System.out.println("\n!Não há contas cadastradas!");
        }
    }

    public void exibirContas() {
        if (!contas.isEmpty()) {
          System.out.println(this.contas);
        } else {
          System.out.println("!Não há contas cadastradas!");
        }
      }
    
    @Override
    public String toString() {
        return "Banco [nome=" + nome + ", contas=" + contas + "]";
    }

    
}
