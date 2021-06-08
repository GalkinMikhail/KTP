
import java.util.Arrays;
import static java.lang.Math.*;
import java.util.OptionalDouble;



public class Task3
{
// 1. Учитывая массив городов и населения, верните массив, в котором все население
// округлено до ближайшего миллиона.
public static String[][] millionsRounding(String[][] str)
{
    {
        double r_p = 0;
        for (int i = 0; i < str.length; i++)
        {
            int ppl = Integer.parseInt(str[i][1]);
            r_p = Math.round(ppl / Math.pow(10, 6)) * Math.pow(10, 6);
            str[i][1] = String.valueOf(r_p);
        }
        return str;
    }
}

// 2.Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны
// найти другие 2 стороны (верните самую длинную сторону, сторону средней
// длины).
public static double[] otherSides(int a) 
{
    int b = 2 * a;
    double cr;
    double c = a * sqrt(3);
    //search max nd average
    double maxi = max(c, max(a, b));
    double mini = min(c, min(a, b));
    if ((a == maxi && b == mini) || (b == maxi && a == mini)) {
        cr = c;
    } else {
        if ((a == maxi && c == mini) || (c == maxi && a == mini)) {
            cr = b;
        } else {
            cr = a;
        }
    }
    //round
    double scale=Math.pow(10,2);
    cr=Math.ceil(cr*scale)/scale;
    return new double[]{maxi,cr};
}
//3.Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция
//принимает входные данные обоих игроков (камень, ножницы или бумага), первый
//параметр от первого игрока, второй от второго игрока. Функция возвращает
//результат как таковой:
//"Игрок 1 выигрывает"
//"Игрок 2 выигрывает"
//"НИЧЬЯ" (если оба входа одинаковы)
//Правила игры камень, ножницы, бумага, если не известны:
//Оба игрока должны сказать одновременно "камень", "бумага" или "ножницы".
//Камень бьет ножницы, бумага бьет камень, ножницы бьют бумагу.
public static String rps(String p1, String p2) 
{
    if (p1.equals(p2)) return "ничья";
    if ((p1.equals("камень") && p2.equals("ножницы")) ||
        (p1.equals("бумага") && p2.equals("камень")) ||
        (p1.equals("ножницы") && p2.equals("бумага")))
        return "Игрок 1 победил";
    return "Игрок 2 победил";
}
//4.Идет великая война между четными и нечетными числами. Многие уже погибли в
//этой войне, и ваша задача-положить этому конец. Вы должны определить, какая
//группа суммируется больше: четная или нечетная. Выигрывает большая группа.
//Создайте функцию, которая берет массив целых чисел, суммирует четные и нечетные
//числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел.
public static int warOfNumbers(int[] numbers) 
{
    int odd = 0;
    int even = 0;
    for (int n : numbers)
        if (n % 2 == 0) even += n;
        else odd += n;
    return Math.abs(even - odd);
}
//5.Учитывая строку, создайте функцию для обратного обращения. Все буквы в
//нижнем регистре должны быть прописными, и наоборот.
public static String reverseCase(String text)
    {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if (Character.isUpperCase(c))
            {
                chars[i] = Character.toLowerCase(c);
            }
            else if (Character.isLowerCase(c))
            {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }
//6.Создайте функцию, которая принимает строку из одного слова и выполняет
//следующие действия:
//Конкатенирует inator до конца, если слово заканчивается согласным, в противном
//случае вместо него конкатенирует -inator
//обавляет длину слова исходного слова в конец, снабженный '000'
public static boolean isVowel(char c) 
{
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
           c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
}
   
public static String inatorInator(String str) 
{
    String inator = "inator";
    if (isVowel(str.charAt(str.length() -1)))
        inator = "-inator";
    return str + inator + " " + str.length() + "000";
}
//7.Напишите функцию, которая принимает три измерения кирпича: высоту(a),
//ширину(b) и глубину(c) и возвращает true, если этот кирпич может поместиться в
//отверстие с шириной(w) и высотой(h).
//Примечание:
//- Вы можете повернуть кирпич любой стороной к отверстию.
//- Мы предполагаем, что кирпич подходит, если его размеры равны размерам отверстия (то
//есть размер кирпича должен быть меньше или равен размеру отверстия, а не строго
//меньше).
//- Нельзя класть кирпич под неортогональным углом.
public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
    return a <= w && b <= h || a <= w && c <= h || b <= w && c <= h;
}
//8.Напишите функцию, которая принимает топливо (литры), расход топлива
//(литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает
//максимальное расстояние, которое может проехать автомобиль.
//топливо-это количество литров топлива в топливном баке.
//Расход топлива-это базовый расход топлива на 100 км (только с водителем внутри).
//Каждый дополнительный пассажир увеличивает базовый расход топлива на 5%.
//Если кондиционер включен, то его общий (не базовый) расход топлива увеличивается на
//10%
public static double totalDistance(double fuel, double rashod, int passengers,boolean cond)
    {
        rashod = rashod * (passengers * 5/100) + rashod;
        if (cond) 
            rashod = rashod * 110/100;
        return fuel/rashod * 100;
    }
//9.Создайте функцию, которая принимает массив чисел и возвращает среднее
//значение (average) всех этих чисел.
public static double mean(double[] arr)
    {
        OptionalDouble average = Arrays.stream(arr).average();
        return average.getAsDouble();
    }
//10.Создайте функцию, которая принимает число в качестве входных данных и
//возвращает true, если сумма его цифр имеет ту же четность, что и все число. В
//противном случае верните false.
public static boolean parityAnalysis(int a)
    {
        int sum = 0;
        int b = a;
        while (a > 0)
        {
            sum += a%10;
            a /= 10;
        }
        return b%2 == sum%2;
    }
    public static void main(String[] args) throws Exception
    {
        String[][] city = {{"Москва", "4334346"},{"Санкт-Петербург", "7996830"}, {"Киев", "1077048"}};
        System.out.println("# 1 = " );
        millionsRounding(city);
        for (int i = 0; i < city.length; i++)
        {
            for (int j = 0; j < city[i].length; j++)
            {
                System.out.print(city[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("# 2 = " + Arrays.toString(otherSides(10)));
        System.out.println("# 3 = " + rps("камень", "ножницы"));
        System.out.println("# 4 = " + warOfNumbers(new int[]{6, 10, 45, 44, 2, 7, 34, 8, 6, 90, 5, 243}));
        System.out.println("# 5 = " + reverseCase("Happy Birthday"));
        System.out.println("# 6 = " + inatorInator("programmer"));
        System.out.println("# 7 = " + doesBrickFit(1,1,1,1,1));
        System.out.println("# 8 = " + totalDistance(40, 5, 3, false));
        System.out.println("# 9 = " + mean(new double[] {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println("# 10 = " + parityAnalysis(7));

    }
}