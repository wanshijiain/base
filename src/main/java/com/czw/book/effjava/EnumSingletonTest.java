package com.czw.book.effjava;

import java.io.Serializable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EnumSingletonTest {
	public static void main(String[] args) throws Exception {
		EnumSingleton INSTANCE = EnumSingleton.INSTANCE;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ObjectOutputStream objOutput = new ObjectOutputStream(output);
		objOutput.writeObject(INSTANCE);
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		ObjectInputStream objInput = new ObjectInputStream(input);
		EnumSingleton copyINSTANCE = (EnumSingleton) objInput.readObject();
		System.out.println(INSTANCE == copyINSTANCE);
	}
}
enum EnumSingleton implements Serializable{ 
	INSTANCE;
	private Object readResolve() { 
		return INSTANCE;
	} 
}