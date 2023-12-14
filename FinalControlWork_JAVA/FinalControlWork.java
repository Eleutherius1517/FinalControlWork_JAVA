// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами. 
// Вывод должен быть отсортирован по убыванию числа телефонов.

package FinalControlWork_JAVA;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

class PhoneNums implements Comparable<PhoneNums>{
    private String Num;

    public PhoneNums(String Num){
        this.Num = Num;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(Num);
        return sb.toString();
    }

    public int compareTo(PhoneNums anotherPhoneNums)
    {
        if (this.Num.length() == anotherPhoneNums.Num.length()) {
            return 0;
        } else if (this.Num.length() < anotherPhoneNums.Num.length()) {
            return -1;
        } else {
            return 1;
        }
    }
}

class PhoneBook {
    private static HashMap<String, PhoneNums> phoneBook = new HashMap<>();
    //добавление номера в книгу
    public void add(String name, String phoneNum) {
        if (phoneBook.containsKey(name)) {
            String str = phoneBook.get(name).toString();
            str += "; " + phoneNum;
            phoneBook.put(name, new PhoneNums(str));
        }
        else {
            phoneBook.put(name, new PhoneNums(phoneNum));
        }
    }
    //поиск номера в книге
    public String find(String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name).toString() ;
        }
        return "Name not find";
    }
    //вся книга
    public static HashMap<String, PhoneNums> getPhoneBook() {
        return phoneBook;
    }
    // сортировка книги по количеству номеров
    public static void showSortedPhoneBook(){
        int count = phoneBook.size();
        HashMap<String, PhoneNums> sortedMap = new LinkedHashMap(count);
        for (int i = 0; i < count; i++) {
            sortedMap = phoneBook.entrySet()
                                  .stream()
                                  //.sorted(HashMap.Entry.comparingByValue())
                                  .sorted(Collections.reverseOrder(HashMap.Entry.comparingByValue()))
                                  .collect(Collectors
                                    .toMap(HashMap.Entry::getKey,
                                           HashMap.Entry::getValue,
                                           (e1, e2) -> e1,
                                           LinkedHashMap::new));
        }
        System.out.println(sortedMap);
    }


}

public class FinalControlWork {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String phone1;
        String phone2;
        String phone3;
        String phone4;
        String phone5;
        String phone6;
        
        name1 = "Petrov";
        name2 = "Sidorov";
        name3 = "Ivanov";
        phone1 = "589358";
        phone2 = "397389";
        phone3 = "293058";
        phone4 = "193240";
        phone5 = "392049";
        phone6 = "903421";

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone3);
        myPhoneBook.add(name3, phone4);
        myPhoneBook.add(name3, phone6);
        myPhoneBook.add(name3, phone5);
        myPhoneBook.add(name1, phone3);

        //System.out.println(myPhoneBook.find(name1));
        System.out.println(PhoneBook.getPhoneBook());
        //System.out.println(myPhoneBook.find("Me"));
        PhoneBook.showSortedPhoneBook();
    }
}
