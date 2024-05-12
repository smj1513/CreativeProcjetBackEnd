package _2024.creativeproject.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface QueryStringArgResolver { //쿼리스트링 값들을 오브젝트로 매핑시키기 위한 어노테이션
}
