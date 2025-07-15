//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Semaphore loaderSemaphore = new Semaphore(0);
    public static Semaphore sensorSemaphore = new Semaphore(1);
    public static Semaphore cylinder1Semaphore = new Semaphore(1);

    public static StatsManagment statsManagment = new StatsManagment();
    public static CylinderStart clStart = new CylinderStart();
    public static CylinderStartThread clStartT = new CylinderStartThread(clStart, loaderSemaphore);

    public static Mechanism mechanism = new Mechanism();
    public static SwitchThread switchThread = new SwitchThread(mechanism);

    public static BoxIdentificationThread boxIDT = new BoxIdentificationThread(mechanism, sensorSemaphore);

    public static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();


    public static void main(String[] args) throws InterruptedException {
        SplitterConveyor.initializeHardwarePorts();

        Cylinder1 cl1 = new Cylinder1();
        Cylinder1Thread cl1T = new Cylinder1Thread(cl1, boxIDT, mechanism, switchThread);

        Cylinder2 cl2 = new Cylinder2();
        Cylinder2Thread cl2T = new Cylinder2Thread(cl2, mechanism, switchThread);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Starting identification process...\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Press 'S' to start the cycle");
        label:
        while (true) {

            if (scanner.hasNextLine()) { // Checa se o usuário inseriu algo
                String input = scanner.nextLine().trim().toUpperCase();
                switch (input) {
                    case "S":
                        System.out.println("Starting cycle...");
                        System.out.println("At any time, press 'P' to put a box in the conveyor, 'C' for stats, 'D' for docks state, 'I' for interrupt, 'R' to resume and 'F' to terminate.\n");
                        mechanism.conveyorMove();
                        //System.out.println("ConveyorMove no S");// Inicia o conveyor
                        boxIDT.start();
                        clStartT.start();
                        switchThread.start();
                        cl1T.start();
                        cl2T.start();
                        break;
                    case "P":
                        getBox();
                        break;
                    case "R":
                        System.out.println("Restarting process...");
                        mechanism.conveyorMove();
                        //System.out.println("ConveyorMove no S");// Inicia o conveyor
                        cl1T.setInterrupted(false);
                        cl2T.setInterrupted(false);
                        switchThread.setInterrupted(false);
                        clStartT.setInterrupted(false);
                        boxIDT.setInterrupted(false);
                        break;
                    case "I":
                        System.out.println("Interrupting process...");
                        mechanism.conveyorStop();
                        cl1T.setInterrupted(true);
                        cl2T.setInterrupted(true);
                        switchThread.setInterrupted(true);
                        clStartT.setInterrupted(true);
                        boxIDT.setInterrupted(true);
                        break;
                    case "F":
                        System.out.println("Terminating process...");
                        mechanism.conveyorStop();
                        cl1T.setStopped(true);
                        cl2T.setStopped(true);
                        switchThread.setStopped(true);
                        clStartT.setStopped(true);
                        boxIDT.setStopped(true);
                        break label; // Sai do loop e termina o programa
                    case "D":
                        switchThread.checkDocsState();
                        break;
                    case "C":
                        statsManagment.printStats();
                        break;
                    default:
                        System.out.println("Invalid input.");
                        break;
                }

            }
        }
        scanner.close();
    }
    public static void getBox() throws InterruptedException {
        //System.out.println("Starting CylinderStart...");
        loaderSemaphore.release();
         // Inicia o CylinderStart

    }
}
