import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			int[] arrInt = new int[len];
			char[] arrChar = new char[len];
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				arrChar[i] = str.charAt(i);
				
				if(arrChar[i] == '(') arrInt[i] = 1;
				if(arrChar[i] == ')') arrInt[i] = -1;
				if(arrChar[i] == '{') arrInt[i] = 2;
				if(arrChar[i] == '}') arrInt[i] = -2;
				if(arrChar[i] == '[') arrInt[i] = 3;
				if(arrChar[i] == ']') arrInt[i] = -3;
				if(arrChar[i] == '<') arrInt[i] = 4;
				if(arrChar[i] == '>') arrInt[i] = -4;
			}
			// 유효성검사
			int valid = 0;
			// 배열 합
			int sum = 0;
						
			for(int i =0 ; i < arrInt.length;i++) {
				// 닫는 괄호부터 나오면 거르는 용도
				if(sum < 0 ) {
					valid = 0;
					break;
				}
				sum += arrInt[i];
			}
			
			if(sum == 0) {
				valid = 1;
			}
			else valid = 0;

			
			System.out.println("#" + tc+ " "+valid);

		}
	}

}
