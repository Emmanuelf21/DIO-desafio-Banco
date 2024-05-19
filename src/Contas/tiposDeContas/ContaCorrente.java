package Contas.tiposDeContas;
import Contas.Conta;

public class ContaCorrente extends Conta {
    public ContaCorrente(String tipoConta){
        super(tipoConta);
    }
    public void imprimirExtrato(){
        System.out.println("==== Extrato Conta Corrente ====");
        imprimirInfosConta();
    }
}
