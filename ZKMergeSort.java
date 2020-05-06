package com.sunxb.sort;
import com.mj.sort.Sort;

@SuppressWarnings("unchecked")
public class ZKMergeSort<T extends Comparable<T>> extends Sort<T> {
	
	private T[] leftArr;
	
	@Override
	protected void sort() {
		leftArr = (T[]) new Comparable[array.length >> 1];
		sort(0, array.length);
	}
	
	// 对[begin,end) 进行排序
	private void sort(int begin, int end) {
		if (end - begin < 2) return;
		int mid = (begin + end) >> 1;
		sort(begin, mid);
		sort(mid, end);
		merge(begin, mid, end);
	}
	
	private void merge(int begin,int mid, int end) {
		int li = 0, le = mid - begin;
		int ri = mid, re = end;
		int ai = begin;
		// 先备份左侧的array
		for (int i = 0; i < le; i++) {
			leftArr[i] = array[i + begin];
		}
		
		while (li < le) {
			if (ri < re && cmp(array[ri], leftArr[li]) < 0) {
				array[ai] = array[ri];
				ri ++;
				ai ++;
			} else {
				array[ai] = leftArr[li];
				li ++;
				ai ++;
			}
		}
		
	}
	
}
