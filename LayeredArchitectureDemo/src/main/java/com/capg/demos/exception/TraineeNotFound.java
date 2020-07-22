package com.capg.demos.exception;

public class TraineeNotFound extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4456912580347589491L;

	public TraineeNotFound(String error){
        super();
        System.err.println(error);
    }
}
