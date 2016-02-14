package com.zmparty.math.algorithm;

public class BaseSort {

	public static void printRs(int[] data){
		for (int i : data) {
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	
	public static void printRs(int[] data,int i,int j,String split){
		for (int k : data) {
			System.out.print(k+"\t");
		}
		System.out.println("i="+i+"j="+j+"·Ö¸ô·û="+split);
	}
	
	public static void swap(int[] data,int i,int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
}
