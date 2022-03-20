import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static final int SLEEP_TIME = 5000;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<MyCallable> list = new ArrayList<>();

//      Создание задач и добавление аргументов для их решения
        for (int i = 0; i < 4; i++) {
            MyCallable myCallable = new MyCallable((i + 1) * 2);
            list.add(myCallable);
        }
//      Создание пула и листа будущих значений
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = new ArrayList<>();

//      Добавление задач в пул и будущих значений в лист буд. значений
        for (MyCallable myCallable : list) {
            Future<String> future = threadPool.submit(myCallable);
            futures.add(future);
        }

        Thread.sleep(SLEEP_TIME);
        System.out.println();
        System.out.printf("%49s%n", "*** РЕЗУЛЬТАТ РАБОТЫ ВСЕХ ЗАДАЧ ***");

//      Вывод ответов задач
        for (Future<String> string : futures) {
            System.out.println(string.get());
        }
        System.out.println();
        Thread.sleep(SLEEP_TIME - 4000);

//      Получение ответа самой быстрой задачи
        String invAnyResult = threadPool.invokeAny(list);
        System.out.println();
        System.out.printf("%55s%n", "*** РЕЗУЛЬТАТ РАБОТЫ САМОЙ БЫСТРОЙ ЗАДАЧИ ***");
        System.out.println(invAnyResult);
        System.out.println();

        threadPool.shutdown();
    }
}

