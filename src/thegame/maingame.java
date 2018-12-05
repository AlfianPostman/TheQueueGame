package thegame;

import java.util.Scanner;

public class maingame {

    static Scanner sc = new Scanner(System.in);
    static LinkedList ll = new LinkedList();
    static int choose, namba;
    static boolean isRunning = true;
    static int people [] = { 18, 12, 21, 33, 41, 11 };
    static int lyfe = 2;
    static int asd = 0;

    public static void main(String[] args) {
        input();
        while (isRunning == true && lyfe > 0)
        {
            System.out.println("1. Next");
            System.out.println("2. Pass");
            System.out.println("3. Leave");
            System.out.print("Choose one : ");

            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    Print();
                    break;
                case 2:
                    ll.qpop();
                    if (people[asd] > 17) {               
                        lyfe--;
                        asd++;
                    }
                    break;
                case 3:
                    ll.qpop();
                    if (people[asd] < 17) {               
                        lyfe--;
                        asd++;
                    }
                    break;
                default:
                    System.out.println("input tidak valid");
                    break;
            }
        }
    }

    static void input()
    {
        for (int i = 0; i < people.length; i++)
        {
            ll.push(new LinkedListNode(people[i]));
        }
    }



    static void Print(){
        ll.print();
    }
}
