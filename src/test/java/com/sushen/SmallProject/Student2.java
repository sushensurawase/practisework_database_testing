package com.sushen.SmallProject;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Student2 {

	@Test()
	public void login() {
		System.out.println("login");
		
	}
	@AfterSuite
	public void sushen()
	{
		System.out.println("hi sush");
	}
}
