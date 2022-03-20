import java.util.concurrent.Callable;
public class MyCallable implements Callable<String> {


    private int count;

    public MyCallable(int count) {
        this.count = count;
    }

    @Override
    public String call() {
        Integer count = 0;
        int i = 0;
        try {
            while (i < this.count) {
                Thread.sleep(500);
                System.out.println("Поток (" + Thread.currentThread().getName() + ") выполняется");
                i++;
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("Поток (" + Thread.currentThread().getName() + ") получил метку на завершение во время сна");
        } finally {
            System.out.println("Поток № (" + Thread.currentThread().getName() + ") завершил работу");
        }
        return "✔ За время работы поток (" + Thread.currentThread().getName() + ") вывел на экран " + count + " раз ✔";
    }
}
