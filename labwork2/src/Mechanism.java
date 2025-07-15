public class Mechanism {


    public void conveyorMove(){
        SplitterConveyor.conveyorMove();
    }
    public void conveyorStop(){
        //System.out.println("Conveyor stopped");
        SplitterConveyor.conveyorStop();
    }
    public int identificationSensor(){return SplitterConveyor.getIdentificationSensors();}


    public boolean isDock1Closed(){
        return SplitterConveyor.isDock1Closed();
    }

    public boolean isDock2Closed (){
        return SplitterConveyor.isDock2Closed();
    }

    public boolean areDocksClosed(){
        return SplitterConveyor.areDocksClosed();
    }
    public void ledSwitch(int on){
        if (on == 1)
        {
            SplitterConveyor.ledOn();
        }
        else
        {
            SplitterConveyor.ledOff();
        }
    }
}