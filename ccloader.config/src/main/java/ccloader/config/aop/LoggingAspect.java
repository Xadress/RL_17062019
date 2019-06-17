package ccloader.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private Logger getClassLogger(JoinPoint joinPoint) {
		return LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());
	}

	@Before("execution(* ccloader.web..*(..)) || execution(* ccloader.application..*(..)) || execution(* ccloader.repository..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		Logger logger = getClassLogger(joinPoint);
		logger.debug("Entering method {} : {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
	}

	@After("execution(* ccloader.web..*(..)) || execution(* ccloader.application..*(..)) || execution(* ccloader.repository..*(..))")
	public void logAfter(JoinPoint joinPoint) {
		Logger logger = getClassLogger(joinPoint);
		logger.debug("Exiting method {} : {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
	}
}
