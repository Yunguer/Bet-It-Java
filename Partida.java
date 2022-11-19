
package Questao2;

public class Partida {
    private static int idAtual=0;
    private int id;
    private String time1;
    private String time2;
    private int gt1;
    private int gt2;
    
    public Partida(String time1_, String time2_) // Constutor da Partida
    {
        id=idAtual++;
        time1=time1_;
        time2=time2_;
        gt1 = 0;
        gt2 = 0;
    }
    
    public int getId() // Pega ID
    {
        return id;
    }
    
    public String getTime1() // Pega o nome do time 1
    {
        return time1;
    }
    public String getTime2() // Pega o nome do time 2
    {
        return time2;
    }
    
    public int getGt1() // Pega gols do time 1
    {
        return gt1;
    }
    
    public int getGt2() // Pega gols do time 2
    {
        return gt2;
    }
    
    public void DefineResultado(int gt1_,int gt2_) // Define resultado da partida
    {
        gt1 = gt1_;
        gt2 = gt2_;
    }
    
}
