import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int SLEEP_TIME = 2000;

    public static void main(String[] args) throws InterruptedException{

        ThreadGroup mainGroup = new ThreadGroup("main group");
        List<MyThread> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            MyThread myThread = new MyThread(String.valueOf(i + 1), mainGroup);
            list.add(myThread);
        }

        for (MyThread myThread : list) {
            myThread.start();
        }

        Thread.sleep(SLEEP_TIME);

        mainGroup.interrupt();
    }
}
