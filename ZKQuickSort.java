package com.sunxb.sort;

import com.mj.sort.Sort;

public class ZKQuickSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		sort(0, array.length);
	}
	
	private void sort(int begin, int end) {
		if (end - begin < 2) return;
		int pivot = pivot(begin, end);
		sort(begin, pivot);
		sort(pivot + 1, end);
	}

	private int pivot(int begin, int end) {
		// 随机找一个位置当做轴点， （把这个轴点元素交换到begin位置）
		int target = (int)(Math.random() * (end - begin)) + begin;
		swap(begin, target);
		
		// 把第一个点当做轴点，备份
		T ele = array[begin];	
		end --;
		while (begin < end) {
			while (begin < end) {
				// 先从右边开始
				if (cmp(array[end], ele) > 0) {
					end --;
				} else {
					array[begin] = array[end];
					begin ++;
					break;
				}
			}
			
			while (begin < end) {
				if (cmp(array[begin], ele) < 0) {
					begin ++;
				} else {
					array[end] = array[begin];
					end --;
					break;
				}
			}			
		}
		
		array[begin] = ele;
		return begin;
		
	}
	
}
