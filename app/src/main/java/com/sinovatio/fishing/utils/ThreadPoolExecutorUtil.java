package com.sinovatio.fishing.utils;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zjp1002038
 */
public class ThreadPoolExecutorUtil {
    private static final int CORE_POOL_SIZE=1;//核心线程数
    private static final int MAX_MUM_POOL_SIZE=5;//非核心线程数
    private static final int KEEP_ALIVE_TIME=5;//非核心线程超时时间
    private static final int CAPACITY=10;//线程队列长度

    /**
     * 公用线程池
     */
    public static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_MUM_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(CAPACITY));

    public static void addPoolExecutor(Runnable runnable){
        poolExecutor.execute(runnable);
    }
}
