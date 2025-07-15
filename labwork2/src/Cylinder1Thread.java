import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Cylinder1Thread extends Thread {
    private Cylinder cylinder;

    private boolean interrupted = false;
    private boolean stopped = false;
    private BoxIdentificationThread boxIdentificationThread;
    private Mechanism mechanism;
    private SwitchThread switchThread;

    public Cylinder1Thread(Cylinder cylinder, BoxIdentificationThread boxIdentificationThread, Mechanism mechanism, SwitchThread switchThread) {
        this.cylinder = cylinder;
        this.boxIdentificationThread = boxIdentificationThread;
        this.mechanism = mechanism;
        this.switchThread = switchThread;
    }

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
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
                if (cylinder.boxDetected()) {
                    Main.cylinder1Semaphore.acquire();
                    int boxType = this.boxIdentificationThread.getBoxIdentification();
                    boolean Dock1Closed = this.switchThread.getDock1Closed();

                    if (boxType == 1 && !Dock1Closed) {
                        mechanism.conveyorStop();
                        while (this.cylinder.getPosition() != 1) {
                            if (!interrupted) {
                                this.cylinder.gotoPosition(1);
                            }
                        }
                        this.switchThread.setLed(1);
                        while (this.cylinder.getPosition() != 0) {
                            if (!interrupted) {
                                this.cylinder.gotoPosition(0);
                            }
                            TimeUnit.SECONDS.sleep(1);

                        }
                        mechanism.conveyorMove();

                        Main.statsManagment.addBox1();
                        Main.statsManagment.addDock1();

                    } else if (boxType == 1) {
                        this.switchThread.piscarLed(3);
                        Main.queue.add(boxType);
                        Main.statsManagment.addBox1();
                    } else {
                        Main.queue.add(boxType);
                        if (boxType == 2) {
                            Main.statsManagment.addBox2();
                        } else {
                            Main.statsManagment.addBox3();
                        }

                    }
                    TimeUnit.SECONDS.sleep(1);

                    Main.sensorSemaphore.release();
                    Main.getBox();

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

