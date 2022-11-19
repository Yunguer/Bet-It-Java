package Questao2;
import java.util.ArrayList;

public class Cliente {
    private static int ct=0;
    private int id;
    private String nickname;
    private double saldo;
    private boolean vip;
    ArrayList<Aposta> apostas;
    
    public Cliente(String nickname_,boolean vip_) // Construtor Cliente
    {
        id = ct++;
        nickname = nickname_;
        saldo = 0;
        vip = vip_;
        apostas = new ArrayList<>();
    }
    
    public void InsereCreditos(double creditos) // Insere creditos
    {
        saldo = saldo + creditos;
    }
    
    public void RealizaAposta(Aposta a) // Cria aposta e retira o saldo
    {
        saldo = saldo - a.getTotalAp();
        if(vip == true)
        {
            saldo = saldo - 5; // Taxa extra do VIP
            if(saldo < 0)
            {
                saldo = 0;
            }
        }
        apostas.add(a);
    }
    
    public int getId() // Pega ID
    {
        return id;
    }
    
    public String getNome() // Pega Nome
    {
        return nickname;
    }
    
    public boolean getVip() // Pega o Boolean do VIP
    {
        return vip;
    }
    
    public double getSaldo() // Pega o saldo
    {
        return saldo;
    }
    
}
