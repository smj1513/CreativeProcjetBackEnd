package _2024.creativeproject.exception;

public class LoginInfoNotFoundException extends RuntimeException {
	LoginInfoNotFoundException(){

	}

	public LoginInfoNotFoundException(String message){
		super(message);
	}
}
