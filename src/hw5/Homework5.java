package hw5;


public class Homework5 {
    static final int SIZE = 10;
    static final int HALF = SIZE / 2;

    public static void method1() {
        float arr[] = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("1 method time: " + (System.currentTimeMillis() - a) + "ms");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println("");

    }

    public static void method2() {
        float initarr[] = new float[SIZE];
        float mergedarr[] = new float[SIZE];
        float arr1[] = new float[HALF];
        float arr2[] = new float[HALF];
        for (int i = 0; i < initarr.length; i++) {
            initarr[i] = 1.0f;
        }
        long timecounter = System.currentTimeMillis();
        System.arraycopy(initarr, 0, arr1, 0, HALF);
        System.arraycopy(initarr, HALF, arr2, 0, HALF);
        Object mon1 = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (mon1) {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//                        System.out.println("arr1[" + i + "] = " + arr1[i]);
                }
            }
        });
        Object mon2 = new Object();
        Thread thread2 = new Thread(() -> {
            synchronized (mon2) {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
//                        System.out.println("arr2[" + i + "] = " + arr2[i]);
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, mergedarr, 0, HALF);
        System.arraycopy(arr2, 0, mergedarr, HALF, HALF);
        System.out.println("2 method time: " + (System.currentTimeMillis() - timecounter) + "ms");
//        for (int i = 0; i < mergedarr.length; i++) {
//            System.out.println("mergedarr[ " + i + "] =" + mergedarr[i]);
//        }
    }


    public static void main(String[] args) {
        method1();
        method2();

    }
}
