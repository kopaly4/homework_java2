package hw1;

public class Runningtrack implements Barriers {
    private int trackLength;

    public Runningtrack(int trackLength) {
        this.trackLength = trackLength;
    }


    //    public int getTrackLength() {
//        return trackLength;
//    }
    public void action(JumpRun runner) {
        runner.runontrack();
    }
}
