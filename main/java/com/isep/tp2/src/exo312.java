import java.util.Scanner;

public class exo312 {
    public static void parite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir un entier :");
        int entier = scanner.nextInt();
        if (entier % 2 == 0) {
            System.out.println("L'entier " + entier + " est pair.");
        } else {
            System.out.println("L'entier " + entier + " est impair.");
        }
    }

    public static void main(String[] args) {
        parite();
    }

}
