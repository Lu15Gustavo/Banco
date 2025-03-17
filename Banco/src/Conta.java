abstract class Conta{
    private String nomeC;
    private double saldo;
    private int numC;
    private int agen;
    
    public Conta(String nomeC, int numC, int agen){
        this.agen = agen;
        this.nomeC = nomeC;
        this.numC = numC;
        this.saldo = 0;
       
    }
    
    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
    public abstract void transferir(Conta c, double valor);
    public abstract void exibirContas();
    
    public void setAgen(int agen) {
        this.agen = agen;
    }
    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }
    public void setNumC(int numC) {
        this.numC = numC;
    }
    public int getAgen() {
        return agen;
    }
    public String getNomeC() {
        return nomeC;
    }
    public int getNumC() {
        return numC;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    




}
