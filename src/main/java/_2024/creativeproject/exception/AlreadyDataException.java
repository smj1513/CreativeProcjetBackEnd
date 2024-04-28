package _2024.creativeproject.exception;

public class AlreadyDataException extends RuntimeException{
	AlreadyDataException(){}

	AlreadyDataException(String message){
		super(message);
	}
}

