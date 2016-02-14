package com.zmparty.math.algorithm;

/**
 * 冒泡排序（交换排序之�?��
 * 算法稳定
 * O(1)的额外的空间
 * 比较和交换的时间复杂度都是T(n²)
 * 自�?�?
 *
 */
public class BubbleSort  extends BaseSort{

	public static void main(String[] args) {
		int[] data = new int[]{57,68,59,52};
		printRs(data);
		bubbleSort(data);
		printRs(data);
	}
	
	/**
	 * 原理�?
	 * 冒泡排序是经过n-1趟子排序完成的，第i趟子排序从第1个数至第n-i个数，若第i个数比后�?��数大（则升序，小则降序）则交换两数�?
	 *	1.  比较相邻的元素�?如果第一个比第二个大，就交换他们两个�?
	 *	2.  对每�?��相邻元素作同样的工作，从�?��第一对到结尾的最后一对�?在这�?��，最后的元素应该会是�?��的数�?
	 *	3.  针对�?��的元素重复以上的步骤，除了最后一个�?
	 *	4.  持续每次对越来越少的元素重复上面的步骤，直到没有任何�?��数字�?��比较�?
	 * @param data
	 */
	public static void bubbleSort(int[] data){
		
		int tmp = 0;
		for (int i = 0; i < data.length-1; i++) {
			//第一轮完成时，最大�?或�?�?��值已经在末尾�?
			for (int j = 0; j < data.length-1-i; j++) {
				if(data[j]>data[j+1]){//大的�?��排序；比较完就交换数据，直接选择排序是全部比较出�?��的再交换数据
					tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
					
				}
			printRs(data,i,j,"++++");
			
			}
			printRs(data,i,-1,"----");
		}
	}
	

}
