import java.util.ArrayList;
import java.util.Scanner;

public class Bombs {
    public static String printArray(ArrayList<Integer> arr) {
        StringBuilder str = new StringBuilder();

        str.append(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {

            str.append(", " + arr.get(i));

        }
        return str.toString();
    }

    public static void fillArray(String input, ArrayList<Integer> arr) {
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == ',') {
                arr.add(Integer.parseInt(number.toString()));
                number.setLength(0);
            } else if (input.charAt(i) != ' ') {
                number.append(input.charAt(i));
            }

        }
        arr.add(Integer.parseInt(number.toString()));
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Integer> effects = new ArrayList<>();
        ArrayList<Integer> casings = new ArrayList<>();

        int DaturaBombs = 0;// costs 40 points
        int CherryBombs = 0;// costs 60 points
        int SmokeDecoyBombs = 0;// costs 120 points

        String effectsInput = in.nextLine();
        String casingsInput = in.nextLine();

        fillArray(effectsInput, effects);
        fillArray(casingsInput, casings);

        int B = Math.min(effects.size(), casings.size()); // here I will assign the amount of bombs we have material for

        while (B != 0 && effects.size() != 0 && casings.size() != 0) {

            int sum = effects.get(0) + casings.get(casings.size() - 1);

            switch (sum) {
                case 40: {
                    DaturaBombs++;
                    effects.remove(0);
                    casings.remove(casings.size() - 1);
                    B--;
                    break;
                }
                case 60: {
                    CherryBombs++;
                    effects.remove(0);
                    casings.remove(casings.size() - 1);
                    B--;
                    break;
                }
                case 120: {
                    SmokeDecoyBombs++;
                    effects.remove(0);
                    casings.remove(casings.size() - 1);
                    B--;
                    break;
                }
                default: {
                    casings.set(casings.size() - 1, casings.get(casings.size() - 1) - 5);
                    break;
                }
            }
            if (DaturaBombs >= 3 && SmokeDecoyBombs >= 3 && CherryBombs >= 3) {
                break;
            }
        }

        if (DaturaBombs >= 3 && CherryBombs >= 3 && SmokeDecoyBombs >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
            System.out.println("Bomb Effects: " + (effects.isEmpty() ? "empty" : printArray(effects)));
            System.out.println("Bomb Casings: " + (casings.isEmpty() ? "empty" : printArray(casings)));
            System.out.println("Cherry Bombs: " + CherryBombs);
            System.out.println("Datura Bombs: " + DaturaBombs);
            System.out.println("Smoke Decoy Bombs: " + SmokeDecoyBombs);
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
            System.out.println("Bomb Effects: " + (effects.isEmpty() ? "empty" : printArray(effects)));
            System.out.println("Bomb Casings: " + (casings.isEmpty() ? "empty" : printArray(casings)));
            System.out.println("Cherry Bombs: " + CherryBombs);
            System.out.println("Datura Bombs: " + DaturaBombs);
            System.out.println("Smoke Decoy Bombs: " + SmokeDecoyBombs);
        }

    }
}
