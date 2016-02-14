package com.zmparty.math.algorithm;
/**
 * 直接插入排序
 * 1.稳定性：稳定
 * 2.时间复杂度：T(n²)
 * 3.空间复杂度：O(1)
 * @author xiaoxiong
 *
 */
public class DirectInsertSort extends BaseSort {

	public static void main(String[] args) {
		int[] data = new int[]{5,2,7,6,1,3,8,9,4};
		printRs(data);
		insertSort(data);
		printRs(data);
	}
	
	/**
	 * 直接插入排序核心是假设前面的都排好序了，后面的与前面的比�?
	 * @param data
	 */
	public static void insertSort(int[] data){
		int tmp = 0;
		for (int i = 1; i < data.length; i++) {
			//缓存i处元素�?
			tmp = data[i];
			int j = i-1;
			//前面的数整体后移�?��
			while(j>=0&&tmp<data[j]){//曾经�?.K>=0写到了后面导致数组下标越界，2.曾经把tmp<data[k]写成了tmp>data[k]
				data[j+1] = data[j];
				j--;
			}
			//�?��将tmp插入合�?的位�?
			data[j+1] = tmp;
			printRs(data,i,j,"====");
		}
	}
}

	
