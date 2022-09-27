import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //메모리에 최대값 max 할당
    static int max = 0;

    public static void main(String[] args) throws Exception {
        new Main().start();
    }


    public void start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //방문체크위한 boolean타입 배열
        boolean[] visited = new boolean[num];

        //arr을 방문한 값을 넣을 새로운 배열
        int[] outarr = new int[num];

        // 0번 인덱스부터 방문(순열)해서 새로운 배열에 넣기
        permutation(arr, outarr,visited,0, num, num);

        //최대값 출력
        System.out.println(max);
    }

    //순열 메소드
    public void permutation(int[] arr, int[] outarr,boolean[] visited, int depth, int num,int r) {

        // 사이클 한번 돌았을 경우,
        if (depth == r) {
            // 최대값 구하는 메소드 호출
            Maxcheck(outarr);
            return;
        }

        //배열 방문할때마다, 새로운 배열인 outarr에 넣기
        for (int i = 0; i < num; i++) {
            if (!visited[i]) { //방문하지 않은 i인덱스라면,

                // 방문 처리
                visited[i] = true;

                // 방금 방문한 인덱스 i 의 배열을 새로운배열 outarr에 index 인덱스에 넣기
                outarr[depth] = arr[i];

                // index+1로 매개변수 보내서 다시 검사
                permutation(arr, outarr, visited,depth + 1, num, r);

                //방문하고, permutation 메소드에 넘긴후, outarr[depth], visited[i]를 초기화 해준다.
                outarr[depth] = 0;
                visited[i] = false;
            }
        }
    }

    // 최대값 구하기 메소드
    public void Maxcheck(int[] outarr) {
        int sum = 0;
        for(int i=0; i<outarr.length-1; i++){
            // 절댓값으로 변환 후, sum변수에 계속 더해준다
            sum += Math.abs(outarr[i]-outarr[i+1]);
        }
        if(max<sum){
            max = Math.max(sum, max);
        }
    }

}