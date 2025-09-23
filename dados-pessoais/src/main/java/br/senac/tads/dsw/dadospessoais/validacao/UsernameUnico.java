package br.senac.tads.dsw.dadospessoais.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameUnicoValidator.class)
public @interface UsernameUnico {

	String message() default "Username já cadastrado";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
