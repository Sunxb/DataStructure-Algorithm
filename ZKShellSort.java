package com.sunxb.sort;

import java.util.ArrayList;
import java.util.List;

import com.mj.sort.Sort;

public class ZKShellSort<T extends Comparable<T>> extends Sort<T> {
	
	@Override
	protected void sort() {
		List<Integer> stepSequence = shellStepSequence();
		System.out.println(stepSequence);
		for (Integer step : stepSequence) {
			sort(step);
		}
	}
	
	private void sort(int step) {
		for (int i = 0; i < step; i++) {
			for (int begin = i + step; begin < array.length; begin += step) {
				int cur = begin;
				while (cur > i && cmp(cur, cur - step) < 0) {
					swap(cur, cur - step);
					cur -= step;
				}
			}
		}
	}
	
	// 生成步长的list
	private List<Integer> shellStepSequence() {
		List<Integer> stepSequence = new ArrayList<Integer>();
		int i = array.length;
		while ((i >>= 1) > 0) {
			stepSequence.add(i);
		}
		return stepSequence;
	}
}
