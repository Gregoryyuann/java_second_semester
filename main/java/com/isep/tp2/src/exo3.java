import java.util.Scanner;

public class exo3 {
    public static void discriminant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est la valeur de a ?");
        int a = scanner.nextInt();
        System.out.println("Quelle est la valeur de b ?");
        int b = scanner.nextInt();
        System.out.println("Quelle est la valeur de c ?");
        int c = scanner.nextInt();

        int delta = (int) (Math.pow(b, 2) - 4 * a * c);

        if (delta < 0) {  System.out.println("Ce polynome n’a pas de racine reelle");

        }
        else if (delta == 0) {
            double x = -b / (2.0 * a);
            System.out.println("Le polynome a une racine double : " + x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
            System.out.println("Le polynome a deux racines distinctes : " + x1 + " et " + x2);
        }
    }

    public static void main(String[] args) {
        discriminant();
    }

}
