import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tp {

        public static ArrayList<String> listeNom = new ArrayList<>();

    public static void main(String[] args) {

        Boolean continuer = true;
        Scanner sc = new Scanner(System.in);

        while (continuer) {
            System.out.println("1. Ajoutez le nom");
            System.out.println("2. supprimer le nom");
            System.out.println("3. rechercher le nom");
            System.out.println("4. sauvegarder le nom");
            System.out.println("5. charger le nom");
            System.out.println("6. afficher le nom");
            System.out.println("7.  quitter");


//            Menu

            System.out.println("Selectionner votre action : ");
            int choix = sc.nextInt();
            String nom;

            switch (choix) {
                case 1:
                    System.out.println("Vous avez choisi ajouter le nom ");
                     nom = sc.next();
                    ajouterNom(nom);
                    break;
                case 2:
                    System.out.println("Vous avez choisi supprimer le nom ");
                     nom = sc.next();
                     supprimerNom(nom);
                    break;
                case 3:
                    System.out.println("Vous avez choisi rechercher le nom ");
                    nom = sc.next();
                    rechercherNom(nom);

                    break;
                case 4:
                    System.out.println("Vous avez choisi de sauvegarder le nom ");
                    nom = sc.next();
                    sauvegarderListe();
                    break;
                case 5:
                    System.out.println("Vous avez choisi de charger le nom ");
                    chargerListe();
                    break;
                case 6:
                    System.out.println("Vous avez choisi d'afficher le nom ");
                    afficherNom();
                    break;
                case 7:
                    System.out.println("Vous avez choisi de quitter ");
                    continuer = false;
                    break;
            }
        }

//        Fonctions

    }
    public static void ajouterNom(String nom){
        listeNom.add(nom);
    };


    public static void supprimerNom(String nom){
        if (listeNom.contains(nom)) {
            listeNom.remove(nom);
            System.out.println("Nom supprimé : " + nom);
        } else {
            System.out.println("Echec suppression");
        }
    }
    ;

    public static Boolean rechercherNom(String nom){
        return listeNom.contains(nom);
    }
    ;
    public static void afficherNom(){
        System.out.println("Liste des noms: ");
        for (String nom : listeNom) {
            System.out.println(nom);
        }
    }
    ;
    public static void sauvegarderListe(){
        try {
            FileWriter writer = new FileWriter("C:\\workspace\\EvalJava\\src\\Tpj.txt");
            BufferedWriter bw = new BufferedWriter(writer);

            for (String nom : listeNom){
                bw.write(nom);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("erreur " + e.getMessage());

        }
    }
    ;
    public static void chargerListe(){
        try {
            FileReader reader = new FileReader("C:\\workspace\\EvalJava\\src\\Tpj.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;

            listeNom.clear();
            while ((line = br.readLine()) !=null) {
                listeNom.add(line);
            }

        } catch (IOException e) {
            System.out.println("erreur");
            e.printStackTrace();
        }
    }
    ;
}
