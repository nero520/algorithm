package com.zmparty.math.algorithm;

/**
 * ���ȶ�
 * �ռ临�Ӷ�O(1)
 * ���ʱ�临�Ӷ�T(n*log2n)
 * ƽ��ʱ�临�Ӷ�T(n*log2n)
 * �����������˴����(��С����)�Ѷ���¼�Ĺؼ������(����С)��һ������ʹ���ڵ�ǰ��������ѡȡ���(����С)�ؼ��ֵļ�¼��ü򵥡�
 * �������ֱ��ѡ�������෴�����κ�ʱ�̶�������������������������֮ǰ��������������ԭ������β���ɺ���ǰ����������������Ϊֹ��
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
	 * ����˼�룺��������һ������ѡ�������Ƕ�ֱ��ѡ���������Ч�Ľ���
     * �ѵĶ������£�����n��Ԫ�ص����У�h1,h2,...,hn),
     * ���ҽ������㣨hi>=h2i,hi>=2i+1����hi<=h2i,hi<=2i+1��(i=1,2,...,n/2)ʱ��֮Ϊ�ѡ�
     * ������ֻ��������ǰ�������Ķѡ��ɶѵĶ�����Կ������Ѷ�Ԫ�أ�����һ��Ԫ�أ���Ϊ�����󶥶ѣ���
     * ��ȫ���������Ժ�ֱ�۵ر�ʾ�ѵĽṹ���Ѷ�Ϊ��������Ϊ����������������
     * ��ʼʱ��Ҫ������������п�����һ��˳��洢�Ķ��������������ǵĴ洢��ʹ֮��Ϊһ���ѣ���ʱ�ѵĸ��ڵ�������
     * Ȼ�󽫸��ڵ���ѵ����һ���ڵ㽻����Ȼ���ǰ��(n-1)�������µ���ʹ֮��Ϊ�ѡ�
     * �������ƣ�ֱ��ֻ�������ڵ�Ķѣ��������������������õ���n���ڵ���������С�
     * ���㷨������������������Ҫ�������̣�һ�ǽ����ѣ����ǶѶ���ѵ����һ��Ԫ�ؽ���λ�á�
     * ���Զ�����������������ɡ�һ�ǽ��ѵ���͸���������Ƿ���������͸����ʵ������ĺ�����
     * 
     * ����������㷨�Ļ��������� 
     * �� ��ʼ����������R[1..n]����Ϊ��ʼ�ѣ�
     * �� ÿһ������Ļ�������������ǰ�������ĶѶ���¼R[1]�͸���������һ����¼������Ȼ���µ�����������Ϊ��(����ؽ���)��
     * ע�⣺ 
     * ��ֻ����n-1������ѡ���ϴ��n-1���ؼ��ּ�����ʹ���ļ���������
     * ����С�������������ô�������ƣ�ֻ�������������ǵݼ�����ġ�
	 */
	public static void heapSort(int[] data){
		
		int length = data.length;
		for (int i = 0; i < length-1; i++) {
			//1.������
			//buildMaxHeap(data, length-1-i);
			buildMinHeap(data, length-1-i);
			//2.�����Ѷ������һ��Ԫ�� 
			swap(data, 0, length-1-i);
			printRs(data,0,length-1-i,"*********");
			
		}
		
	}
	
	/**
	 * data�����0��lastIndex���󶥶� 
	 * һ�㶼����������ʾ�ѣ�i���ĸ�����±��Ϊ(i �C 1) / 2��
	 * ���������ӽ���±�ֱ�Ϊ2 * i + 1��2 * i + 2��
	 * ���0����������ӽ���±�ֱ�Ϊ1��2��
	 * @param data
	 * @param lastIndex
	 */
	public static void buildMaxHeap(int[] data,int lastIndex){
		//��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ
		int parentNode = (lastIndex-1)/2;//���һ������ĸ��ڵ������±�
		for (int i = parentNode; i>=0; i--) {
			//k���������жϵĽڵ�
			int k = i;
			//�����ǰk�ڵ���ӽڵ���� 
			if(k*2+1<=lastIndex){
			//while(k*2+1<=lastIndex){
				 // biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�  
				int biggerIndex = 2*k+1;				
				 //���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ�����ӽڵ����
				if(biggerIndex < lastIndex){
					//������ӽڵ��ֵ�ϴ� 
					if(data[biggerIndex] < data[biggerIndex+1]){
						 //�����ӽڵ�ֵ�����ӽڵ�ֵ����biggerIndex��¼�������ӽڵ��ֵ  
						biggerIndex++;
					}
				}
				
				 //���k�ڵ��ֵС����ϴ���ӽڵ��ֵ 
				if(data[k] < data[biggerIndex]){
					//��������
					swap(data,k,biggerIndex);
					printRs(data,k,biggerIndex,"++++");
					//��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ  
					//k=biggerIndex; 
				}/*else{
					break;
				}*/
			}
		}
	}
	
	/**
	 * data�����0��lastIndex��С���� 
	 * @param data
	 * @param lastIndex
	 */
	public static void buildMinHeap(int[] data,int lastIndex){
		//��lastIndex���ڵ㣨���һ���ڵ㣩�ĸ��ڵ㿪ʼ
		int parentNode = (lastIndex-1)/2;//���һ������ĸ��ڵ������±�
		for (int i = parentNode; i>=0; i--) {
			//k���������жϵĽڵ�
			int k = i;
			//�����ǰk�ڵ���ӽڵ���� 
			if(k*2+1<=lastIndex){
			//while(k*2+1<=lastIndex){
				 // minIndex���Ǽ�¼��С�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�  
				int minIndex = 2*k+1;				
				 //���minIndexС��lastIndex����minIndex+1�����k�ڵ�����ӽڵ����
				if(minIndex < lastIndex){
					//������ӽڵ��ֵ��С 
					if(data[minIndex] > data[minIndex+1]){
						 //�����ӽڵ�ֵ�����ӽڵ�ֵС����minIndex��¼�������ӽڵ��ֵ  
						minIndex++;
					}
				}
				
				 //���k�ڵ��ֵ�������С���ӽڵ��ֵ 
				if(data[k] > data[minIndex]){
					//��������
					swap(data,k,minIndex);
					printRs(data,k,minIndex,"++++");
					//��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵС���������ӽڵ��ֵ  
					//k=biggerIndex; 
				}/*else{
					break;
				}*/
			}
		}
	}
	
	
	
}
