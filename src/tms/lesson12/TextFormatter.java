package tms.lesson12;

public class TextFormatter {
    public static boolean wordCount(String[] strings) {
        return strings.length >= 3 && strings.length <= 5;
    }

    public static boolean isThereAPalindrome(String[] strings) {
        for (String string : strings) {
            if (string.length() > 1 && string.equalsIgnoreCase(new StringBuilder(string).reverse().toString())) {
                return true;
            }
        }
        return false;
    }
}
