package method.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TrueValidator implements ConstraintValidator<True, Boolean> {

  @Override
  public boolean isValid(Boolean value, ConstraintValidatorContext context) {
    return value;
  }
}