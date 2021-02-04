package com.aminhjz.interview.urlshortener.utils;

public class Base62Utils {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();

    public static String to(Long base10) {
        StringBuilder sb = new StringBuilder("");
        if (base10 == 0){
            return "a";
        }
        while (base10 > 0){
            base10 = to(base10, sb);
        }
        return sb.reverse().toString();
    }

    private static Long to(Long id, final StringBuilder sb){
        Long rem = id % BASE;
        sb.append(ALPHABET.charAt(rem.intValue()));
        return id / BASE;
    }

    public static Long from(String base64){
        return from(new StringBuilder(base64).reverse().toString().toCharArray());
    }

    private static Long from(char[] chars) {
        long res = 0l;
        for (int i = chars.length - 1; i >= 0; i--){
            res += from(ALPHABET.indexOf(chars[i]), i);
        }

        return res;
    }


    private static Long from(int n, int pow){
        return n *  (long) Math.pow(BASE, pow);
    }
}
