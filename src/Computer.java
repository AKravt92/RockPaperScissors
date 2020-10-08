import java.security.SecureRandom;

public class Computer {
    int choiceComputer;

    public static int generateChooseComputer(String[] args){
        SecureRandom random = new SecureRandom();
        return random.nextInt(args.length);
    }
    public static void printChoiceComputer(Computer computer,String[] args){
        System.out.println("Computer move: " + (computer.choiceComputer+1) + " " + args[computer.choiceComputer]);
    }
}
