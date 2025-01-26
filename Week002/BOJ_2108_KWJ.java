import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
         *
         * 산술평균 : N개의 수들의 합을 N으로 나눈 값
         * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
         * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
         * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
         * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
         *
         * 입력
         * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
         *
         * 출력
         * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
         * 둘째 줄에는 중앙값을 출력한다.
         * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
         * 넷째 줄에는 범위를 출력한다.
         **/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 산술평균을 구하기 위한 합계
        int sum = 0;

        // 중앙값 출력을 위한 리스트
        List<Integer> numberList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            numberList.add(num);
        }


        // 1. 산술평균
        double arithmeticMean =  (double) sum / N;;
        arithmeticMean = Math.round(arithmeticMean);
        System.out.println((int) arithmeticMean);


        // 2. 중앙값
        numberList.sort(Integer::compareTo);
        System.out.println(numberList.get((numberList.size() - 1)/2));


        // 3. 최빈값
        int maxfrequency = 0; // 최대빈도수
        int mode = 0; // 최빈값
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (Integer num : numberList) {
            int count;

            if (numberMap.containsKey(num)) {
                count = numberMap.get(num) + 1;
                numberMap.put(num, count);
            }else{
                count = 1;
                numberMap.put(num, count);
            }

            if(count > maxfrequency){
                maxfrequency = count;
                mode = num;

            } else if(count == maxfrequency & mode != num){
                if(mode>num){

                }


            }
        };

        System.out.println(mode);


        // 4. 범위
        int range = numberList.get(N-1) - numberList.get(0);
        System.out.println(range);



    }
}
