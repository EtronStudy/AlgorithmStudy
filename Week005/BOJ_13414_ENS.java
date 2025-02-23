import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] command = br.readLine().split(" ");
        int passStudents = Integer.parseInt(command[0]);
        int insertStudents = Integer.parseInt(command[1]);

        Map<String, Integer> students = new HashMap<>();
        for (int i = 0; i < insertStudents; i++) {
            String student = br.readLine();
            students.put(student, i);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(students.entrySet());
        entryList.sort(Comparator.comparingInt(Map.Entry::getValue));

        for (int i = 0; i < passStudents && i < entryList.size(); i++) {
            System.out.println(entryList.get(i).getKey());
        }
    }

}
(성공)

- LinkedHashSet이라는 자료구조를 파악을 못했다. 
  - Set의 특성으로 중복된 인덱스를 찾아가고, Linked의 특성으로 삽입,삭제가 자유로워 속도적인 측면에 대해 이해를 하지 못했다.
