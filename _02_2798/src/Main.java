import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int min = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //N 입력 ( 숫자 개수 )
        int n = Integer.parseInt(st.nextToken());

        //M 입력
        int m = Integer.parseInt(st.nextToken());


        int arr[] = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = check(arr, n, m);

        System.out.println(result);

    }

    static int check(int arr[], int n, int m){

        int result = 0;

        //첫번째 카드
        for(int i=0; i<n-2; i++){
            if(arr[i] > m){
                continue;
            }
            for(int j=i+1; j<n-1; j++){
                if(arr[i] + arr[j] > m){
                    continue;
                }
                for(int k=j+1; k<n; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == m) {
                        return sum;
                    }
                    if(result < sum && sum < m){
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}