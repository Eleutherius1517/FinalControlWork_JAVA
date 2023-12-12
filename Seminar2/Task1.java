class Answer {  
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
      StringBuilder sb1 = new StringBuilder();
      String[] arrStr = PARAMS.split(", ");
      arrStr[0] = arrStr[0].replace("{\"", "");
      arrStr[arrStr.length - 1] = arrStr[arrStr.length - 1].replace("\"}", "\'");
      for(int i = 0; i < arrStr.length; i++){
        if(arrStr[i].contains("null")){
          continue;
        }
        arrStr[i] = arrStr[i].replace(":", "=");
        sb1.append(arrStr[i]);
      }
      String str2 = sb1.toString();
      str2 = str2.replace("\"\"", "\' and ");
      str2 = str2.replace("\"=\"", "=\'");
      str2 = str2.replace("\"", "\'");
      //String str3 = QUERY + str2;
      sb1.setLength(0);
      sb1.append(QUERY + str2);
      return sb1;
    }
}


// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task1{ 
	public static void main(String[] args) { 
      String QUERY = "";
      String PARAMS = "";
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        QUERY = "select * from students where ";
	    PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
      }
      else{
        QUERY = args[0];
        PARAMS = args[1];
      }     
      
      Answer ans = new Answer();      
      System.out.println(ans.answer(QUERY, PARAMS));
	}
}