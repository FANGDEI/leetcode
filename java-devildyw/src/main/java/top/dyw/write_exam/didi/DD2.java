package top.dyw.write_exam.didi;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class DD2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int index = 3;
        HashMap<CompletableFuture<String>, Boolean> futureTasks = new HashMap<>();
        for (int i=1; i<=index; i++) {
            final int id = i;
            CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
                @Override
                public String get() {
                    double random = 3000* Math.random();

//                    System.out.println("time:" + random);
                    try {
                        Thread.sleep((long) random);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return String.format("任务ID和任务用时 -> Task [%d] completed in [%.0f ms]", id, random);
                }
            });
            futureTasks.put(future,false);

        }


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int count = 0;
                    while (count!=3) {
                        for (CompletableFuture<String> task : futureTasks.keySet()) {
                            if (!futureTasks.get(task)) {
                                if (task.isDone()) {
                                    System.out.println(task.get());
                                    futureTasks.put(task, true);
                                    count++;
                                }
                            }
                        }
                    }
                }  catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(2000);



    }
}
