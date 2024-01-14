package com.feng;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AcquireResultTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //getNow方法测试

        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {

            try {

                Thread.sleep(60 * 1000 * 60);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            return "hello world";

        });

        System.out.println(cp1.getNow("hello h2t"));

        //join方法测试

        CompletableFuture<Integer> cp2 = CompletableFuture.supplyAsync((() -> 1 / 0));

        System.out.println(cp2.join());

        //get方法测试

        CompletableFuture<Integer> cp3 = CompletableFuture.supplyAsync((() -> {
            try {
                Thread.sleep(1000);
                return 1000;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        System.out.println(cp3.get());

    }

}