package br.com.rs.forum.validate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.rs.forum.dto.ErrorFormDTO;

@RestControllerAdvice
public class ErrorValidateHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorFormDTO> handle(MethodArgumentNotValidException exception) {
		List<ErrorFormDTO> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensage = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorFormDTO error = new ErrorFormDTO(e.getField(), mensage);
			dto.add(error);
		});
		
		return dto;
	}

}
