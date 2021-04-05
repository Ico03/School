
public class Oggetto
{
    char numero;
    double numer;
    Oggetto prec;
    Oggetto (double numer)//costruttore di tipo double
    {
        this.numer = numer;
        prec = null;
    }
    
    Oggetto (char numero)//costruttore di tipo char
    {
        this.numero = numero;
        prec = null;
    }
    
    
}
