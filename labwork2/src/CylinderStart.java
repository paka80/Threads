public class CylinderStart implements Cylinder {
    private boolean interrupted = false;
    private BoxIdentificationThread boxIdentificationThread;

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
        //if (interrupted)
        //  SplitterConveyor.cylinderStartStop();

    }

    @Override
    public void moveForward() {
        SplitterConveyor.cylinderStartMoveForward();
    }

    @Override
    public void moveBackward() {
        SplitterConveyor.cylinderStartMoveBackward();
    }

    @Override
    public void stop() {
        SplitterConveyor.cylinderStartStop();
    }

    @Override
    public int getPosition() {
        return SplitterConveyor.cylinderStartGetPosition();
    }

    //@Override
    //public int cylinderStartGetPosition(){return SplitterConveyor.cylinderStartGetPosition();}

    @Override
    public void gotoPosition(int position) {

        // Obtém a posição atual
        int current = SplitterConveyor.cylinderStartGetPosition();

        // Verifica se a posição atual é válida (-1 indica posição desconhecida)
        while (current != position) {
            if(interrupted){
                SplitterConveyor.cylinderStartStop();
            } else {
                if (current == -1) {
                    // Caso a posição atual seja desconhecida, decide com base no destino
                    if (position == 0) {
                        SplitterConveyor.cylinderStartMoveBackward(); // Move para trás
                    } else if (position == 1) {
                        SplitterConveyor.cylinderStartMoveForward();  // Move para frente
                    }
                } else if (current < position) {
                    // Move para frente
                    SplitterConveyor.cylinderStartMoveForward();
                } else {
                    // Move para trás
                    SplitterConveyor.cylinderStartMoveBackward();
                }

                // Atualiza a posição atual
                current = SplitterConveyor.cylinderStartGetPosition();
            }


        }

        SplitterConveyor.cylinderStartStop();

        // Quando a posição desejada é atingida, para o movimento

    }

    @Override
    public boolean boxDetected() {
        return false;
    }

}