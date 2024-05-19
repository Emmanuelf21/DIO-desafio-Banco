package Contas.tiposDeContas;
import Contas.Conta;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(String tipoConta){
        super(tipoConta);
    }
    public void imprimirExtrato(){
        System.out.println("==== Extrato Conta Poupança ====");
        imprimirInfosConta();    
    }

    
}
