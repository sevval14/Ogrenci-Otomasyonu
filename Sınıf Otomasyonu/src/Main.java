import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LinkedList list = new LinkedList();
        int choice=-1;
        Scanner scanner = new Scanner(System.in);
        while(choice!=0) {
            System.out.println("-----------------------*LİST*-----------------------------------");
            System.out.println("1 Show list");
            System.out.println("2 A list of students sorted by their overall average");
            System.out.println("3 List of students sorted by data structers course grades.");
            System.out.println("4 Average of the math class");
            System.out.println("5 The studen with the lowest grade in the data structure course");
            System.out.println("6 Delete student");
            System.out.println("7 Add student");
            System.out.println("8 Total number of students");
            System.out.println("9 Students passing classes");
            System.out.println("0 Exit");
            System.out.println("---------------------------------------------------------------");
            System.out.println("\nEnter your selection : ");
            choice=scanner.nextInt();

            switch (choice){
                case 1 :list.add(); break;
                case 2 :list.selectSort();break;
                case 3 :list.selectSortd();break;
                case 4 :list.matAvg();break;
                case 5 :list.mindata();break;
                case 6 :list.delete();break;
                case 7 :list.addList();break;
                case 8 :list.count();break;
                case 9 :list.pass();break;
                case 0 : System.out.println("Exit"); break;
                default: System.out.println("You made a wrong choice,try again");break;
            }

        }



    }
}
