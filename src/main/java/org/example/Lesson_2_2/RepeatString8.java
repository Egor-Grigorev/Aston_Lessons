package homework2_2;

public class RepeatString8 {
    public static void repeatString(String text, int count) {
        for(int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    public static void main(String[] args) {
        repeatString("Hello world!!!", 6);
    }
}
