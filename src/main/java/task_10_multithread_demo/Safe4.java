package task_10_multithread_demo;

import java.util.concurrent.Callable;

/**
 * Created by Yuleen on 2017/1/8.
 */
public class Safe4 {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    public void nextNum(){
        seqNum.set(seqNum.get()+1);
    }

    public int getNum(){
        return seqNum.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final Safe4 unSafe1 = new Safe4();

        // 模拟10000个客户端并发访问
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 100; j++)
                        unSafe1.nextNum();
                    System.out.println(Thread.currentThread().getId()+":"+unSafe1.getNum());
                }
            });
            threads[i].start();
        }

        //等待所有线程结束
        for (Thread thread : threads) {
            thread.join();
        }
    }
}

