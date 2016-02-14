package com.zmparty.math.algorithm;

/**
 * �?��选择排序
 * 算法不稳�?
 * O(1)的额外的空间
 * 比较的时间复杂度为T(n²)
 * 交换的时间复杂度为T(n)
 * 并不是自适应�?
 * 在大多数情况下都不推荐使用�?只有在希望减少交换次数的情况下可以用�?
 *
 */
public class DirectSelectSort  extends BaseSort{

	public static void main(String[] args) {
		int[] data = new int[]{57,68,59,52};
		printRs(data);
		selectSort(data);
		printRs(data);
	}
	
	/**
	 * �?��排序的�?路是�?
	 * 1.在排序的数组中�?出一个最小的与第�?��进行交换
	 * 2.然后在剩余的数组中�?出一个最小的与第二个进行交换�?
	 * 如此循环到�?数第二个数与�?���?��数为止；
	 * @param data
	 */
	public  static void selectSort(int [] data){
		int minIndex = 0;
		for (int i = 0; i < data.length; i++) {
			minIndex = i;// 记录�?��值的索引 
			for (int j = i+1; j < data.length; j++) {
				//找出�?��的�?和位置；
				if(data[minIndex]>data[j]){
					minIndex = j;// 若后面的元素值小于最小�?,将j赋�?给minIndex(曾经在这里多交换数据)
				}
			}
			//进行交换
			int tmp = data[minIndex];
			data[minIndex] = data[i];
			data[i] = tmp;
			printRs(data);
		}
	}
	

}
