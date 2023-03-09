import java.util.Scanner;

public class exo313 {
    public static void max() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un premier entier : ");
        int premierEntier = scanner.nextInt();
        System.out.println("Entrez un deuxième entier : ");
        int deuxiemeEntier = scanner.nextInt();
        int maximum = Math.max(premierEntier, deuxiemeEntier);
        System.out.println("Le maximum entre " + premierEntier + " et " + deuxiemeEntier + " est : " + maximum);
    }

    public static void min() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un premier entier : ");
        int premierEntier = scanner.nextInt();
        System.out.println("Entrez un deuxième entier : ");
        int deuxiemeEntier = scanner.nextInt();
        int minimum = Math.min(premierEntier, deuxiemeEntier);
        System.out.println("Le minimum entre " + premierEntier + " et " + deuxiemeEntier + " est : " + minimum);
    }

    public static void main(String[] args) {
        min();
        max();
    }


}
