BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(tk.hasMoreTokens()) {
			list.add(Integer.parseInt(tk.nextToken()));			
		}
		
		int B = Integer.parseInt(br.readLine());
		int C =Integer.parseInt(br.readLine());
		
		int result = list.size();
		
		for(int i =0 ;i<list.size(); i++) {
			int classCnt = list.get(i) - B;
			result += classCnt / C;
			if(classCnt % C != 0) {
				result ++;
			}
			
		}

		System.out.println(result);
