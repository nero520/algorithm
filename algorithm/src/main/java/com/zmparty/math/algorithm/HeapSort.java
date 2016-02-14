package com.zmparty.math.algorithm;

/**
 * 不稳定
 * 空间复杂度O(1)
 * 最差时间复杂度T(n*log2n)
 * 平均时间复杂度T(n*log2n)
 * 堆排序利用了大根堆(或小根堆)堆顶记录的关键字最大(或最小)这一特征，使得在当前无序区中选取最大(或最小)关键字的记录变得简单。
 * 堆排序和直接选择排序相反：在任何时刻堆排序中无序区总是在有序区之前，且有序区是在原向量的尾部由后往前逐步扩大至整个向量为止。
 *
 */
public class HeapSort extends BaseSort{

	public static void main(String[] args) {
		int[] data = new int[]{ 5, 3, 6, 2, 1, 9, 4, 8, 7};
		printRs(data);
		heapSort(data);
		printRs(data);
	}
	
	/**
	 * 基本思想：堆排序是一种树形选择排序，是对直接选择排序的有效改进。
     * 堆的定义如下：具有n个元素的序列（h1,h2,...,hn),
     * 当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。
     * 在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。
     * 完全二叉树可以很直观地表示堆的结构。堆顶为根，其它为左子树、右子树。
     * 初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。
     * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。
     * 依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
     * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
     * 所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
     * 
     * 大根堆排序算法的基本操作： 
     * ① 初始化操作：将R[1..n]构造为初始堆；
     * ② 每一趟排序的基本操作：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换，然后将新的无序区调整为堆(亦称重建堆)。
     * 注意： 
     * ①只需做n-1趟排序，选出较大的n-1个关键字即可以使得文件递增有序。
     * ②用小根堆排序与利用大根堆类似，只不过其排序结果是递减有序的。
	 */
	public static void heapSort(int[] data){
		
		int length = data.length;
		for (int i = 0; i < length-1; i++) {
			//1.建立堆
			//buildMaxHeap(data, length-1-i);
			buildMinHeap(data, length-1-i);
			//2.交换堆顶和最后一个元素 
			swap(data, 0, length-1-i);
			printRs(data,0,length-1-i,"*********");
			
		}
		
	}
	
	/**
	 * data数组从0到lastIndex建大顶堆 
	 * 一般都用数组来表示堆，i结点的父结点下标就为(i – 1) / 2。
	 * 它的左右子结点下标分别为2 * i + 1和2 * i + 2。
	 * 如第0个结点左右子结点下标分别为1和2。
	 * @param data
	 * @param lastIndex
	 */
	public static void buildMaxHeap(int[] data,int lastIndex){
		//从lastIndex处节点（最后一个节点）的父节点开始
		int parentNode = (lastIndex-1)/2;//最后一个数组的父节点数组下标
		for (int i = parentNode; i>=0; i--) {
			//k保存真正判断的节点
			int k = i;
			//如果当前k节点的子节点存在 
			if(k*2+1<=lastIndex){
			//while(k*2+1<=lastIndex){
				 // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点  
				int biggerIndex = 2*k+1;				
				 //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if(biggerIndex < lastIndex){
					//如果右子节点的值较大 
					if(data[biggerIndex] < data[biggerIndex+1]){
						 //若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值  
						biggerIndex++;
					}
				}
				
				 //如果k节点的值小于其较大的子节点的值 
				if(data[k] < data[biggerIndex]){
					//交换它们
					swap(data,k,biggerIndex);
					printRs(data,k,biggerIndex,"++++");
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
					//k=biggerIndex; 
				}/*else{
					break;
				}*/
			}
		}
	}
	
	/**
	 * data数组从0到lastIndex建小顶堆 
	 * @param data
	 * @param lastIndex
	 */
	public static void buildMinHeap(int[] data,int lastIndex){
		//从lastIndex处节点（最后一个节点）的父节点开始
		int parentNode = (lastIndex-1)/2;//最后一个数组的父节点数组下标
		for (int i = parentNode; i>=0; i--) {
			//k保存真正判断的节点
			int k = i;
			//如果当前k节点的子节点存在 
			if(k*2+1<=lastIndex){
			//while(k*2+1<=lastIndex){
				 // minIndex总是记录较小节点的值,先赋值为当前判断节点的左子节点  
				int minIndex = 2*k+1;				
				 //如果minIndex小于lastIndex，即minIndex+1代表的k节点的右子节点存在
				if(minIndex < lastIndex){
					//如果右子节点的值较小 
					if(data[minIndex] > data[minIndex+1]){
						 //若右子节点值比左子节点值小，则minIndex记录的是右子节点的值  
						minIndex++;
					}
				}
				
				 //如果k节点的值大于其较小的子节点的值 
				if(data[k] > data[minIndex]){
					//交换它们
					swap(data,k,minIndex);
					printRs(data,k,minIndex,"++++");
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值小于其左右子节点的值  
					//k=biggerIndex; 
				}/*else{
					break;
				}*/
			}
		}
	}
	
	
	
}
