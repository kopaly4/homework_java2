package hw1;

public class Wall implements Barriers {
    private int wallheight;

    public Wall(int wallheight) {
        this.wallheight = wallheight;
    }

    //    public void jumpthruthewall(JumpRun jumper) {
////        if(jumper.getJumpability() < wallheight){
////            System.out.println(jumper.getName() + " can`t jump that height");
////        } else jumper.jumpthroughthewall();
//        jumper.jumpthroughthewall();
//    }
//
//    public int getWallheight() {
//        return wallheight;
    public void action(JumpRun jumper) {
        jumper.jumpthroughthewall();
    }

}
