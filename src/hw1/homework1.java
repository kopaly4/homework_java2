package hw1;

public class homework1 {
    public static void main(String[] args) {
        JumpRun[] jumpRunners = {
                new Cat("Barsik",50,0),
                new Cat("Boris", 60, 50),
                new Human("Pavel", 10, 500),
                new Human("Danila", 15, 1000),
                new Robot("Bender", 24, 0),
                new Robot ("Fry", 30, 100),
        };
        Barriers[] barriers = {
                new Wall(30),
                new Wall(15),
                new Runningtrack(100),
                new Runningtrack(1000),
        };
        for (int i = 0; i < jumpRunners.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                barriers[j].action(jumpRunners[i]);
            }

        }
    }
}
