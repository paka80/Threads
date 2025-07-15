public class Cylinder2 implements Cylinder {
    private boolean interrupted = false;

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
        System.out.println("Cylinder interrupted -----------------" + this.interrupted);
        //if (interrupted)
        //  SplitterConveyor.cylinderStartStop();

    }


    @Override
    public void moveForward() {
        SplitterConveyor.cylinder2MoveForward();
    }

    @Override
    public void moveBackward() {
        SplitterConveyor.cylinder2MoveBackward();
    }

    @Override
    public void stop() {
        SplitterConveyor.cylinder2Stop();
    }

    @Override
    public int getPosition() {
        return SplitterConveyor.cylinder2GetPosition();
    }

    //@Override
    //public int cylinder2GetPosition(){return SplitterConveyor.cylinder2GetPosition();}

    @Override
    public void gotoPosition(int position) {
        // Obtém a posição atual
        int current = SplitterConveyor.cylinder2GetPosition();

        // Verifica se a posição atual é válida (-1 indica posição desconhecida)
        while (current != position) {
            if (interrupted) {
                SplitterConveyor.cylinder2Stop();
            } else {
                if (current == -1) {
                    // Caso a posição atual seja desconhecida, decide com base no destino
                    if (position == 0) {
                        SplitterConveyor.cylinder2MoveBackward(); // Move para trás
                    } else if (position == 1) {
                        SplitterConveyor.cylinder2MoveForward();  // Move para frente
                    }
                } else if (current < position) {
                    // Move para frente
                    SplitterConveyor.cylinder2MoveForward();
                } else {
                    // Move para trás
                    SplitterConveyor.cylinder2MoveBackward();
                }

                // Atualiza a posição atual
                current = SplitterConveyor.cylinder2GetPosition();
            }


        }

        // Quando a posição desejada é atingida, para o movimento
        SplitterConveyor.cylinder2Stop();
    }

    @Override
    public boolean boxDetected() {
        return SplitterConveyor.isBoxAtDock2();
    }


}