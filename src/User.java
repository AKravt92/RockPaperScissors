import java.util.Scanner;

public class User {
    int choiceUser;

    public static void printMenuUser(String[] args){
        System.out.println("Available moves:");
        for(int i = 0;i< args.length;i++){
            System.out.println(i+1 + ". " + args[i]);
        }
        System.out.println(args.length+1 + ". " + "Exit");
    }
    public static int getChooseUser(String[] args){
        int i;
        System.out.print("Enter your move: ");
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        if (i == args.length+1) {
            System.out.println("Good bye!");
            System.exit(0);
        }
        if(i>0 && i<=args.length){
            System.out.println("Your move:     " + i + " " + args[i-1]);
            return i-1;}
        else
            while (i > args.length + 1 || i < 1) {
                System.out.print("Enter your move: ");
                scanner = new Scanner(System.in);
                i = scanner.nextInt();
                if (i == args.length+1) {
                    System.out.println("Good bye!");
                    System.exit(0);
                }
                else if (i > 0 && i <= args.length){
                    System.out.println("Your move:     " + i + " " + args[i-1]);
                }
            }
        return i-1;
    }
}
