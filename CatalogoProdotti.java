import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CatalogoProdotti{
    public static void main(String[] args) {
        List<Prodotto> prodotti = new ArrayList<Prodotto>();

        Scanner scan = new Scanner(System.in);
        System.out.print("Inserisci il numero di prodotti: ");
        int numeroProdotti = scan.nextInt();

        String nome;
        String descrizione;
        double prezzo;

        for(int i=0; i<numeroProdotti; i++){
            System.out.print("Inserisci il nome del prodotto: ");
            nome = scan.nextLine();
            System.out.print("Inserisci la descrizione del prodotto: ");
            descrizione = scan.nextLine();
            System.out.print("Inserisci il prezzo del prodotto: ");
            prezzo = scan.nextDouble();

            prodotti.add(new Prodotto(nome, descrizione, prezzo));
        }

        scan.close();
    }
}