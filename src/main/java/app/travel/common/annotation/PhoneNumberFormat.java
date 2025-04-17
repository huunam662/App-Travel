package app.travel.common.annotation;

import app.travel.common.validator.PhoneNumberFormatValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberFormatValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberFormat {

    String message() default "Phone numbers must contain only digits and be between 9 and 11 characters long.";

    String regex() default "^[0-9]{9,11}$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
