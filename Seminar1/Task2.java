class Answer {
    public boolean CheckSimple(int n){
      if (n <= 1) return false;
      if (n > 1 && n <= 3) return true;
      if (n % 2 == 0) return false;
      if (n % 3 == 0) return false;
      for (int i = 5; i <= Math.sqrt(n); i = i + 6)
          if (n % i == 0 || n % (i + 2) == 0)
              return false;

      return true;
    }
    public void printPrimeNums(){
      for (int i=1;i<1000;i++){
          if(CheckSimple(i)){
            System.out.println(i);
          }
      }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task2{ 
    public static void main(String[] args) { 
      
      Answer ans = new Answer();      
      ans.printPrimeNums();
    }
}