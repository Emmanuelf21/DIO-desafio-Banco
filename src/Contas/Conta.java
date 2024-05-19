package Contas;
//class abstrata não pode ser instanciada
//nesse caso, não faz sentido instanciar a class Conta
//já que é obrigatório definir se a conta é corrente ou poupança

import Contas.tiposDeContas.IConta;

public abstract class Conta implements IConta{

    private int agencia;
    private int numero;
    private double saldo;
    private String tipoDeConta;
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    public Conta(String tipoConta){
        if(tipoConta.toLowerCase() == "cc"){
            setTipoDeConta("Conta Corrente");
        }
        else if(tipoConta.toLowerCase() == "cp"){
            setTipoDeConta("Conta Poupança");
        }
        setAgencia(Conta.AGENCIA_PADRAO);
        setNumero(getSEQUENCIAL());
        SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor){
        if(getSaldo()>=valor){
            this.saldo -= valor;
        }
        else{
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void depositar(double valor){
        this.saldo+=valor;
        System.out.println("Depósito efetuado com sucesso!");
    }

    @Override
    public void transferir(Conta contaDestino, double valor){
        if(this.saldo>=valor){
            this.sacar(valor);;
            contaDestino.depositar(valor);
            System.out.println("Transferência efetuada!");
        }
    }
    //imprimi os dados da conta
    protected void imprimirInfosConta(){
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void setTipoDeConta(String tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public int getAgencia() {
        return agencia;
    }

    protected void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    protected void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
 
    public static int getAgenciaPadrao() {
        return AGENCIA_PADRAO;
    }

    private static int getSEQUENCIAL() {
        return SEQUENCIAL;
    }
}
