public class Prodotto {
    // Variabili di istanza
    private String nome;
    private String descrizione;
    private double prezzo;

    // Costruttore
    public Prodotto(String n, String d, double p){
        this.nome = n;
        this.descrizione = d;
        this.prezzo = p;
    }

    // Setters
    public void setNome(String n){
        if(n!=null){
            this.nome = n;
        }
    }

    public void setDescrizione(String d){
        if(d!=null){
            this.descrizione = d;
        }
    }

    public void setPrezzo(double p){
        if(p>=0){
            this.prezzo = p;
        }
    }

    // Getters
    public String getNome(){
        return this.nome;
    }

    public String getDescrizione(){
        return this.descrizione;
    }

    public double getPrezzo(){
        return this.prezzo;
    }
}
