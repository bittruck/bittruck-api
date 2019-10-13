package br.com.indepdevbr.models.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BittruckException extends RuntimeException {

	private static final long serialVersionUID = 5837741627596409598L;
	
	public BittruckException(String msg) {
		super(msg);
	}
	
	public BittruckException(Throwable thr) {
		super(thr);
	}
	
	public BittruckException(String msg, Throwable thr) {
		super(msg, thr);
	}

}
