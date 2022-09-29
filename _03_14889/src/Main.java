import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Min = Integer.MAX_VALUE;
    static int N;
    static boolean visited[];
    static int[][] arr;

    public static void main(String[] args) throws IOException , NumberFormatException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];

        // 배열 들어갈 수 입력
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0);

        System.out.println(Min);
    }

    static void check(int index, int depth) {

        if(depth == N / 2){ // 사이클 반 돌았으면, 넘기기
            minCheck();
            return;
        }

        // 방문하지않은 경우 계속 재귀함수 호출
        for (int i = index; i < N; i++) { // index + 1을 해줘야 중복X
            if (!visited[i]) {
                visited[i] = true;
                check(i+1, depth+1);
                visited[i] = false;
            }
        }

    }

    static void minCheck(){
        int startTeam = 0, linkTeam = 0;

        //방문한 i,j는 start팀으로, 방문하지않은 i,j는 link팀으로
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if(visited[i] && visited[j]){
                    startTeam += arr[i][j];
                    startTeam += arr[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    linkTeam += arr[i][j];
                    linkTeam += arr[j][i];
                }
            }
        }

        // |start - link| 차이 구하기
        int result = Math.abs(startTeam - linkTeam);

        if(result == 0){
            System.out.println(result);
            System.exit(0);
        }

        Min = Math.min(result, Min);
    }
}