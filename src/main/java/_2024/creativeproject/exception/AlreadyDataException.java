package _2024.creativeproject.exception;

public class AlreadyDataException extends RuntimeException{
	AlreadyDataException(){}

	public AlreadyDataException(String message){
		super(message);
	}
}

