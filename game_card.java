
import java.util.*;


public class Main {

    public static Integer IndexList(LinkedList lst, String str){
        for (int i = 0;i < lst.size(); i++) {
            if (str.equals(lst.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void game_card(){
        System.out.println("Input the number of cards!");

        LinkedList<String> List1=new LinkedList<String>();
        LinkedList<String> List2=new LinkedList<String>();

        Scanner scanner1 = new Scanner(System.in);

        int kol = scanner1.nextInt();
        int serch = kol;
        int index = 0;

        while (true)
        {
            index++;
            kol--;
            Scanner scanner = new Scanner(System.in);

            System.out.println("The card #" + index + ":");
            String card = scanner.nextLine();
            while(List1.contains(card)) {
                System.out.println("The card " + "\"" + card + "\"" + " already exists. Try again:");
                card = scanner.nextLine();
            }

            System.out.println("The definition of the card #" + index + ":");
            String definition = scanner.nextLine();
            while(List2.contains(definition)) {
                System.out.println("The card " + "\"" + definition + "\"" + " already exists. Try again:");
                definition = scanner.nextLine();
            }

            List1.add(card);
            List2.add(definition);

            if (kol == 2 * kol) break;
        }



        int temp = 0;
        while (true){
            serch--;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Print the definition of " + "\"" + List1.get(temp) + "\":");
            String otvet = scanner.nextLine();
            String sravn = List2.get(temp);
            if (otvet.equals(sravn)) {
                System.out.println("Correct answer!");
            }
            else if (IndexList(List2, otvet) != -1) {
                    System.out.println("Wrong answer. The correct one is "+ "\"" +List2.get(temp) +"\"" + ", you've just written the definition of "+ "\"" + List1.get(IndexList(List2, otvet)) + "\"" +".");
                }
            else {
                System.out.println("Wrong answer. The correct one is" + "\"" +List2.get(temp) +"\"" );
            }

            temp++;
            if (serch == 0) break;
        }
    }

    public static void main(String[] args) {
        game_card();

        }
}


