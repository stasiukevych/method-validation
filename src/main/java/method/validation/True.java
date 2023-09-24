package method.validation;

import jakarta.inject.Qualifier;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(validatedBy = {TrueValidator.class})
public @interface True {

  String message() default "this value should be true";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}