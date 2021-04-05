import mypackage.*;
public class Texas
{
    static Gestinput input = new Gestinput();
    static Oggetto top/*cima*/, bottom/*fondo stack*/, elemento/*nome variabile*/;
    static char n, numchar, ap, c =' ';
    
    public void stampa()
    {
        elemento=top;
        if(elemento==null)
            System.out.println("Non c'è niente da visualizzare");
        
            while(elemento!=null)
            {
                System.out.println("STAMPA "+elemento.numero);
                elemento=elemento.prec;
            }
            System.out.println("\n");
    }
    
    public char pop()
    {
        if (top!=null)
        {
            //System.out.println("ESTRAGGO" + top.numero);
            ap = top.numero;
            c = top.numero;
            top=top.prec;
        }
        else
        {
            System.out.println("Stack vuoto");
        }
        return c;
    }
    
    public void push(char n)
    {
        elemento = new Oggetto(n);
        if (bottom == null)
        {
            bottom = elemento;
            top = elemento;
        }
        else 
        {
            elemento.prec=top;
            top = elemento;
        }
    }
}