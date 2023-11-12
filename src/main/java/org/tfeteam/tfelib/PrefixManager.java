package org.tfeteam.tfelib;

public class PrefixManager {
    private static String prefix;

    public static void setPrefix(String prefix){
        PrefixManager.prefix = prefix;
    }

    public static String getPrefix(){
        return prefix;
    }
}
