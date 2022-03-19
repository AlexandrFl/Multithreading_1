public class MyThread extends Thread {

    private final int SLEEP_TIME = 500;

    public MyThread(String name, ThreadGroup group) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!isInterrupted()) {
                    Thread.sleep(SLEEP_TIME);
                    System.out.println("Привет я поток № " + getName());
                } else {
                    System.out.println("Поток № " + getName() + " завершил работу");
                    return;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("⚠ Поток " + getName() + " получил метку на завершение во время сна ⚠");
        } finally {
            System.out.println("Поток № " + getName() + " завершил работу");
        }
    }
}
