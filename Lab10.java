import java.util.Random;
import java.util.Scanner;
//Comment for Computer Science Centre
public class Lab10 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        scan.close();
    }

    public static void Q1() {
        while (true) {
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) {
                return;
            }
            double a, b, r;
            switch(input) {
                case "square" :
                    System.out.println("Enter the length of side a: ");
                    a = Double.parseDouble(scan.nextLine());
                    System.out.println("The perimeter of the square is: " + a * 4);
                    System.out.println("The area of the square is: " + a * a);
                    break;

                case "rectangle" :
                    System.out.println("Enter the length of side a: ");
                    a = Double.parseDouble(scan.nextLine());
                    System.out.println("Enter the length of side b: ");
                    b = Double.parseDouble(scan.nextLine());
                    System.out.println("The perimeter of the rectangle is: " + (2 * a + 2 * b));
                    System.out.println("The area of the rectangle is: " + (a * b));
                    break;
                case "circle" :
                    System.out.println("Enter the radius: ");
                    r = Double.parseDouble(scan.nextLine());
                    System.out.println("The circumference of the circle is: " + (Math.PI * r * 2));
                    System.out.println("The area of the circle is: " + (Math.PI * r * r));
                    break;
                default:
                    break;
            }
        }
    }

    public static void Q2() {
        System.out.println("Q2: Enter the current day (1-31): ");
        String temp = "";
        int num = Integer.parseInt(scan.nextLine());
        if(num>1 && num <31)
        {
            if(num%10 == 1)
            {
                temp = temp + num + "st";
            }else if(num%10 == 2){
                temp = temp + num + "nd";
            }else if(num%10 == 3){
                temp = temp + num + "rd";
            }else{
                temp = temp + num + "th";
            }
        }else{
            System.out.println("Invalid Day");
            return;
            //break;
        }
        //System.out.println()
        System.out.println("Enter the current month: (1-12)");
        int num2 = Integer.parseInt(scan.nextLine());
        String[] months = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if(num2<0 || num > 12)
        {
            System.out.println("Invalid month");
            return;
        }
        System.out.println("You selected " + temp + " of " + months[num2-1]);

    }

public static void Q3() {
    System.out.println("Q3: Enter how many numbers you want to check for primality: ");
    int n = Integer.parseInt(scan.nextLine());
    int counter = 0;
    boolean check = false;
    for (int i = n; i > 2; i--) {
        for (int j = 2; j < i; j++) {
            if(n%j == 0){
                check = true;
            }
            if(check == true){
                counter++;
            }
        }
        
        // if (i < 2){
        //     //continue;
        //     check = true;

        //     for (int j = 2; j * j <= i; j++) {
        //     if (i % j == 0) {
        //         check = false;
        //         break;     
        //     }
        //     if (check == true) {
        //     counter++;
        //     }
        //     }   
        // }
    }
    counter+=2;
    System.out.println("There are: " + counter + " primes between 0 and " + n);
}

    public static void Q4() {
        Random rng = new Random();

        String next;
        System.out.println("Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack. Kill the enemy to win!");
        System.out.println("Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
        System.out.println("Q4: Your damage is 2-16 (2d8)");

        int enemyHP = 100;
        int a = 0;

        boolean check = false;
        while (true) {

            boolean doAttack = false;
            boolean check2 = false;
            while (!check2) {
                next = scan.nextLine();
                check2 = true;
                switch (next.toUpperCase()) {
                    case "A":
                        doAttack = true;
                        break;
                    case "B":
                        check = true;
                        System.out.println("Buffing! +5 to your next attack roll and damage");
                        break;
                    default:
                        System.out.println("Invalid input");
                        check2 = false;
                }
            }

            if (doAttack) {
                a++;
                int attackRoll = rng.nextInt(20) + 1;
                int damage = 0;
                System.out.print("You rolled: " + attackRoll);
                if(check) {
                    attackRoll += 5;
                    System.out.print(" + 5 (buff active)\n");
                } else {
                    System.out.println();
                }
                if (attackRoll >= 12) {
                    damage = rng.nextInt(8) + 1;
                    damage += rng.nextInt(8) + 1;
                    if(check) {
                        damage += 5;
                    }
                    if (attackRoll == 20 || (check && attackRoll == 20 + 5)) {
                        damage *= 2;
                        System.out.print("Critical hit! ");
                    }
                    System.out.print("You dealt " + damage + " damage");
                    if(check) {
                        System.out.print(" (buffed attack)");
                    }
                    enemyHP -= damage;
                    System.out.println("\nEnemy HP: " + Math.max(0, enemyHP));

                } else {
                    System.out.println("Miss");
                }

                check = false;
                if (enemyHP <= 0) {
                    System.out.println("Enemy died in " + a + " turns");
                    scan.close();
                    return;
                }
            }

        }
    }
}
