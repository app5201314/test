import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<Object>> futures = executorService.invokeAll(List.of(
                () -> { System.out.println("Task 1"); return 1; },
                () -> { System.out.println("Task 2"); return null; },
                () -> { System.out.println("Task 3"); return "null1"; }
        ));

        futures.forEach(a -> {
            try {
                Object o = a.get();
                System.out.println(o);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
