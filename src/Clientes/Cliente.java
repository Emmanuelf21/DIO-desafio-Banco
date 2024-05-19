package Clientes;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import Contas.Conta;
import Contas.tiposDeContas.*;

public class Cliente {
    private String nome;
    private List<Conta> contas = new ArrayList<>();
    
    //instância cliente e uma nova conta de acordo com o tipo escolhido
    public Cliente (String nome, String tipoConta){
        this.nome = nome;
        criarConta(tipoConta);
    }

    //cria uma nova conta caso o cliente já exista
    public void criarConta(String tipoConta){
        if(tipoConta.toLowerCase().equalsIgnoreCase("cc")){
            this.contas.add(new ContaCorrente(tipoConta));
        }
        else if(tipoConta.toLowerCase().equalsIgnoreCase("cp")){
            this.contas.add(new ContaPoupanca(tipoConta));
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //retora a conta através do numero de conta do cliente
    public Conta getConta(int numero) {
        for (Conta c : contas) {
            if(c.getNumero() == numero)
                return c;
        }
        //retorna erro caso a conta não exista
        throw new RuntimeErrorException(null, "Conta não existe!");
    }

    //lista todas as contas do cliente
    public void todasAsContas(){
        if(!contas.isEmpty()){
            System.out.println("Contas:");
            for (Conta c : contas) {
                System.out.println(listarContas(c));
            }
        }
    }
    
    private String listarContas(Conta c){
        return "\tConta: {Agência: " + c.getAgencia()+ ", Número: "+ c.getNumero()+", Tipo de Conta: "+c.getTipoDeConta()+"}";
    }
    
}
