package Questao2;
import java.util.*;

public class Principal2 {
    public static void main(String args[])
    {
        
        int op = 0;
        
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Cliente> c = new ArrayList<>();
        ArrayList<Partida> p = new ArrayList<>();
        ArrayList<Aposta> a = new ArrayList<>();
        
        while(op != -1)
        {
            System.out.println("O que deseja fazer?");
            System.out.println("(1 = Criar cliente)\n(2 = Depositar dinheiro)\n(3 = Criar uma partida)\n(4 = Setar placar)\n(5 = Criar aposta)\n(6 = Imprimir apostas)\n(7 = Imprimir clientes)\n(8 = Imprimir partidas)\n(-1 = Parar)");
            op = sc.nextInt();
            if(op == 1) // Cria cliente
            {
                System.out.println("Digite o nome do cliente:");
                String nome = sc.next();
                System.out.println("Voce e VIP? (1 = Sim) (2 = Nao):");
                int vip = sc.nextInt();
                if(vip == 1)
                {
                    c.add(new Cliente(nome,true));
                }
                else if(vip == 2)
                {
                    c.add(new Cliente(nome,false));
                }
            }
            if(op == 2) // Deposita valor
            {
                int idc;
                double deposito;
                System.out.println("Digite o ID do cliente:");
                idc = sc.nextInt();
                if(idc<c.size())
                {
                    System.out.println("Digite o valor do depósito:");
                    deposito = sc.nextDouble();
                    c.get(idc).InsereCreditos(deposito);
                }
                else
                {
                    System.out.println("O ID não existe");
                }
            }  
            if(op == 3) // Cria partida
            {
                System.out.println("Digite o nome do time 1:");
                String t1 = sc.next();
                System.out.println("Digite o nome do time 2:");
                String t2 = sc.next();
                p.add(new Partida(t1,t2));
            }    
            if(op == 4) // Define resultado
            {
                int idp;
                System.out.println("Digite o ID da partida:");
                idp = sc.nextInt();
                if(idp<p.size())
                {
                    System.out.println("Digite a quantidade de gols do "+p.get(idp).getTime1());
                    int gt1 = sc.nextInt();
                    System.out.println("Digite a quantidade de gols do "+p.get(idp).getTime2());
                    int gt2 = sc.nextInt();
                    p.get(idp).DefineResultado(gt1,gt2);
               
                    for(Aposta ap : a)
                    {
                        if(ap.getPartida().getId() == idp) 
                        {
                            ap.calculaResultado();
                        }
                    }      
                }
                else 
                {
                    System.out.println("O ID não existe");
                }
            }  
            if(op == 5) // Cria aposta
            {   
                int idc;
                int idp;
                int aux;
                double v;
                System.out.println("Digite o ID do cliente:");
                idc = sc.nextInt();
                System.out.println("Digite o ID da partida:");
                idp = sc.nextInt();
                System.out.println("Digite o valor da aposta:");
                v = sc.nextDouble();
                
                if(idp<p.size() && idc<c.size())       
                {
                    System.out.println(p.get(idp).getTime1()+"|"+p.get(idp).getGt1()+"X"+p.get(idp).getGt2()+"|"+p.get(idp).getTime2());
                    
                    System.out.println("(1 = Apostar em quem ganha)\n(2 = Apostar no empate)\n(3 = Aposta em quantidade de gols do vencedor)\n(4 = Apostar no placar)");

                    aux = sc.nextInt();
                    
                    Aposta ap = null;
                    if(aux == 1) // Aposta tip A
                    {
                        int x;
                        String tap;
                        System.out.println("Apostar no time 1 ou time 2? (1 = Time 1) (2 = Time 2):");
                        x = sc.nextInt();
                        if(x == 1)
                        {
                            tap=p.get(idp).getTime1();
                            ap = new ApostaA(c.get(idc),p.get(idp),v,tap);
                        }
                        else if(x == 2)
                        {
                            tap=p.get(idp).getTime2();
                            ap = new ApostaA(c.get(idc),p.get(idp),v,tap);
                        }
                    }   
                    if(aux == 2) // Aposta tipo A (Empate)
                    {
                        ap = new ApostaA(c.get(idc),p.get(idp),v,"");
                    }
                    if(aux == 3) // Aposta tipo B
                    {
                        int qntg;
                        System.out.println("Digite qual sera a quantidade de gols que o ganhador fara:");
                        qntg = sc.nextInt();
                        ap = new ApostaB(c.get(idc),p.get(idp),v,qntg);
                    }
                    if(aux == 4) // Aposta tipo C
                    {
                        int qntg1;
                        int qntg2;
                        System.out.println("Digite quantidade de gols do time 1:");
                        qntg1 = sc.nextInt();
                        System.out.println("Digite quantidade de gols do time 2:");
                        qntg2 = sc.nextInt();
                        ap = new ApostaC(c.get(idc),p.get(idp),v,qntg1,qntg2);
                    }
                    a.add(ap);
                    c.get(idc).RealizaAposta(ap);
                }
                else 
                {
                    System.out.println("ID de cliente ou partida não existe!");
                }
            }
            if(op == 6) // Imprime as apostas
            {      
                for(int i = 0; i < a.size(); i++)
                {
                    System.out.println("Cliente:"+a.get(i).cliente.getNome());
                    System.out.println("ID da Partida:"+a.get(i).partida.getId());
                    System.out.println(a.get(i).partida.getTime1()+"|"+a.get(i).partida.getGt1()+"X"+a.get(i).partida.getGt2()+"|"+a.get(i).partida.getTime2());
                    System.out.println("Status:"+a.get(i).getStatus());
                    System.out.println("Valor apostado:"+a.get(i).getTotalAp());
                    System.out.println("Valor bonus: "+a.get(i).getBonus());
                }
            }
            if(op == 7) // Imprimir os clientes
            {
                for(int i = 0; i < c.size(); i++)
                {
                    System.out.println("ID:"+c.get(i).getId());
                    System.out.println("Nome do cliente:"+c.get(i).getNome());
                    if(c.get(i).getVip() == true)
                    {
                        System.out.println("VIP:Sim");
                    }
                    else
                    {
                        System.out.println("VIP:Não");
                    }
                    System.out.println("Saldo:R$"+c.get(i).getSaldo());
                }
            }
            if(op == 8) // Imprime os jogos
            {
                for(int i = 0; i < p.size(); i++)
                {
                    System.out.println("ID da Partida:"+p.get(i).getId());
                    System.out.println(p.get(i).getTime1()+"|"+p.get(i).getGt1()+"X"+p.get(i).getGt2()+"|"+p.get(i).getTime2());
                }
            }
        }   
    }
}
