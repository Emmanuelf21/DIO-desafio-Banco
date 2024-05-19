import Banco.Banco;
import Clientes.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Mariana", "cc");
        c1.criarConta("cp");
        Cliente c2 = new Cliente("Joana", "cp");
        Cliente c3 = new Cliente("João", "cc");
        Banco b1 = new Banco();

        //adicionando clientes na lista de clientes do banco
        b1.setClientes(c1);
        b1.setClientes(c2);
        b1.setClientes(c3);

        //fazendo depósito a partir do número da conta
        c1.getConta(1).depositar(2000);

        c1.getConta(1).transferir(c2.getConta(3), 1000);
        
        c1.todasAsContas();

        b1.listarClientes();
    }
}
