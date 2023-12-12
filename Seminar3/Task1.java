import java.util.Arrays;

class MergeSort {
    public static int[] mergeSort(int[] arrayA) {
        // Напишите свое решение ниже
      if (arrayA == null) {
            return null;
        }
      if (arrayA.length < 2) {
            return arrayA; 
        }
      int [] arrayB = new int[arrayA.length / 2];
      System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);
      
      int [] arrayC = new int[arrayA.length - arrayA.length / 2];
      System.arraycopy(arrayA, arrayA.length / 2, arrayC,
                       0, arrayA.length -       arrayA.length / 2);
      arrayB = mergeSort(arrayB);
      arrayC = mergeSort(arrayC);
      
      int[] arrayD = new int[arrayB.length + arrayC.length];
      int posL = 0, posR = 0;

      for (int i = 0; i < arrayD.length; i++) {
           if (posL < arrayB.length && posR < arrayC.length) {
               if (arrayB[posL] < arrayC[posR]) {
                   arrayD[i] = arrayB[posL];
                   posL++;
               } else {
                    arrayD[i] = arrayC[posR];
                    posR++;
               }
           } else if (posL == arrayB.length && posR < arrayC.length) {
                arrayD[i] = arrayC[posR];
                posR++;
           }
            else if (posL < arrayB.length && posR == arrayC.length) {
                arrayD[i] = arrayB[posL];
                posL++;
           }else{
                arrayD[i] = 0;
           }
       }
      return arrayD;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task1{ 
    public static void main(String[] args) { 
        int[] a;

        if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}