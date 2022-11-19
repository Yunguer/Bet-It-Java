package Questao2;

public class ApostaA extends Aposta{
    
    private String time;
    
    public ApostaA(Cliente cliente,Partida partida,double totalA_,String time_) //Construtor da ApostaA
    {
        super(cliente,partida,totalA_);
        time = time_;
        bonus = totalA * 1.4;
    }
    
    @Override
    public void calculaResultado() // Override do Calcular resultado
    {
        String vencedor;
        
        if(partida.getGt1()>partida.getGt2()) //  Pega o vencedor da partida
        {
            vencedor = partida.getTime1();
        }
        else if(partida.getGt1()<partida.getGt2()) //  Pega o vencedor da partida
        {
            vencedor = partida.getTime2();
        }
        else
        {
            vencedor = ""; // Vencedor = Empate
        }
        
        if(time.equals(vencedor)) //Aposta ganha se time apostado = time vencedor
        {
            status="VENCIDA";
            Pagar(bonus);
        }
        else
        {
            status="PERDIDA"; // Aposta perdida
        }
    }
    
}
