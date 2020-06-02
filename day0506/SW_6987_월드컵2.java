package com.corona.day0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_6987_월드컵_교수님 {

	static StringBuilder sb = new StringBuilder();
	static int[][] score = null;
	
	static int A;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        score = new int[4][18];
        StringTokenizer tokens;
        for (int r = 0; r < 4; r++) {
            tokens = new StringTokenizer(br.readLine());
            for (int c = 0; c < 18; c++) {
                score[r][c] = Integer.parseInt(tokens.nextToken());
            }
            A = 0;
            dfs(0, 1, score[r]);
            sb.append(A).append(" ");
        }

        System.out.println(sb);
    }


    static void dfs(int teamA, int teamB, int[] score) {
        // 상대팀이 6을 넘어가면 우리 팀이 변경되어야 한다.
        if (teamB == 6) {
            dfs(teamA + 1, teamA + 2, score);
            return;
        }
        // System.out.println("next team: " + (char) (teamA + 'A') + "," + teamA + " : " + (char) (teamB + 'A') + "," + teamB);
        if (teamA > 4) {
            // 솔루션 실행 - 하나라도 0이 아닌게 있으면 0 아니면 1
            for (int c = 0; c < score.length; c++) {
                if (score[c] > 0) {
                    A = 0;
                    return;
                }
            }
            A = 1;
            return;
        }

        // 각 팀별로 이기고, 비기고 질 때 체크 i=0, j=2 --> teamB 승, i=1, j=1 --> 비김, i=2, j=0 --> teamA 승
        for (int i = 0, j = 2; i < 3; i++, j--) {
            if (score[teamA * 3 + i] > 0 && score[teamB * 3 + j] > 0) {
                score[teamA * 3 + i]--;
                score[teamB * 3 + j]--;
                dfs(teamA, teamB + 1, score);
                score[teamA * 3 + i]++;
                score[teamB * 3 + j]++;
            }
        }
        /*
        // teamA가 이기고 teamB가 지는 경우
        if (temp[teamA * 3 + 0] > 0 && temp[teamB * 3 + 2] > 0) {
            temp[teamA * 3 + 0]--;
            temp[teamB * 3 + 2]--;
            dfs(teamA, teamB + 1, temp);
            temp[teamA * 3 + 0]++;
            temp[teamB * 3 + 2]++;
        }
        
        // teamA와 teamB가 비기는 경우
        if (temp[teamA * 3 + 1] > 0 && temp[teamB * 3 + 1] > 0) {
            temp[teamA * 3 + 1]--;
            temp[teamB * 3 + 1]--;
            dfs(teamA, teamB + 1, temp);
            temp[teamA * 3 + 1]++;
            temp[teamB * 3 + 1]++;
        }
        
        if (temp[teamA * 3 + 2] > 0 && temp[teamB * 3 + 0] > 0) {
            // teamA가 지고 teamB가 이기는 경우
            temp[teamA * 3 + 2]--;
            temp[teamB * 3 + 0]--;
            dfs(teamA, teamB + 1, temp);
            temp[teamA * 3 + 2]++;
            temp[teamB * 3 + 0]++;
        }*/
    }

    private static String src = "4 0 0 4 0 1 3 0 2 2 0 3 1 0 4 0 0 4\r\n" +
                                "5 0 0 0 5 0 0 0 5 5 0 0 0 5 0 0 0 5\r\n" +
                                "2 3 0 0 0 5 2 3 0 2 3 0 1 0 4 2 3 0\r\n" +
                                "4 1 0 3 1 1 2 1 2 2 1 2 0 1 4 1 1 3";
}
