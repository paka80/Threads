import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class BoxIdentificationThread extends Thread {
    private int brickType = -1;
    private Mechanism mechanism;
    private boolean interrupted = false;
    private boolean stopped = false;
    private Semaphore sensorSemaphore;

    public BoxIdentificationThread(Mechanism mechanism, Semaphore sensorSemaphore) {
        this.mechanism = mechanism;
        this.sensorSemaphore = sensorSemaphore;
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


    public synchronized int getBoxIdentification() {
        return brickType;
    }

    public synchronized void startBoxIdentification() throws InterruptedException {
        boolean dot1 = false;
        boolean dot2 = false;
        while (!SplitterConveyor.isBoxAtDock1()) {
            if (!interrupted) {
                if (mechanism.identificationSensor() == 1) {
                    dot1 = true;
                } else if (mechanism.identificationSensor() == 2) {
                    dot2 = true;
                }
            }

        }

        if (dot1 && dot2) {
            brickType = 3;
        } else if (dot1 || dot2) {
            brickType = 2;
        } else {
            brickType = 1;
        }
        //System.out.println("Brick Type: " + brickType);
        synchronized (this) {
            Main.cylinder1Semaphore.release();
        }

    }

    public void run() {
        try {
            while (!stopped) {
                if (!interrupted) {
                    sensorSemaphore.acquire();
                    this.startBoxIdentification();
                }
            }
            //this.boxDetected();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
