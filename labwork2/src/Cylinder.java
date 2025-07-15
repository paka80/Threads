public interface Cylinder {

    public void moveForward();
    public void moveBackward();
    public void stop();
    public int getPosition();
    public void gotoPosition(int position);
    public boolean boxDetected();
    public void setInterrupted(boolean interrupted);
    public boolean isInterrupted();
}