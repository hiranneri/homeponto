package br.com.homeponto.config.validacao;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.homeponto.erros.ExceptionResponse;

@RestControllerAdvice
public class ErroValidacaoHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public @ResponseBody ExceptionResponse handle(final Exception exception,
			final HttpServletRequest request) {
		/*
		List<ErroFormularioDTO> errosDTO = new ArrayList<ErroFormularioDTO>();
		List<FieldError> fieldsErros = exception.getBindingResult().getFieldErrors();
		fieldsErros.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroFormularioDTO erro = new ErroFormularioDTO(e.getField(), mensagem);
			errosDTO.add(erro);
		});
		return errosDTO;
		*/
		ExceptionResponse error = new ExceptionResponse();
		error.setMensagem("Formato de horário inválido");
		error.setUri(request.getRequestURI());
		return error;
		
	}

}
