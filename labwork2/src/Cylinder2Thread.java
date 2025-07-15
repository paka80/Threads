import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Cylinder2Thread extends Thread {

    private Cylinder cylinder;
    private boolean interrupted = false;
    private boolean stopped = false;
    private Mechanism mechanism;
    private SwitchThread switchThread;

    public Cylinder2Thread(Cylinder cylinder, Mechanism mechanism, SwitchThread switchThread) {
        this.cylinder = cylinder;
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
                    //System.out.println("Detected box");
                    int boxType = Main.queue.remove();
                    //System.out.println("BoxType removed:" + boxType);
                    boolean Dock2Closed = this.switchThread.getDock2Closed();
                    //System.out.println("Dock2Closed" + Dock2Closed);
                    if (boxType == 2 && !Dock2Closed) {
                        // TODO: stop conveyor push box out of the conveyor
                        mechanism.conveyorStop();
                        while (this.cylinder.getPosition() != 1) {
                            if (!interrupted) {
                                this.cylinder.gotoPosition(1);
                            }
                        }
                        this.switchThread.setLed(2);
                        //mechanism.ledSwitch(1);
                        //TimeUnit.SECONDS.sleep(2);
                        //mechanism.ledSwitch(0);
                        while (this.cylinder.getPosition() != 0) {
                            if (!interrupted) {
                                this.cylinder.gotoPosition(0);
                            }
                        }
                        Main.statsManagment.addDock2();
                    } else if (boxType == 2) {
                        this.switchThread.piscarLed(3);
                    }

                    mechanism.conveyorMove();
                    //System.out.println("ConveyorMove na cylinder2Thread");
                    TimeUnit.SECONDS.sleep(1);

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

