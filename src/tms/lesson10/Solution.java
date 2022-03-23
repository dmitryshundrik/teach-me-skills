package tms.lesson10;

public class Solution {
    public static void main(String[] args) {
        test1("i like java");
        test2("шалаш");
        test3("Очень немного требуется, чтобы уничтожить человека: стоит лишь убедить его в том, что дело, которым он занимается, никому не нужно.");
        test4("Русский весьма часто смеется там, где надо плакать.");
        test5("Человек ищет не столько бога, сколько чудес.");
        test6();
        test7("Братья", "Карамазовы");
    }

    private static void test1(String string) {
        System.out.println(string.charAt(string.length() - 1));
        System.out.println(string.endsWith("!!!"));
        System.out.println(string.startsWith("i like"));
        System.out.println(string.contains("java"));
        System.out.println(string.indexOf("j"));
        System.out.println(string.replaceAll("a", "o"));
        System.out.println(string.toUpperCase());
        System.out.println(string.toLowerCase());
        System.out.println(string.substring(7));
    }

    public static void test2(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        StringBuilder reversString = stringBuilder.reverse();
        if (stringBuilder.toString().equalsIgnoreCase(reversString.toString())) {
            System.out.println(string);
        }
    }

    public static void test3(String string) {
        String str = string.replaceAll(",", "");
        str = str.replaceAll("\\:", "");
        str = str.replaceAll("\\.", "");

        String[] strings = str.split(" ");

        for (String value : strings) {
            if (value.length() > 3 && value.length() <= 5) {
                System.out.print(value + " ");
            }
        }
        System.out.println();
    }

    public static void test4(String string) {
        String str = string.replaceAll(",", "");
        str = str.replaceAll("\\.", "");

        String[] strings = str.split(" ");
        String minString = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() < minString.length()) {
                minString = strings[i];
            }
        }
        System.out.println(minString);
    }

    public static void test5(String string) {
        String str = string.replaceAll(",", "");
        str = str.replaceAll("\\.", "");

        String[] strings = str.split(" ");
        String maxString = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > maxString.length()) {
                maxString = strings[i];
            }
        }
        System.out.println(maxString);
    }

    public static void test6() {
        System.out.println(new StringBuilder("3").append("+").append("56").append("=").append("59").toString());
        System.out.println(new StringBuilder("3").append("-").append("56").append("=").append("-53").toString());
        System.out.println(new StringBuilder("3").append("*").append("56").append("=").append("168").toString());
    }

    public static void test7(String string1, String string2) {
        System.out.println(string1.substring(0, string1.length() / 2) + string2.substring(string2.length() / 2));
    }
}
