import java.util.Scanner;

public class TestDemo {

    public static void main(String[] args) {
        int t=-1;
        SplitterConveyor.initializeHardwarePorts();
        Cylinder1 cylinder1 = new Cylinder1();
        Cylinder2 cylinder2 = new Cylinder2();

        while(t!=0){
            System.out.println("Enter an option: ");
            Scanner sc = new Scanner(System.in);
            t=sc.nextInt();
            switch(t){
                case 1: cylinder1.moveBackward(); break;
                case 2: cylinder1.moveForward(); break;
                case 3: cylinder1.stop(); break;
                case 4: cylinder2.moveBackward(); break;
                case 5: cylinder2.moveForward(); break;
                case 6: cylinder2.stop(); break;

            }
        }
    }
}