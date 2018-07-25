#### 谈谈 final、finally、 finalize 有什么不同？
    final可以用来修饰类、方法、变量、分别有不同的意义，final修饰的class代表不可以继承扩展，final修饰的变量是不可以修改的，final修饰的
    方法是不可以重写的
    finally是java保证重点代码一定要被执行的的一种机制，我们可以使用try-finally或者try-catch-finally进行类似的关闭jdbc
    finalize是object的一个方法，它设计的目的是保证对象再被垃圾收集前完成特定的资源回收
#### 强引用、软引用、弱引用、幻象引用有什么区别？具体使用场景是什...
    不同的引用类型，主要体现的是对象不同的可达性