import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static String answer;
    static int N;
    static int[] Arr;
    static long min = 100000000, max = -100000000;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        //숫자들 입력
        for(int i=0; i<N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        int cal[] = new int[4];
        st = new StringTokenizer(br.readLine());

        //연산 개수 입력
        for(int i=0; i<cal.length; i++){
            cal[i] = Integer.parseInt(st.nextToken());
        }

        permutation(cal, Arr[0], 0);

        System.out.println(max);
        System.out.println(min);

    }

    //재귀함수
    public static void permutation(int[] cal, long value, int r) {

        if(r == N-1) { //남은 숫자가 없을때 최대,최소값 체크
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }

        if(cal[0] > 0){
            cal[0]--;
            permutation(cal, value+Arr[r+1], r+1);
            cal[0]++;
        }

        if(cal[1] > 0){
            cal[1]--;
            permutation(cal, value-Arr[r+1],r+1);
            cal[1]++;
        }

        if(cal[2] > 0){
            cal[2]--;
            permutation(cal, value * Arr[r+1], r+1);
            cal[2]++;
        }

        if(cal[3] > 0){
            cal[3]--;
            permutation(cal, value / Arr[r+1], r+1);
            cal[3]++;
        }
        return;
    }

}