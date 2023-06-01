package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV3 {

    //hello.aop.order 패키지와 하위 패키지
    @Pointcut("execution(* hello.aop.order..*(..))")
    private void allOrder(){} // 포인트컷 시그니처라 칭함 반환타입은 void 여야함

    //클래스 이름 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    private void allService(){}


    @Around("allOrder()") // 포인트컷 hello.aop.order 패키지와 그 하위 패키지(..)를 지정하는 AspectJ포인트컷 표현식
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable { // Advice(어드바이스)
        log.info("[log] {}", joinPoint.getSignature()); // join point 시그니처
        return joinPoint.proceed();
    }
}
