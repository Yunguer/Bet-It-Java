package Questao2;

public class ApostaC extends Aposta{
    
    private int gt1;
    private int gt2;
    
    public ApostaC(Cliente cliente, Partida partida, double totalA_, int gt1_, int gt2_) // Construtor Aposta C
    {
        super(cliente,partida,totalA_);
        gt1 = gt1_;
        gt2 = gt2_;
        bonus = totalA*4;
    }
    
    @Override
    public void calculaResultado() // Override do calcula resultado
    {
        int ga1 = partida.getGt1(); // Pega o placar
        int ga2 = partida.getGt2(); // Pega o placar
        
        if(partida.getGt1() == ga1 && partida.getGt2() == ga2) // Se o placar for igual = VENCIDA
        {
            this.status="VENCIDA";
            if((ga1+ga2)>6)
            {
                bonus = bonus + totalA * (1 + (ga1+ga2) * 0.2); // Bonus para mais de 6 gols
            }
            Pagar(bonus);
        }
        else 
        {
            status="PERDIDA"; // PERDIDA
        }
    }
    
}
