package cn.com.sunkai.hystrix.springbootspringcloudhystrix.aspect;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.*;

@Aspect
@Component
public class CustomHystrixCommandAspect {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Pointcut(value = "@annotation(HystrixCommandCustom)")
    public void pointcut(){};

    @Around(value = "pointcut()&&@annotation(hystrixCommand)")
    public Object doPointCut(ProceedingJoinPoint proceedingJoinPoint
            ,HystrixCommandCustom hystrixCommand){
        int timeout = hystrixCommand.timeout();

        Future<?> submit = executorService.submit(() -> {
            try {
                return proceedingJoinPoint.proceed();
            }catch (Throwable e){
                System.out.println("ddddd");
                e.printStackTrace();
            }
            return null;
        });
        Object o = null;
        try {
            o = submit.get(timeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException |ExecutionException |TimeoutException |IllegalStateException e ) {
            e.printStackTrace();
            submit.cancel(true);
            if(!StringUtils.isBlank(hystrixCommand.callBack())){
                o = this.invorkFallBack(proceedingJoinPoint,hystrixCommand.callBack());
            }
        }


        return o;
    }

    public Object invorkFallBack(ProceedingJoinPoint proceedingJoinPoint,
                               String fallBack){
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Class<?>[] parameterTypes = method.getParameterTypes();
        try {
            Method method1 = proceedingJoinPoint.getTarget().getClass().getMethod(fallBack, parameterTypes);
            method1.setAccessible(true);
            return method1.invoke(proceedingJoinPoint.getTarget(), proceedingJoinPoint.getArgs());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
