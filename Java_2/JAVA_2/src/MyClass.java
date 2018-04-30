import by.belstu.it.kuvanova.WrapperString;
import by.belstu.it.kuvanova.hello;
public class MyClass {

    //TODO добавить
    public static void main(String[] args) {
        hello.main(args);

        WrapperString w = new WrapperString("Olga");
        w.replace('2', '1');
        w.anonim();
        /**@return какое - нибудь значение
         * @throws ошибка
         * @param args
         * */
        //Java-аннотация — в языке Java специальная форма синтаксических метаданных,
// которая может быть добавлена в исходный код.
    }
}