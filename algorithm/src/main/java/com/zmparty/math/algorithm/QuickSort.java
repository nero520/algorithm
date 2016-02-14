package com.zmparty.math.algorithm;

/**
 * 快�?排序（交换排序之�?��
 * 不稳定（比如序列5 3 3 4 3 8 9 10 11�?
 * 现在中枢元素5�?(�?个元素，下标�?�?���?交换就会把元�?的稳定�?打乱
 * ，所以快速排序是�?��不稳定的排序算法，不稳定发生在中枢元素和a[j]交换的时刻�?�?
 * 时间复杂�?
 *     �?��情况（每次�?是�?到中间�?作枢轴）T(n)=O(nlog₂n)
 *     �?��情况（每次�?是�?到最小或�?��元素作枢轴）
 *     做n-1趟，每趟比较n-i次，总的比较次数�?��：[O(n²)]
 *     平均时间复杂度为：T(n)=O(nlog₂n)
 * @author xiaoxiong
 */
public class QuickSort extends BaseSort {

	public static void main(String[] args) {
		int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
		printRs(data);
		quickSort(data,0,data.length-1);
		printRs(data);
	}
	/**
	 * 基本思路很简单，从待排的数据序列中任取一个数据（如第�?��数据）作为分界�?，所有比它小的数据元素放到左边，
	 * �?��比它大的数据元素放到它的右边。经过这样一趟下来，该序列形成左右两个子序列，左边序列中的数据元素的值都比分界�?小，
	 * 右边序列中数据元素的值都比分界�?大�?接下来对左右两个子序列进行�?归排序，对两个子序列重新选择中心元素并依此规则调整，
	 * 直到每个元素子表的元素只剩下�?��元素，排序完成�?
	 * 思路�?
	 * 1.定义�?��i变量，i变量从左边第�?��索引�?��，找大于分界值的元素的索引，并用i来记录它�?
	 * 2.定义�?��j变量，j变量从右边第�?��索引�?��，找小于分界值的元素的索引，并用j来记录它�?
	 * 3.如果i<j，交换i,j两个索引处的元素�?
	 * 重复执行以上1,2,3步，直到i>=j，可以判断j左边的数据元素都小于分界值，j右边的数据元素都大于分界值，
	 * �?��将分界�?和j索引处的元素交换即可�?

	 * @param data
	 */
	public static void quickSort(int[] data,int start,int end){
		if(start >= end){
			return;
		}
		//数组中的第一个元素作为中轴记�?
		int tmp = data[start];
		int low = start;
		int high = end;
		while(low<high){
			
			while(high>low && data[high]>=tmp){
				high--;
			} 
			//比中轴小的记录移动到低端
			data[low] = data[high];
			printRs(data, low, high, "++比中轴小"+tmp+"的移动到低端++");
			while(low<high && data[low]<=tmp){
				low++;
			}
			//比中轴大的记录移动到高端
			data[high] = data[low];
			printRs(data, low, high, "++比中轴大"+tmp+"的移动到高端++");
		}
		data[low] = tmp;
		printRs(data, low, high, "++swap++");
		//递归左子序列
		printRs(data, start, low-1, "---left进入---");
		quickSort(data, start, low-1);
		printRs(data, start, low-1, "---left�?��---");
		//递归右子序列
		printRs(data, low+1, end, "---right进入---");
		quickSort(data, low+1, end);
		printRs(data, low+1, end, "---right�?��---");
	}
	
	

}
