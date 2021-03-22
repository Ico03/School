#include <iostream>
#include <fstream>
#include <string>
#include <stdlib.h>
#define DIM 3

using namespace std;

struct rubrica
{
    int codice;
    long int numero;
    string nome;
    string cognome;
}rubric[DIM];

void carico()
{
    ofstream miofile;
    miofile.open("file.dat",  ios::out | ios::binary );//mettere out
    if(miofile.is_open())
    {
        for(int i=0; i<DIM; i++)
        {
            rubric[i].codice = i+1;
            cout << "codice ID utente: " << rubric[i].codice << "\n";


            cout << "Numero di telefono: ";
            cin >> rubric[i].numero;

            cout << "Cognome: ";
            fflush(stdin);
            getline(cin,rubric[i].cognome);

            cout << "Nome: ";
            getline(cin,rubric[i].nome);

            ///carico del file
            miofile.write((char *)&rubric[i],sizeof(rubric[i]));//perchè &
        }
        miofile.close();
    }
    else
        cout << "\n FALLITO \n";
}

void stampa()
{
    ifstream miofile;
    miofile.open("file.dat",  ios::out | ios::binary );//mettere app
    if(miofile.is_open())
    {
        for(int i=0; i<DIM; i++)
        {
            miofile.read((char *)&rubric[i], sizeof(rubric[i]));
            cout << rubric[i].codice << "\t";
            cout << rubric[i].numero << "\t";
            cout << rubric[i].cognome << "\t";
            cout << rubric[i].nome << "\n";
        }
    }
    else
        cout << "\n FALLITO \n";
}

void ricerca()
{
    ifstream miofile;
    miofile.open("file.dat",  ios::in | ios::binary );//mettere app
    if(miofile.is_open())
    {
        rubrica appoggio;
        long cod=0;
        long cont;
        cout << "Inserire il codice da ricercare: ";
        cin >> cod;
        cont=(cod-1)*(sizeof(appoggio));
        miofile.seekg(cont);
        miofile.read((char*)&appoggio,sizeof(appoggio));
        cout << appoggio.codice << "\t";
        cout << appoggio.numero << "\t";
        cout << appoggio.cognome << "\t";
        cout << appoggio.nome << "\n";

        miofile.close();
    }
    else
        cout << "\n FALLITO \n";
}

int main()
{
   int scelta;
    do
    {

        cout << "\nScegliere una delle seguenti opzioni" << endl;
        cout << "1. caricare la struttutra\n";
        cout << "2. Stampo struttura\n";
        cout << "3. Ricerca\n";
        cout << "4. Uscita";
        cin >> scelta;

        switch (scelta)
        {
            case 1:
                carico();
                break;
            case 2:
                stampa();
                break;
            case 3:
                ricerca();
                break;
        }
    }
    while (scelta != 4);
    return 0;
}
