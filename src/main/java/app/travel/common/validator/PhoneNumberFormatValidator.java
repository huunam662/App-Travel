package app.travel.common.validator;

import app.travel.common.annotation.PhoneNumberFormat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import java.util.regex.Pattern;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhoneNumberFormatValidator implements ConstraintValidator<PhoneNumberFormat, String> {

    String regexPattern;

    @Override
    public void initialize(PhoneNumberFormat constraintAnnotation) {
        this.regexPattern = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {

        if(phoneNumber == null) return false;

        return Pattern.matches(regexPattern, phoneNumber);
    }
}
