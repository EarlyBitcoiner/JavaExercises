import java.util.ArrayList;
import java.util.Scanner;

public class MainLB {
    public static void AssignList(String str, ArrayList<Integer> arr) {
        int lenght = str.length();
        String number = new String();

        for (int i = 0; i < lenght; i++) {

            if (str.charAt(i) != ' ') {
                number += str.charAt(i);
            } else {
                arr.add(Integer.parseInt(number));
                number = "";
            }

            if (i == lenght - 1) {
                arr.add(Integer.parseInt(number));
            }
        }
    }

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        ArrayList<Integer> LootBox1 = new ArrayList<>();
        ArrayList<Integer> LootBox2 = new ArrayList<>();

        String str = cin.nextLine();
        AssignList(str, LootBox1);

        str = cin.nextLine();
        AssignList(str, LootBox2);

        int sum= 0;

        while(LootBox1.size()!=0 && LootBox2.size()!=0){

            int sumOfTwo = LootBox1.get(0) + LootBox2.get(LootBox2.size()-1);

            if(sumOfTwo%2==1){
                LootBox1.add(LootBox2.get(LootBox2.size()-1));
                LootBox2.remove(LootBox2.size()-1);
            }else{
                sum += sumOfTwo;
                LootBox1.remove(0);
                LootBox2.remove(LootBox2.size()-1);
            }
        }

        if(LootBox2.size()==0){
            System.out.println("Second lootbox is empty");
            if(sum >=100)
                System.out.println("Your loot was epic! Value: " + sum);
            else
                System.out.println("Your loot was poor... Value: " + sum);
        }else{
            System.out.println("First lootbox is empty");
            if(sum >=100)
                System.out.println("Your loot was epic! Value: " + sum);
            else
                System.out.println("Your loot was poor... Value: " + sum);
        }

    }

}

