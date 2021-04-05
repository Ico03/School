
public class Oggetto
{
    char numero;
    double numer;
    Oggetto prec;
    Oggetto (double numer)
    {
        this.numer = numer;
        prec = null;
    }
    
    Oggetto (char numero)
    {
        this.numero = numero;
        prec = null;
    }
    
    
}