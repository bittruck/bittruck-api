package br.com.indepdevbr.models.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ErroInternoException extends RuntimeException {

	private static final long serialVersionUID = 7399623573277492695L;
	
	
	public ErroInternoException() {}
	
	public ErroInternoException(String msg) {
		super(msg);
	}
	
	public ErroInternoException(Throwable thr) {
		super(thr);
	}
	
	public ErroInternoException(String msg, Throwable thr) {
		super(msg, thr);
	}

}
