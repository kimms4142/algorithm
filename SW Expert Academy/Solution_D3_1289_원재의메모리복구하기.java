import java.util.Scanner;
import java.io.FileInputStream;

class Solution_D3_1289_원재의메모리복구하기{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String input = sc.nextLine();
			String[] str = input.split("");

			int[] array = new int[str.length];
			int cnt = 0;

            for (int j = 0; j < str.length; j++) {
                array[j] = Integer.parseInt(str[j]);
            }

            int flag = 0;
            for (int j = 0; j < array.length; j++) {
            	if(array[j] != flag) {
            		++cnt;
            		flag = array[j];
            	}
            }
            System.out.println("#" + test_case + " " + cnt);
		}
	}
}