package Banco;
import java.util.ArrayList;
import java.util.List;

import Clientes.Cliente;

//Banco possúi uma lista de clientes e tem acesso a suas contas
public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private String nome = "Banco DIO";
    public Banco(){
    }

    public void novoCliente(Cliente c){
        clientes.add(c);
    }

    //lista todos os cliente, seus dados e suas contas
    public void listarClientes(){
        if(!clientes.isEmpty()){
            for (Cliente c : clientes) {
                System.out.println("-------------------------------------------");
                System.out.println("Nome: "+ c.getNome());
                c.todasAsContas();
            }
        }
        else{
            System.out.println("Não existe clientes!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setClientes(Cliente cliente) {
        clientes.add(cliente);
    }
}
