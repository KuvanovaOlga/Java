package by.belstu.it.kuvanova;

import java.util.Objects;

public class WrapperString {
    private String str;

    @Override
    public String toString() {
        return "WrapperString{" + "str='" + str + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {

        return Objects.hash(str);
    }

    public WrapperString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void replace(char oldchar, char newchar) {
        char old = oldchar;
        char neww = newchar;

        System.out.println(old + neww);
    }

    public void anonim() {
        WrapperString w = new WrapperString(str) {
            public void replace(char oldchar, char newchar) {
                char old = '1';
                char neww = '2';
                char i;
                oldchar = old;
                newchar = neww;
                i = old;
                oldchar = neww;
                newchar = i;
                System.out.println(oldchar + " " + newchar);
            }

            public void delete(char newchar) {
              System.out.println(newchar);
            }
        };
    }
}

