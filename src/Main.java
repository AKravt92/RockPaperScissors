import java.security.NoSuchAlgorithmException;

public class Main {

    public static boolean argsIsCorrect(String[] args){
        int count = 0;
        for(int i = 0;i< args.length;i++){
            for (int j = i+1;j< args.length;j++){
                if (args[i].equals(args[j])) count++;
            }
        }
        return count == 0 && args.length >=3 && args.length%2 == 1;
    }
    public static void startGame(int choicePlayer,int choiceComputer,String[] args){
        int r = choicePlayer - choiceComputer;
        if (r == 0){
            System.out.println("Draw!");
        }
        else if (r>0) {
            if ((r % args.length) <= (args.length-1)/2) {
                System.out.println("You lose!");
            } else System.out.println("You win!");
        }
        else {
            r = r + args.length;
            if ((r % args.length) <= (args.length-1)/2) {
                System.out.println("You lose!");
            } else System.out.println("You win!");
        }


    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        if(argsIsCorrect(args)){
            HMAC hmac = new HMAC();
            hmac.key = HMAC.keyGenerate();
            Computer computer = new Computer();
            computer.choiceComputer = Computer.generateChooseComputer(args);
            hmac.hmac = HMAC.hmacGenerate(hmac.key,args[computer.choiceComputer].getBytes());
            hmac.printHMAC(hmac.hmac);
            User user = new User();
            User.printMenuUser(args);
            user.choiceUser = User.getChooseUser(args);
            Computer.printChoiceComputer(computer,args);
            startGame(user.choiceUser, computer.choiceComputer, args);
            hmac.printKey(hmac.key);
        }
        else System.out.println("Error: incorrect parameters");
    }
}
