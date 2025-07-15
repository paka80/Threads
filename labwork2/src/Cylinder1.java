public class Cylinder1 implements Cylinder {
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
        SplitterConveyor.cylinder1MoveForward();
    }

    @Override
    public void moveBackward() {
        SplitterConveyor.cylinder1MoveBackward();
    }

    @Override
    public void stop() {
        SplitterConveyor.cylinder1Stop();
    }

    @Override
    public int getPosition() {
        return SplitterConveyor.cylinder1GetPosition();
    }

    //@Override
    //public int cylinder1GetPosition(){return SplitterConveyor.cylinder1GetPosition();}


    @Override
    public void gotoPosition(int position) {
        // Obtém a posição atual
        int current = SplitterConveyor.cylinder1GetPosition();

        // Verifica se a posição atual é válida (-1 indica posição desconhecida)
        while (current != position) {
            if(interrupted){
                SplitterConveyor.cylinder1Stop();
            } else {
                if (current == -1) {
                    // Caso a posição atual seja desconhecida, decide com base no destino
                    if (position == 0) {
                        SplitterConveyor.cylinder1MoveBackward(); // Move para trás
                    } else if (position == 1) {
                        SplitterConveyor.cylinder1MoveForward();  // Move para frente
                    }
                } else if (current < position) {
                    // Move para frente
                    SplitterConveyor.cylinder1MoveForward();
                } else {
                    // Move para trás
                    SplitterConveyor.cylinder1MoveBackward();
                }

                // Atualiza a posição atual
                current = SplitterConveyor.cylinder1GetPosition();
            }
        }

        // Quando a posição desejada é atingida, para o movimento
        SplitterConveyor.cylinder1Stop();
    }

    public boolean boxDetected() {
        return SplitterConveyor.isBoxAtDock1();
    }

}