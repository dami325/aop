package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {

//    @Around("hello.aop.order.aop.Pointcuts.allOrder()") // 포인트컷 hello.aop.order 패키지와 그 하위 패키지(..)를 지정하는 AspectJ포인트컷 표현식
//    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable { // Advice(어드바이스)
//        log.info("[log] {}", joinPoint.getSignature()); // join point 시그니처
//        return joinPoint.proceed();
//    }

//    @Around("hello.aop.order.aop.Pointcuts.orderAndService()")
//    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        try {
//            //@Before
//            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
//            Object result = joinPoint.proceed();
//            //@AfterReturning
//            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
//            return result;
//        } catch (Exception e) {
//            //@AfterThrowing
//            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
//            throw e;
//        } finally {
//            //@After
//            log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
//        }
//    }

    @Before("hello.aop.order.aop.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[before] {}", joinPoint.getSignature());
    }

    @AfterReturning(value = "hello.aop.order.aop.Pointcuts.orderAndService()", returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result) {
        log.info("[return] {} return={}", joinPoint.getSignature(), result);
    }

//    @AfterReturning(value = "hello.aop.order.aop.Pointcuts.allOrder()", returning = "result") returning=  이름과 파라미터 이름을 맞춰줘야함
//    public void doReturn2(JoinPoint joinPoint, String result) {
//        log.info("[return2] {} return={}", joinPoint.getSignature(), result);
//    }

    @AfterThrowing(value = "hello.aop.order.aop.Pointcuts.orderAndService()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("[ex] {} message={}", ex);
    }

    @After(value = "hello.aop.order.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());

    }
}
