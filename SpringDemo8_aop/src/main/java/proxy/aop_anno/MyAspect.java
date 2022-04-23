package proxy.aop_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component("myAspect")
@Aspect //标注是切面类
public class MyAspect {
    /**
     * 先定义一个切点表达式
     */
    @Pointcut(value ="execution(* proxy.aop_anno.Target.*(..))" )
    public void pointcut(){}


    @Before(value = "execution(* proxy.aop_anno.Target.*(..))")
    public void before(){
        System.out.println("前置增强");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("后置增强");
    }

    @Around("MyAspect.pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强....");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强....");
        return proceed;
    }

    @AfterThrowing("MyAspect.pointcut()")
    public void afterThrowing(){
        System.out.println("异常抛出增强..........");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("最终增强..........");
    }


}



