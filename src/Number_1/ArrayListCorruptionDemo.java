package Number_1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCorruptionDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });

        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                if (!list.isEmpty()) {
                    list.remove(0);
                }
            }
        });

        addThread.start();
        removeThread.start();

        addThread.join();
        removeThread.join();

        System.out.println("Final list size: " + list.size());
        System.out.println("Final list contents: " + list);
    }
}
