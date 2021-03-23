import mypackage.*;
public class Test
{
    static Gestinput input = new Gestinput();
    static int scelta=0;
    static String inserimento;
    public static void main (String args[])
    {
        California california = new California();
        Texas texas = new Texas();
        char ap=' ';
        String app = "", oggio = "";
        do
        {
            System.out.println("Quale operazione vuoi eseguire?");
            System.out.println("0) Inserisci l'espressione");
            System.out.println("1) Push");
            System.out.println("2) Stampa");
            System.out.println("4) EXIT");
            scelta = Integer.valueOf(input.Lettura());
            
            switch(scelta)
            {
                case 0:
                    System.out.println("Inserimento stringa");
                    inserimento = input.Lettura();
                    break;
                
                case 1:
                    System.out.println("effetto operazione Push");
                    for(int i=0; i<inserimento.length(); i++)
                    {
                        char c = inserimento.charAt(i);
                        System.out.println("c " +c);
                        
                        if(c>47 && c<58)
                        {
                            california.push(c);
                             System.out.println("op 1 numeri");
                        }
                        else
                        {
                            
                            if(texas.top == null)//texas.push(c);
                              {  texas.push(c);
                                 System.out.println("op top null");}
                            else
                                if(c==')')
                                {
                                    while(texas.top.numero != '(')
                                    {
                                        california.push(texas.pop());
                                         System.out.println("op 1 finchè top )");
                                    }
                                }
                                else
                                switch(texas.top.numero)
                                {
                                    case '+':
                                    case '-':
                                        if(c=='+' || c=='-' || c==')')
                                        {
                                            ap = texas.top.numero;
                                            california.push(ap);
                                            texas.pop();
                                            texas.push(c);
                                            System.out.println("op 2 con top + -");
                                        }
                                        else
                                            if(c=='*' || c=='/' || c=='(')
                                            {
                                                texas.push(c);
                                                System.out.println("op 1 con top + -");
                                            }
                                        break;
                                            
                                    case '*':
                                    case '/':
                                        if(c=='+' || c=='-' || c=='*' || c=='/' || c==')')//controlare se le parentesi chiuse vanno in california
                                        {
                                            ap= texas.top.numero;
                                            california.push(ap);
                                            texas.pop();
                                            texas.push(c);
                                            System.out.println("op 2 con top * /");
                                        }
                                        else 
                                            if(c=='(')
                                            {
                                                texas.push(c);
                                                 System.out.println("op 1 con top * /");
                                            }
                                            
                                        break;
                                    case '(':
                                        if(
                                }
                                
                                if(c=='=')//c== =
                                {
                                    System.out.println("C"+c);
                                    while(texas.top != null)
                                    {
                                         System.out.println("op sposta con top =");
                                        ap = texas.top.numero;
                                        System.out.println("ap " +ap);
                                        california.push(ap);
                                        texas.pop();
                                    }
                                } 
                                                                        
                        }
                    }
                   
                    
                    break;
                    
                    
                case 2:
                    texas.stampa();
                    california.stampa();
                    while (california.top != null)
                    {
                        //System.out.println("SONO IN WHILE");
                        app += california.top.numero;
                        california.pop();
                    }
                    
                    for(int i=app.length()-1; i>=0; i--)
                    {
                        //System.out.println("SONO IN for");
                        oggio += app.charAt(i);
                    }
                    System.out.println("Espressione in notazione: " +oggio);
                    
            }
        }
        while(scelta!=4);
    }
}