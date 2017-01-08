package task_10_multithread_demo;

/**
 * Created by Yuleen on 2017/1/8.
 */
public class UnSafe1 {
    private Integer count = 0;

    public  void add(){
        count++;

    }

    public Integer get(){
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        final UnSafe1 unSafe1 = new UnSafe1();

        // 模拟10000个客户端并发访问
        Thread[] threads = new Thread[10000];

        for (int i = 0; i < 10000; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    unSafe1.add();
                }
            });
            threads[i].start();
        }

        //等待所有线程结束
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(unSafe1.get());
    }
}

