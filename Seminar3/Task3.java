import java.util.Arrays;
import java.util.ArrayList;

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
      int aver = arr[0];
      for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
      }
//       Arrays.sort(arr);
      System.out.println(Arrays.toString(arr));
      for (int i = 1; i < arr.length; i++) {
        aver += arr[i];
      }
      int max = arr[arr.length - 1];
      int min = arr[0];
      System.out.println("Minimum is " + min);
      System.out.println("Maximum is " + max);
      aver = aver / arr.length;
      System.out.println("Average is = " + aver);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task3{ 
    public static void main(String[] args) { 
      Integer[] arr = {};
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
      }
      else{
        arr = Arrays.stream(args[0].split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
      }     
      
      Answer ans = new Answer();      
      ans.analyzeNumbers(arr);
    }
}