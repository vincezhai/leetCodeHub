package com.zwx.thread;

/**
 * 1. 初始(NEW)：新创建了一个线程对象，但还没有调用start()方法。
 * 2. 运行(RUNNABLE)：Java线程中将就绪（ready）和运行中（running）两种状态笼统的称为“运行”。
 * 线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取CPU的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得CPU时间片后变为运行中状态（running）。
 * 3. 阻塞(BLOCKED)：表示线程阻塞于锁。
 * 4. 等待(WAITING)：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。
 * 5. 超时等待(TIMED_WAITING)：该状态不同于WAITING，它可以在指定的时间后自行返回。
 * 6. 终止(TERMINATED)：表示该线程已经执行完毕。
 *
 * 1. 新建状态(New): 线程对象被创建后，就进入了新建状态。例如，Thread thread = new Thread()。
 * 2. 就绪状态(Runnable): 也被称为“可执行状态”。线程对象被创建后，其它线程调用了该对象的start()方法，从而来启动该线程。例如，thread.start()。处于就绪状态的线程，随时可能被CPU调度执行。
 * 3. 运行状态(Running): 线程获取CPU权限进行执行。需要注意的是，线程只能从就绪状态进入到运行状态。
 * 4. 阻塞状态(Blocked): 阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：
 * (01) 等待阻塞 -- 通过调用线程的wait()方法，让线程等待某工作的完成。
 * (02) 同步阻塞 -- 线程在获取synchronized同步锁失败(因为锁被其它线程所占用)，它会进入同步阻塞状态。
 * (03) 其他阻塞 -- 通过调用线程的sleep()或join()或发出了I/O请求时，线程会进入到阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。
 * 5. 死亡状态(Dead): 线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
 */
public class TestThreadStatus {
    public static void main(String[] args) {
        //new
        Thread thread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SUB thread run at " + i);
            }
            System.out.println("end thread");
        });

        System.out.println("thread.getState() = " + thread.getState());// new

        thread.start();//就绪
        System.out.println("thread.getState() = " + thread.getState());// runable

        while (thread.getState() != Thread.State.TERMINATED ){
            System.out.println("thread.getState() = " + thread.getState());// runable || block
        }
        // end
        System.out.println("thread.getState() = " + thread.getState());// terminate
    }


}
