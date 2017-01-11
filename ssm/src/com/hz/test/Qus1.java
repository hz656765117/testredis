package com.hz.test;

import java.util.ArrayList;
import java.util.List;

public class Qus1 {
	/**
	 * 思路：数出的白帽子数只可能有两种数值，将其分成两个list
	 * 如果两个list中有值不相等的情况下  则表示异常
	 * 白帽子个数+黑帽子个数 = 人数 
	 * 即 大的值+大的值得list个数= 人数
	 * @param whiteHat
	 * @return
	 */
	public static int count(int[] whiteHat){
		int num = whiteHat.length;  //人数
		int errorFlag = -1;
		if(num>50 || num<2){//人数必须为2至50
			return errorFlag;
		}
		List<Integer> oneList = new  ArrayList<Integer>(); 
		List<Integer> otherList = new  ArrayList<Integer>(); 
		for(int i = 0; i< num ; i++ ){
			int curSum = whiteHat[i];
			if(curSum>50 || curSum<0 || curSum> num){ //白帽子必须为0-50个，且数出的帽子个数不能大于人数
				return errorFlag;
			}
			if(oneList.size()==0){
				oneList.add(curSum);
			}
			if(oneList.contains(curSum)&& i>0){
				oneList.add(curSum);
			}else if(i>0){
				otherList.add(curSum);
			}
			 
		}
		for(int i = 0 ; i<otherList.size();i++){//如果list中有不同是数值，表示异常
			for(int j=i+1 ;j<otherList.size() ;j++){
				if(otherList.get(i)!= otherList.get(j)){
					return errorFlag;
				}
			}
		}
		
		if(oneList.size()==num){//边界值
			if(oneList.get(0)==0){ 
				return 0;
			}
			return errorFlag;
		}
		 
		if(oneList.get(0)>otherList.get(0)){
			if(num == (oneList.size()+oneList.get(0))){
				return oneList.get(0);
			}
		}else{
			if(num == (otherList.size()+otherList.get(0))){
				return otherList.get(0);
			}
		}
		return errorFlag;
	}
	
	public static void main(String[] args) {
		int[] whiteHat = {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int hat = count(whiteHat);
		System.out.println(hat);
	}
	
}
