import java.util.Arrays;
import java.util.Locale;

public class Task4 {
    
// Метод для задачи 1 из task4
    public static String  sevenBoom (int[] seven)
    { int a = 0;
        String s;
    for (int i: seven){
        s = Integer.toString(i); // число в строку
        if (s.contains("7"))
        { a +=1;
        }}
    if (a>0) return "BOOM!";
    else return "there is no 7 in the array";
    }

// Метод для задачи 2 из task4
    public static boolean cons(int[] sort){
        boolean k = false;
        Arrays.sort(sort); // класс arrays, метод сорт
       for(int i =1; i < sort.length;i++){
           k = sort[i] - sort[i - 1] == 1;
       }
        return k;
    }

// Метод для задачи 3 из task4
    public static String unmix(String mix){
        char obm;
        char[] a = mix.toCharArray();
        for( int i = 0; i<a.length; i+=2){
        obm = a[i];
        a[i] = a[i+1];
        a[i+1]=obm;
        }
        return String.valueOf(a); //возвращает строковое представление int аргумента
    }

// Метод для задачи 4 из task4
    public static String noYelling(String yell){
        while (yell.endsWith("!!") || yell.endsWith("??")) {
            yell = yell.substring(0, yell.length() - 1); // удаление последнего элемента строки
        }
        return yell;    
    }

// Метод для задачи 5 из task4
public static String xPronounce(String str) {
    String res = "";
    for (int i = 0; i < str.length(); i++)
        if (str.charAt(i) == 'x')
            if (i == 0 || str.charAt(i - 1) == ' ')
                if (i < str.length() && str.charAt(i + 1) != ' ')
                    res += 'z';
                else
                    res += "ecks";
            else
                res += "cks";
        else
            res += str.charAt(i);
    return res;
}
// Метод для задачи 6 из task4
    public static int largestGap (int[] gap){
        Arrays.sort(gap);
        int r = 0;
        for(int i = 0; i< gap.length - 1 ;i++)
        if ((gap[i+1] - gap[i])>r)
            r = gap[i+1] - gap[i];
        return r;
    }
// Метод для задачи 7 из task4
public static int func(int num) {
    char[] numCA = Integer.toString(num).toCharArray();
    Arrays.sort(numCA);
    int numInOrder = Integer.parseInt(new String(numCA));
    if(num>numInOrder)
        return num-numInOrder;
    return 0;
}

// Метод для задачи 8 из task4
    public static String commonLastVowel (String vowel) {
        vowel = vowel.toLowerCase();
        char[] arr = vowel.toCharArray();
        char buf = '1';
        for(int i = 0; i< arr.length; i++){
          if (isVowel(arr[i]))
              buf = arr[i];
        }
        return String.valueOf(buf); //valueOf возвращает строкове представление переданного аргумента
    }

    public static boolean isVowel(char c)
    {return "aeiouy".indexOf(c)!=-1;}

// Метод для задачи 9 из task4
    public static int memeSum(int a1, int a2){
        int len = Math.max(String.valueOf(a1).length(),String.valueOf(a2).length());
        String w  = "";
        for (int i = len - 1; i>= 0 ; i--){
            w = (a1 % 10 + a2 % 10) + w;
            a1 /=10;
            a2 /=10;
        }
        return Integer.parseInt(w);
    }

// Метод для задачи 10 из task4
public static String unrepeated (String str){
int l = str.length();
StringBuilder rez = new StringBuilder();
for(int i=0; i< l; i++){
    if (!rez.toString().contains(String.valueOf(str.charAt(i)))) //добавление неповторяющейся буквы
        rez.append(str.charAt(i));
}
    return rez.toString();
}
public static void main(String[] args) {
    System.out.println("Answer 1 = " + sevenBoom(new int[] {1, 2, 3, 4, 5, 6, 97}));
    System.out.println("Answer 2 = " + cons (new int[] {5, 6, 7, 8, 9, 13}));
    System.out.println("Answer 3 = " + unmix("hTsii  s aimex dpus rtni.g"));
    System.out.println("Answer 4 = " + noYelling("Oh my goodness!!!"));
    System.out.println("Answer 5 = " + xPronounce("OMG x box unboxing video x D") );
    System.out.println("Answer 6 = " + largestGap(new int[] {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
    System.out.println("Answer 7 = " + func(832));
    System.out.println("Answer 8 = " + commonLastVowel("Watch the characters dance!"));
    System.out.println("Answer 9 = " + memeSum(26, 39));
    System.out.println("Answer 10 = " + unrepeated("hello"));
}
}
