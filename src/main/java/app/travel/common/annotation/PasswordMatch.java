package app.travel.common.annotation;

import app.travel.common.validator.PasswordFormatValidator;
import app.travel.common.validator.PasswordMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatch {

    String message();

    String passwordFieldName();

    String confirmPasswordFieldName();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
