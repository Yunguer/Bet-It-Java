package Questao2;

public class ApostaB extends Aposta {
    
    private int qntGol;
    
    public ApostaB(Cliente cliente,Partida partida,double totalA_,int qntGol_) // Construtor da Aposta B
    {
        super(cliente,partida,totalA_);
        qntGol = qntGol_;
        bonus = totalA * 2;
    }
    
    @Override
    public void calculaResultado() // Override do Calcular resultado
    {
        int golW;
        
        if(partida.getGt1() > partida.getGt2()) // Pega os gols do ganhador
        {
            golW = partida.getGt1();
        }
        else
        {
            golW = partida.getGt2();
        }
        
        if(qntGol == golW) // Se qntGol apostada for = a gols do ganhador VENCIDA
        {
            status = "VENCIDA";
            if(golW>4)
            {
                bonus = bonus + totalA * (1 + golW * 0.1); // Bonus para mais de 4 gols
            }
            Pagar(bonus);
        }
        else
        {
            status="PERDIDA"; // Perdida
        }
    }
    
}
