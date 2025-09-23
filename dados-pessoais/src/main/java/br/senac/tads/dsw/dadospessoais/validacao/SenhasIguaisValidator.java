package br.senac.tads.dsw.dadospessoais.validacao;

import br.senac.tads.dsw.dadospessoais.PessoaDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SenhasIguaisValidator implements ConstraintValidator<SenhasIguais, PessoaDto> {

	// Obter message da anotação
	private String message;

	@Override
	public void initialize(SenhasIguais annotation) {
		this.message = annotation.message();
	}

	@Override
	public boolean isValid(PessoaDto dados, ConstraintValidatorContext context) {
		if (dados.getSenha() == null || dados.getSenha().trim().isEmpty()) {
			return false;
		}
		boolean resultado = dados.getSenha().equals(dados.getRepeticaoSenha());
		if (resultado) {
			return true;
		}
		context.disableDefaultConstraintViolation();
		context.buildConstraintViolationWithTemplate(message)
			.addPropertyNode("senha")
			.addConstraintViolation();
		return false;
	}

}
