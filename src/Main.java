public class Main {
    public static void main(String[] args) {
        Cliente mateus = new Cliente();
        mateus.setNome("Mateus");
        Cliente pedro = new Cliente();
        pedro.setNome("Pedro");

        
        Banco b = new Banco();
        b.adicionarConta(pedro, "corrente");
        b.adicionarConta(mateus, "poupanca");

        b.exibirContas();
    
        b.removerConta(1);
        b.exibirContas();
    }
}
