import java.util.Scanner;
import java.util.List;
import java.io.Console;
import java.util.ArrayList;

public class CatalogoProdotti{

    // Variabile globale per prendere in input le richieste
    static final Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args) {
        // Struttura dati dei vari prodotti
        List<Prodotto> prodotti = new ArrayList<Prodotto>();

        // Chiedo il numero di prodotti iniziali da inserire
        System.out.print("Inserisci il numero di prodotti: ");
        int numeroProdotti = SCAN.nextInt();

        // Variabili da overridare per ogni prodotto
        String nome;
        String descrizione;
        Double prezzo;

        // chiedo nome, descrizione e prezzo per nuneroProdotti volte
        // e inserisco il prodotto con queste caratteristiche nella struttura dati
        for(int i=0; i<numeroProdotti; i++){
            System.out.print("Inserisci il nome del prodotto: ");
            SCAN.nextLine();
            nome = SCAN.nextLine();
            System.out.print("Inserisci la descrizione del prodotto: ");
            descrizione = SCAN.nextLine();
            System.out.print("Inserisci il prezzo del prodotto: ");
            prezzo = SCAN.nextDouble();

            prodotti.add(new Prodotto(nome, descrizione, prezzo));
            System.out.println();
        }


        // Chiedo all'utente se vuole accedere o uscire
        System.out.println("1. Accedi\n2. Esci");
        int choice = SCAN.nextInt();

        switch(choice){
            case 1:
                //runno la funzione menu e  se l'utente vuole uscire fermo il programma
                if(menu(prodotti)){
                    return;
                }
                break;
            case 2:
                // chiudo il programma
                return;
        }
    }

    // funzione per chiedere mail e password e crearci l'utente
    public static User accedi(){
        Console console = System.console();

        // chiedo mail e password
        System.out.print("Inserisci la mail: ");
        SCAN.nextLine();
        String email = SCAN.nextLine();
        System.out.print("Inserisci la password: ");
        String password = new String(console.readPassword());

        return new User(email, password);
    }

    public static boolean menu(List<Prodotto> prodotti){
        // retrive dell'utente tramite la fun\ione accedi
        User user = accedi();
        // controllo se l'utente è admin
        // parto dal presupposto che ci sia un solo admin con la mail mail@mail.it
        user.setAdmin(user.getEmail().equals("mail@mail.it"));

        // se non è admin printo un tipo di menu altrimenti ne printo un altro
        if(!user.isAdmin()){
            System.out.println("1. Visualizza Prodotti\n2. Esci");
            int choice = SCAN.nextInt();

            switch(choice){
                case 1:
                    for(Prodotto p : prodotti){
                        System.out.println(p);
                    }
                    break;
                case 2:
                    return true;
            }
        }else{
            System.out.println("1. Visualizza Prodotti\n2. Aggiungi Prodotto\n3. Modifica Prodotto\n4. Elimina Prodotto\n5. Esci");
            int choice = SCAN.nextInt();

            while(choice<=5 && choice > 0){
                switch(choice){
                    case 1:
                        for(Prodotto p : prodotti){
                            System.out.println(p);
                            System.out.println();
                        }
                        break;
                    case 2:
                        // chiedo le specifiche di un prodotto e lo inserisco nella lista
                        System.out.print("Inserisci il nome del prodotto: ");
                        SCAN.nextLine();
                        String nome = SCAN.nextLine();
                        System.out.print("Inserisci la descrizione del prodotto: ");
                        String descrizione = SCAN.nextLine();
                        System.out.print("Inserisci il prezzo del prodotto: ");
                        double prezzo = SCAN.nextDouble();

                        prodotti.add(new Prodotto(nome, descrizione, prezzo));
                        break;
                    case 3:
                        // chiedo l'indice e le specifiche di un prodotto e modifico il prodotto a quell'indice
                        System.out.print("Inserisci l'indice del prodotto: ");
                        int i = SCAN.nextInt();
                        System.out.print("Inserisci il nome del prodotto: ");
                        String nome1 = SCAN.nextLine();
                        System.out.print("Inserisci la descrizione del prodotto: ");
                        String descrizione1 = SCAN.nextLine();
                        System.out.print("Inserisci il prezzo del prodotto: ");
                        double prezzo1 = SCAN.nextDouble();

                        prodotti.set(i, new Prodotto(nome1, descrizione1, prezzo1));
                        break;
                    case 4:
                        // chiedo l'indice del prodotto e elimino il prodotto a quell'indice
                        System.out.print("Inserisci l'indice del prodotto: ");
                        int i1 = SCAN.nextInt();

                        prodotti.remove(i1);
                    case 5:
                        return true;
                }

                System.out.println();
                System.out.println("1. Visualizza Prodotti\n2. Aggiungi Prodotto\n3. Modifica Prodotto\n4. Elimina Prodotto\n5. Esci");
                choice = SCAN.nextInt();
            }
        }

        return false;
    }
}