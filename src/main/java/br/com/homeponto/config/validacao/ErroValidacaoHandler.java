package br.com.homeponto.config.validacao;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDTO> handle(MethodArgumentNotValidException ex) {
		List<ErroFormularioDTO> errosDTO = new ArrayList<ErroFormularioDTO>();
		List<FieldError> errors = ex.getBindingResult().getFieldErrors();
		errors.forEach(erro ->{
			String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
			ErroFormularioDTO errodto = new ErroFormularioDTO(erro.getField(), mensagem);
			errosDTO.add(errodto);
		});
		return errosDTO;
	}
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DateTimeParseException.class)
	public List<ErroFormularioDTO> handleDateErrors(DateTimeParseException ex) {
		List<ErroFormularioDTO> errosDTO = new ArrayList<ErroFormularioDTO>();
		String mensagem = "Formato de data inválido";
		ErroFormularioDTO errodto = new ErroFormularioDTO(ex.getParsedString(), mensagem);
		errosDTO.add(errodto);	
	
		return errosDTO;
	}
	
	
}
