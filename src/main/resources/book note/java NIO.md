# 2 缓冲区
#### 2.1 缓冲区基础
    容量(Capacity)
        缓冲器能够容纳的数据元素的最大值
    上界(limit)
        缓冲区第一个不能被读到的元素
    位置(position)
        下一个要被读或写的元素索引，位置会自动由相应的put()和get()函数更新
    标记(mark)
        一个备忘位置。调用 mark( )来设定 mark = postion。调用 reset( )设定 position =
        mark
    