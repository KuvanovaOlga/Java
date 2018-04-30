package by.belstu.it.kuvanova.basejava;

import static java.lang.Math.log;

public class JavaTest
{
    static int sint;

    public static void main(String[] args)
    {
        char c = 's';
        int x = 1;
        double db = 1.2;
        short y;
        byte num = 2;
        int yy = num;
        long z = 123;
        boolean bol = true;
        boolean bol1 = false;
        String str1 = "5781";
        long l;

        System.out.println(str1 + x);
        System.out.println(str1 + c);
        System.out.println(str1 + db);
        System.out.println(num + x);
        l = (long) x + 2147483647;
        System.out.println(l);
        System.out.println(sint);
        boolean boll;
        boll = bol && bol1;//«И». Если оба операнда являются не равны нулю, то условие становится истинным
        boll = bol ^ bol1;//побитовое логическое или копирует бит, если он установлен в одном операнде, но не в обоих.

        long f = 0x7fff_ffff_fffL;  //// Постфикс l или L обозначает литералы типа long(будет сохраняться в длинном формате типа long)

        char ch = 'a'; //символьные литералы
        char ch1 = '\u0061';//16-битовые знач,кот можно преобраз. в целые числа и к ним можн применять операроты целочисл. матры
        char ch2 = 97;
        System.out.println(ch);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch + ch1 + ch2);
        System.out.println(3.45 % 2.4);
        System.out.println(1.0 / 0.0);//NaN - результат деления ноль на ноль?не число
        System.out.println(0.0 / 0.0);
        System.out.println(log(-345));
        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));
        //В каких системах счисления можно записывать целые константы? 10, 8(начиная с 0), 16ая(начиная с 0X),хранятся в инт
    }
}