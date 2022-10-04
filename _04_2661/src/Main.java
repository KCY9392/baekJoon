import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static String answer;
    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        N = Integer.parseInt(br.readLine());

        answer = "";
        permutation("");

        System.out.println(answer);

    }

    //재귀함수
    public static void permutation(String s) {

        if(answer != "") {
            return;
        }

        if(s.length() == N) {
            answer = s;
            return;
        }

        for(int i=1;i<=3;i++) {
            if(check(s+i)) {
                permutation(s+i);
            }
        }
    }


    //좋은 수열인지 확인하는 함수
    public static boolean check(String s) {
        for(int i=1;i<=s.length()/2;i++) {
            for(int j=0;j<=s.length()-i*2;j++) {
                if(s.substring(j,j+i).equals(s.substring(j+i,j+i*2))) {
                    return false;
                }
            }
        }
        return true;
    }

}