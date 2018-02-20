package my.project.springdemo.mvc.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CourseCodeConstraintValidator.class)
@Retention(RUNTIME)
@Target({ METHOD, FIELD })
public @interface CourseCode {
	// default course code
	public String value() default "PT";
	// default error message
	public String message() default "must start with PT";
	// default groups
	public Class<?>[] groups() default {};
	// default payloads
	public Class<? extends Payload>[] payload() default {};
}
