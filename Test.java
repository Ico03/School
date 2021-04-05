import mypackage.*;
public class Test
{
    static Gestinput input = new Gestinput();
    static int scelta=0;
    static String inserimento;
    static String app = "", oggio = "";
    public static void main (String args[])
    {
        California california = new California();
        Mexico mexico = new Mexico();
        Texas texas = new Texas();
        char ap=' ';
        char c=' ';
        double op1=0, op2=0,op;
        do
        {
            System.out.println("Quale operazione vuoi eseguire?");
            System.out.println("0) Inserisci l'espressione");
            System.out.println("1) Calcolo dell'escpressione in notazione polacca");
            System.out.println("2) Stampa risultato espressione");
            System.out.println("4) Uscita");
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
                        c = inserimento.charAt(i);
                        
                        if(c>47 && c<58)
                        {
                            california.push(c);
                        }
                        else
                        {
                            switch(c)
                            {
                                case '+':
                                case '-':
                                    
                                if(texas.top==null || texas.top.numero=='(')
                                {
                                    texas.push(c);
                                }
                                else
                                    if(texas.top.numero=='+' || texas.top.numero=='-' || texas.top.numero=='*' || texas.top.numero=='/')
                                    {
                                        if(texas.top.numero!='(')
                                        {
                                            ap = texas.top.numero;
                                            california.push(ap);
                                            texas.pop();
                                            texas.push(c);
                                        }
                                    
                                    }
                                    break;
                                    
                                case '*':
                                case '/':
                                    
                                    if(texas.top == null || texas.top.numero=='+' || texas.top.numero=='-' || texas.top.numero=='(')
                                        {
                                            texas.push(c);
                                        }
                                        else
                                        if(texas.top.numero=='*' || texas.top.numero=='/')
                                        {
                                          if(texas.top.numero!='(')
                                            {
                                                ap = texas.top.numero;
                                                california.push(ap);
                                                texas.pop();
                                                texas.push(c);
                                            }                               
                                        }
                                    break;    
                                        
                                case '(':
                                    if(texas.top == null || texas.top.numero=='+' || texas.top.numero=='-' || texas.top.numero=='*' || texas.top.numero=='/')
                                    {
                                        texas.push(c);
                                    }
                                    break;
                                    
                                case ')':
                                    do
                                    {
                                        if(texas.top.numero!='(')
                                            california.push(texas.pop());
                                        else
                                            texas.pop();
                                            
                                    }
                                    while(texas.top.numero!='(');
                                    
                                    break;    
                                case '=':
                                    while(texas.top!=null)
                                    {
                                        california.push(texas.pop());
                                    }
                                    
                            }
                        }
                    }
                    texas.stampa();
                    california.stampa();
                    //carico lo stack all'interno della variabile app
                    while (california.top != null)
                    {
                        app += california.top.numero;
                        california.pop();
                    }
                    //carico la variabile oggio che conterrà la stringa in notazione
                    for(int i=app.length()-1; i>=0; i--)
                    {
                        if(app.charAt(i)!='(')
                        {
                            oggio += app.charAt(i);
                        }   
                    }
                    System.out.println("Espressione in notazione: " +oggio);               
                    break;
                                  
                case 2:
                    
                    for(int i=0; i<oggio.length(); i++)
                    {
                        c=oggio.charAt(i);
                        if(c>='0' && c<='9') //c==numero carica stack mexico 
                        {
                            op=(double)c-'0';
                            mexico.push(op);
                        }
                        else
                        {
                            op2=mexico.pop();
                            op1=mexico.pop();
                            switch(c) //effettuo le varie op. con gli operandi
                            {
                                case '+':
                                     mexico.push(op1+op2);
                                     break;
                                case '-':
                                     mexico.push(op1-op2);
                                     break;
                                case '*':
                                     mexico.push(op1*op2);
                                     break;
                                case '/':
                                     mexico.push(op1/op2);
                                     break;
                            }
                        }
                    }
                    System.out.println("risultato: "+ mexico.top.numer);
                    break;
                    
                
             
            }
        }
        while(scelta!=4);
    }
    
    
}
