package day0316;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_�����̳�_20055 {
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/day0316/�����̾�"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		int[] belt = new int[2*N+1];
		boolean[] robot = new boolean[N+1];
		tk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2*N; i++) {
			belt[i] = Integer.parseInt(tk.nextToken());
		}
		int cnt =0;
		int result =0;
		while(true) {
			//�����̾� ��Ʈ ��ĭ ����
			int last = belt[2*N];
			for (int i = 2*N -1; i > 0; i--) {
				belt[i+1] = belt[i]; 
				if(i<N) {
					robot[i+1] = robot[i];
					robot[i] = false;
				}
			}
			belt[1] = last;
			robot[N] = false;
			//robot ����
			for (int i = N -1; i > 0; i--) {
				if(robot[i]) {
					if(!robot[i+1] && belt[i+1] > 0) { // ���� ĭ�� �κ��� ������
						robot[i+1] =true;
						robot[i]= false;
						belt[i+1] --;
						if(belt[i+1] ==0 ) {
							cnt++;
						}
					}
				}
			}
			if(robot[N]) robot[N]=false; // ��� ����
			if(!robot[1] && belt[1] > 0) {
				robot[1] = true; belt[1]--;
				if(belt[1] ==0) cnt++;
			}

			result ++;
			if(cnt == K) break;
		}
		
		System.out.println(result);
	}

}
