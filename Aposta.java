package Questao2;

public class Aposta {

    protected Cliente cliente;
    protected Partida partida;
    protected double totalA;
    protected double bonus;
    protected String status;
    
    
    public Aposta(Cliente cliente_,Partida partida_,double totalA_) // Construtor
    {
        cliente = cliente_;
        this.partida = partida_;
        totalA = totalA_;
        this.status = "FEITA";
    }
    
    public void calculaResultado() //Calcula resultado @Override nas outras classes
    {
    
    }
    
    public void Pagar(double valor) //Pagar a aposta
    {
        if(cliente.getVip() == true)
        {
            valor = valor * 1.05;
        }
        cliente.InsereCreditos(valor);
    }
    
    public double getTotalAp() //Pegar totalA
    {
        return totalA;
    }
    
    public Partida getPartida() //Pegar partida
    {
        return partida;
    }
    
    public String getStatus() //Pegar status
    {
        return status;
    }
    
    public double getBonus() //Pegar bonus
    {
        return bonus;
    }
    
    
}
