package com.DSAndAlgo.NK.RecursionAndBacktracking;

//https://www.journaldev.com/44122/tower-of-hanoi
//Disks are numbered according to their size i.e. smallest disk is numbered 1 and so on.
public class TowerOfHanoi {

	public static void main(String[] args) {
		int disks = 5;
		towerOfHanoi(disks, 'A', 'C', 'B');

	}
	
	public static void towerOfHanoi(int n, char from_Rod, char to_Rod, char helper_Rod) {
		if(n==1) {
			System.out.println("Take disk 1 from rod "+from_Rod+ " to rod "+ to_Rod);
			return;
		}
		towerOfHanoi(n-1,from_Rod,helper_Rod,to_Rod);
		System.out.println("Take disk "+ n +" from rod "+from_Rod+" to rod "+ to_Rod);
		towerOfHanoi(n-1,helper_Rod,to_Rod,from_Rod);
	}

}
