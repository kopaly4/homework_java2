package hw1;

public class Robot implements JumpRun {
    private String name;
    private int jumpability;
    private int runability;

    public Robot(String name, int jumpability, int runability) {
        this.name = name;
        this.jumpability = jumpability;
        this.runability = runability;
    }

    @Override
    public void run() {
        System.out.println(name + "has run");

    }

    @Override
    public void jump() {
        System.out.println(name + "can`t jump");

    }

    @Override
    public void jumpthroughthewall() {
        System.out.println(name + " can`t jump through the wall");

    }

    @Override
    public void runontrack() {
        System.out.println(name + " can`t run on the running track");
    }

    public String getName() {
        return name;
    }

    public int getJumpability() {
        return jumpability;
    }

    public int getRunability() {
        return runability;
    }
}
