public class SplitterConveyor {

        static {
                System.load("C:\\STR\\SplitterConveyor\\x64\\Debug\\SplitterConveyor.dll");
        }
        static synchronized native public void initializeHardwarePorts();
        static synchronized native public void cylinder1MoveForward();
        static synchronized native public void cylinder1MoveBackward();
        static synchronized native public void cylinder1Stop();
        static synchronized native public void cylinder2MoveForward();
        static synchronized native public void cylinder2MoveBackward();
        static synchronized native public void cylinder2Stop();
        static synchronized native public void conveyorMove();
        static synchronized native public void conveyorStop();
        static synchronized native public void cylinderStartMoveForward();
        static synchronized native public void cylinderStartMoveBackward();
        static synchronized native public void cylinderStartStop();
        static synchronized native public void ledOn();
        static synchronized native public void ledOff();


        static synchronized native public int cylinderStartGetPosition();
        static synchronized native public int cylinder1GetPosition();
        static synchronized native public int cylinder2GetPosition();
        static synchronized native public int getIdentificationSensors();

        static synchronized native public boolean isBoxAtDock1();
        static synchronized native public boolean isBoxAtDock2();
        static synchronized native public boolean isDock1Closed();
        static synchronized native public boolean isDock2Closed();
        static synchronized native public boolean areDocksClosed();

}
