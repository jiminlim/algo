package com.corona.day0401;
/*
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class BJ_안전지역 {
    static int n = 0;
    static int[][] data;
    static int[][] check;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    public static void dfs(int x,int y,int aux) {
        check[x][y] = 1;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n) {
                if(check[nx][ny] == 0 && data[nx][ny]>=aux) {
                    dfs(nx, ny, aux);
                }                
            }
        }
    }
    public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("안전지역"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner scan = new Scanner(System.in);
        int cnt = 0; 
        int max_val = 0;                                     
        n = Integer.parseInt(st.nextToken());                                
        data = new int[n][n];
        
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                data[i][j]= Integer.parseInt(st.nextToken());
                if(max_val<data[i][j]) max_val=data[i][j]; 
            }
        }
        int max_cnt = 1;
        
        for(int k=1;k<max_val;k++) {
            cnt=0;
            check = new int[n][n];    
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(data[i][j]>k && check[i][j]==0) {
                        cnt++;
                        dfs(i,j,k);
                    }
                }
            }
            if(max_cnt < cnt) max_cnt=cnt;
        }
        System.out.println(max_cnt);
    }
 
}

*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_안전지역 {
	static int[][] map;
	static boolean[][] v;
	static int height, max, N;
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("안전지역"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer tk;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tk.nextToken());
				if (map[i][j] > height)
					height = map[i][j];
			}
		}
		for (int h = 1; h < height; h++) 
		{
			int count = 0;
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j] && map[i][j] > h) {
						count++;
						dfs(i,j, h);
					}
				}
			}
			if (count > max) {
				max = count;
			}
		}
		System.out.println(max);
	}

	private static void dfs(int y, int x, int h) {
		v[y][x] = true;
		for (int d = 0; d < 4; d++) {
			int my = y + dy[d];
			int mx = x + dx[d];
			if (check(my, mx) && !v[my][mx] && map[my][mx] >= h) {
				dfs(my, mx, h);
			}
		}
	}

	private static boolean check(int my, int mx) {
		if (my >= 0 && mx >= 0 && my < N && mx < N) {
			return true;
		}
		return false;
	}
}
