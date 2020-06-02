package com.corona.day0417;

import java.util.Arrays;

public class dp_플로이드 {

	public static void main(String[] args) {
		int[][] D = {{0, Integer.MAX_VALUE,2,3},
				{4,0,1,8},
				{2,5,0,Integer.MAX_VALUE},
				{Integer.MAX_VALUE, 9,6,0}};

		for (int k = 0; k < D.length; k++) {
			for (int i = 0; i < D.length; i++) {
				if(k==i)continue;
				for (int j = 0; j < D.length; j++) {
					if(k==j || i==j) continue;
					if(D[i][k]!= Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE && D[i][j] > D[i][k]+D[k][j])
						D[i][j] = D[i][k]+D[k][j];
				}
			}
		}
		
		for (int i = 0; i < D.length; i++) {
			System.out.println(Arrays.toString(D[i]));
		}
	}
}


