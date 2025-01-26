import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Statistics_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandLine = Integer.parseInt(br.readLine());

        int[] numbers = new int[commandLine];
        for (int i = 0; i < commandLine; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);

        int arithmetic = getArithmetic(numbers, commandLine);
        System.out.println(arithmetic);
        int middleCount = getMiddleCount(numbers, commandLine);
        System.out.println(middleCount);
        int mode = getMode(numbers);
        System.out.println(mode);
        int gap = getGap(numbers);
        System.out.println(gap);


    }


    private static int getArithmetic(int[] numbers, int commandLine) {
        int[] temp = numbers;
        int arithmetic = 0;
        for (int i = 1; i <= temp.length; i++) {
            arithmetic += temp[i - 1];
        }   

        double count = (double) arithmetic / commandLine;
        return (int) Math.round(count);
    }

    private static int getMiddleCount(int[] numbers, int commandLine) {
        return (int) Math.ceil((double) commandLine / 2) - 1;
    }

    private static int getMode(int[] numbers) {
        int[] temp = numbers;

        //1. 중복을 제거 했어요 -> map -> map <Key ( 중복을 뺀 -1, -1 ,3,4 ,6,6,6) -> -1,3,4,6
        int[] array = Arrays.stream(temp)
                .distinct()
                .toArray();

        Map<Integer, Integer> map = new HashMap<>();
        for (int k : array) {
            map.put(k, 0);
        }

        //for문이 너무 많이 사용이 되어 속도 저하 유발

        for (int j : temp) {
            int count = map.get(j);
            count++;
            map.put(j, count);
        }

        //Map을 어떻게 정렬을 할꺼냐?
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort((e1, e2) -> {
            if (e2.getValue().equals(e1.getValue())) {
                return Integer.compare(e1.getKey(), e2.getKey());
            }
            return Integer.compare(e2.getValue(), e1.getValue());
        });

        if (entryList.size() != 1 && entryList.get(0).getValue() == entryList.get(1).getValue()) {
            return entryList.get(1).getKey();
        }

        return entryList.get(0).getKey();
    }

    private static int getGap(int[] numbers) {
        int[] temp = numbers;
        return temp[numbers.length - 1] - temp[0];
    }

}
