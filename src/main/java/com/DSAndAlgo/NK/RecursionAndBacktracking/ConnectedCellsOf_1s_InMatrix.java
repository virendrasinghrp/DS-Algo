package com.DSAndAlgo.NK.RecursionAndBacktracking;

public class ConnectedCellsOf_1s_InMatrix {

	public static void main(String[] args) {
		int[][] qarr = {{1,1,0,0,0},{0,1,1,0,1},{0,0,0,1,1},{1,0,0,1,1},{0,1,0,1,1}}; 
		int result = getMaxOnes(qarr,5,5);
		System.out.println("Number of maximum 1s are: "+ result);
	}

	public static int getMaxOnes(int[][] arr, int rowLength, int colLength) {
		int size = 0;
		int maxSize = 0;
		boolean[][] visitedArray = new boolean[rowLength][colLength];
		for(int i=0; i<rowLength; i++) {
			for(int j=0; j<colLength; j++) {
				if(arr[i][j]==1) {
					maxSize = findMaxBlock(arr,i,j,rowLength,colLength,size,maxSize,visitedArray);
				}
			}
		}
		return maxSize;
	}
	
	public static int findMaxBlock(int[][] arr, int i, int j, int rowLength, int colLength, int size, int maxSize, boolean[][] visitedArray) {
		if(i>=rowLength || j>=colLength)
			return maxSize;
		visitedArray[i][j] = true;
		size++;
		if(size>maxSize)
			maxSize = size;
		//search in eight directions
		int[][] directions = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
		for(int k=0; k<8; k++) {
			int newi = i+directions[k][0];
			int newj = j+directions[k][1];
			int val = getVal(arr,newi, newj,rowLength,colLength);
			if(val==1 && visitedArray[newi][newj]==false)
				maxSize = findMaxBlock(arr, newi, newj, rowLength, colLength, size, maxSize, visitedArray);
		}
		//visitedArray[i][j] = false; // Not required because each method works on it's own copy of visitedArray.
		return maxSize;
	}
	
	public static int getVal(int[][] arr, int newi, int newj, int rowLength, int colLength) {
		if(newi<0 || newj<0 || newi>=rowLength || newj>=colLength)
			return 0;
		else
			return arr[newi][newj];
	}
}
