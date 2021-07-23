package com.sushen.SmallProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Student {

	@Test(groups = {"smoke"})
	public void test() {
		int[][] a = { { 2, 4, 0 }, { 3, 4, 7 }, { 8, 2, 9 } };
		int minimumNumber = a[0][0];
		int largestNumber = 0;
		int row = 0;
		int minimumCol = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] < minimumNumber) {
					minimumNumber = a[i][j];
					row = i;
					minimumCol = j;
				}

			}
			for (int k = 0; k < a.length; k++) {
				for (int j = 0; j <= minimumCol; j++) {
					if (a[i][j] > largestNumber) {
						largestNumber = a[i][j];
					}

				}
			}

		}

		System.out.println("minimumm number  " + minimumNumber + " and in row " + (row + 1) + " and largest number "
				+ largestNumber);

		
	}
	@Test
	public void cp()
	{
		System.out.println("cp");
	}
	@AfterMethod
	public void wobile()
	{
		System.out.println("sushen");
	}
}
