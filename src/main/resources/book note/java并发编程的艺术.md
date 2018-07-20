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
    
