import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CylinderStartThread extends Thread {
    private Cylinder cylinder;
    private Semaphore semaphore;
    private boolean interrupted = false;
    private boolean stopped = false;

    public CylinderStartThread(Cylinder cylinder, Semaphore semaphore) {
        this.cylinder = cylinder;
        this.semaphore = semaphore;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) throws InterruptedException {
        this.interrupted = interrupted;
        this.cylinder.setInterrupted(interrupted);

    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void initializeCylinderThread() throws InterruptedException {
        //if calibrated
        while (!stopped) {
            if (!interrupted) {
                Main.loaderSemaphore.acquire();

                while (this.cylinder.getPosition() != 1) {
                    this.cylinder.gotoPosition(1);
                }

                while (this.cylinder.getPosition() != 0) {
                    this.cylinder.gotoPosition(0);
                }
            }
        }
    }

    public void run() {
        try {
            this.initializeCylinderThread();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

