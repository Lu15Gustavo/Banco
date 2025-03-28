public class ContaPoupanca extends Conta {
    
    boolean tipo;
    private String contaP;
    public ContaPoupanca(String nomeC, int numC, int agen, boolean tipo) {
            super(nomeC, numC, agen);
            this.tipo = tipo;
            if (tipo) {
                this.contaP = "Conta Poupança";
            }
        }   
    @Override    
    public void depositar(double valor){
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Saldo adicionado com sucesso");
        }
        else
            System.out.println("Valor invalido");
    }
    @Override
    public void sacar(double valor){
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
        }
        else
            System.out.println("Valor de saque invalido");
    }
    @Override
    public void transferir(Conta c, double valor){
        if (valor > 0 && valor < getSaldo()) {
            setSaldo(getSaldo() - valor);
            c.setSaldo(c.getSaldo() + valor);
            System.out.println("Transferencia realizada com sucesso.");
        }
        else
            System.out.println("Valor invalido para transferencia.");
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    @Override
    public void exibirContas(){
        System.out.println("\n Nome: " + getNomeC() + "\n Numero da Conta: "+ getNumC() + "\n Agencia: " + getAgen() + "\n Saldo: " + getSaldo());
    }

    @Override
    public String toString() {
        return "\n Nome: " + getNomeC() + "\n Numero da Conta: "+ getNumC() + "\n Agencia: " + getAgen() + "\n Saldo: " + getSaldo();
    }
    public void setContaP(String contaP) {
        this.contaP = contaP;
    }
    public String getContaP() {
        return contaP;
    }
}
