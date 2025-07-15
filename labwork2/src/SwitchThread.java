import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SwitchThread extends Thread {

    public boolean Dock1Closed = false;
    public boolean Dock2Closed = false;
    public boolean DocksClosed = false;
    private boolean interrupted = false;
    private boolean stopped = false;
    private Mechanism mechanism;

    public void checkDocsState() {
        System.out.println("O estado das docks é:");
        System.out.println("Dock 1: " + (Dock1Closed ? "fechada" : "aberta"));
        System.out.println("Dock 2: " + (Dock2Closed ? "fechada" : "aberta"));
        System.out.println("Dock End: " + (DocksClosed ? "fechado" : "aberto"));

    }
    public SwitchThread(Mechanism mechanism) {
        this.mechanism = mechanism;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isStopped() {
        return stopped;
    }

    public boolean getDock1Closed (){
        return Dock1Closed;
    }

    public boolean getDock2Closed (){
        return Dock2Closed;
    }

    public boolean getDocksClosed(){
        return DocksClosed;
    }
    public void setLed(int on) {
        new Thread(() -> {
            try {
               // System.out.println("Chegou ao LED");
                mechanism.ledSwitch(1); // Acende o LED
                TimeUnit.SECONDS.sleep(on); // Mantém ligado por `on` segundos
                mechanism.ledSwitch(0); // Apaga o LED
            } catch (InterruptedException e) {
                System.err.println("LED thread interrupted: " + e.getMessage());
            }
        }).start();
    }

    public void piscarLed(int tempo) {
        new Thread(() -> {
            try {
                long startTime = System.currentTimeMillis(); // Marca o tempo inicial
                long tempoMillis = tempo * 1000L; // Converte `tempo` de segundos para milissegundos
                long currentTime;
                do {
                    mechanism.ledSwitch(1); // Acende o LED
                    TimeUnit.MILLISECONDS.sleep(400); // Mantém ligado por 400 ms

                    mechanism.ledSwitch(0); // Apaga o LED
                    TimeUnit.MILLISECONDS.sleep(400);

                    currentTime = System.currentTimeMillis();
                } while (currentTime - startTime < tempoMillis);
            } catch (InterruptedException e) {
                System.err.println("LED thread interrupted: " + e.getMessage());
            }
        }).start();
    }

    public synchronized void startSwitchIdentification() throws InterruptedException {

        while (!stopped) {
            if(!interrupted) {
                if(mechanism.isDock1Closed()){
                    Dock1Closed = !Dock1Closed;
                    TimeUnit.SECONDS.sleep(1);
                }
                if(mechanism.isDock2Closed()){
                    Dock2Closed = !Dock2Closed;
                    TimeUnit.SECONDS.sleep(1);
                }
                if(mechanism.areDocksClosed()){
                    Dock1Closed = true;
                    Dock2Closed = true;
                    DocksClosed = true;
                    piscarLed(10);
                    TimeUnit.SECONDS.sleep(10);
                    Dock1Closed = false;
                    Dock2Closed = false;
                    DocksClosed = false;
                }
            }
        }

    }

    public void run() {
        try {
            this.startSwitchIdentification();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

