//package day0330;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class bj_2887_青己磐澄2 {
//	static int dot;
//	static PriorityQueue<Point> pq;
//	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("./src/day0330/青己"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		pq = new PriorityQueue<Point>();
//		dot = Integer.parseInt(br.readLine());
//		StringTokenizer tk =new StringTokenizer(br.readLine());
//		
//		ArrayList<>
//		for (int i = 0; i < dot-1; i++) {
//			tk =new StringTokenizer(br.readLine());
//			Point p = new Point(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()));
//			pq.add(p);
//		}
//		
//		int result =0;
//		while(!pq.isEmpty()) {
//			Point p = pq.peek();
//			result += check(p);
////			x = p.x; y = p.y; z = p.z;
//			pq.poll();
//		}
//		System.out.println(result);
//	}
//
//	static class Point implements Comparable<Point>{
//		int x; int y; int z; int val;
//
//		public Point(int x, int y, int z) {
//			super();
//			this.x = x;
//			this.y = y;
//			this.z = z;
//		}
//
//		@Override
//		public int compareTo(Point po) {
//			return check(this) > check(po)? 1 :-1;
//		}
//	}
//	public static int check(Point point) {
//		int num = Math.min(Math.abs(point.x - x), Math.abs(point.y - y));
//		num = Math.min(num,Math.abs(point.z - z));
//		return num;
//	}
//}
