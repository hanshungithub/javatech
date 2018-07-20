#### Fork/Join框架的原理
    ForkJoinPool是由ForkJoinTask数组和ForkJoinWorkThread数组组成，ForkJoinTask数组负责将存放程序提交给ForkJoinPool的任务，而ForkJoinWorkerThread数组负责执行这些任务

# java 中的13个原子类
#### 1，原子更新基本类型  
    1，AtomicBoolean 原子更新布尔类型  
    2，AtomicInteger 原子更新整形  
    3，AtomicLong 原子更新长整型
##### 以下以AtomicInteger为例 
    int addAndGet(int delta)
    以原子的方式将输入的数值与实例中的值（AtomicInteger的value）相加，并返回结果
    boolean conpareAndSet(int expect,int update)
    如果输入的数值等一预期值，则以原子方式将该值设为输入值
    int getAndIncrement()
    以原子方式将当前值加1 注意这里返回的是自增前的值
    void lazySet(int newValue)
    int getAndSet（int newValue）
    以原子方式设置为newValue的值，并返回旧值
#### 2，原子更新数组
    1，AtomicIntegerArray 原子更新整型数组里的元素
    2，AtomicLongArray 原子更新长整型数组里的元素
    3，AtomicReferenceArray 原子更新引用类型数组里的元素
# 3，java中的并发工具类
    CountDownLatch、CyclicBarrier、Semaphore工具类提供一种并发流程控制的手段，Exchange工具类提供了线程间交换数据的一种手段
    
##### 3.1 等待多线程完成的CountDownLatch
    CountDownLatch允许一个或多个线程等待其他线程完成操作
    注意：计数器必须大于0
##### 3.2 同步屏障CyclicBarrier
    让一组线程达到一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门
    所有被拦截的线程才会继续运行
##### 3.4,控制并发线程数的Semaphore
    是用来控制同时访问特定资源的线程数量，它通过协调各个线程，以保证合理的使用公共资源
##### 3.5,线程间数据交换的Exchange
    Exchange是一个用户线程间写作的工具类，Exchange用于进行线程间数据交换，它提供一个同步点，
    在这个同步点数据可以进行交换
# 9 java中的线程池
    1，减低资源消耗
    2，提高响应速度
    3，提高线程的可管理性
##### 9.1 线程池的实现原理
    当提交一个新任务到线程池时，线程池的处理流程如下
    1)线程池判断核心线程池里的线程时候都在执行任务，如果不是则创建一个新的工作线程来执行
    任务。如果核心线程池里的线程都在指向任务，则进入下一个流程
    2)线程池判断工作队列是否已满，如果工作队列还没有满，则将新提交的任务存储在这个工作队
    列里，如果工作队列满了，则进入下一个流程
    3)线程池判断线程池的线程是否都处于工作状态，如果没有，则创建一个新的工作线程来执行任
    务，如果满了，则交给饱和策略来处理这任务
# 10 Executor框架
    Executor框架主要由3大部分组成：
    1，任务。包括被执行的任务需要实现的接口：Runnable接口和Callable接口
    2，任务的执行。包括任务执行的核心接口Executor，以及继承自Executor的ExecutorService接口
    （ThreadPoolExecutor和ScheduledThreadPoolExecutor）
    3，异步计算的结果。包括接口Future和实现Future的接口FutureTask
##### 10.1 