import java.util.Scanner;
public class exo52 {
    public static void division() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le dividende");
        int dividende = scanner.nextInt();
        System.out.println("Veuillez saisir le diviseur");
        int diviseur = scanner.nextInt();
        if (diviseur == 0) {
            System.out.println("Erreur : le diviseur ne peut pas être zéro !");
        } else {
            double resultat = (double) dividende / diviseur;
            System.out.println("Le resultat de la division de " + dividende + " par " + diviseur + " est égal à " + resultat);
        }
    }

    public static void main(String[] args) {
        division();
    }
}
