package org.apluscreators.com;

public class SystemInfo {

    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }
    public static String applicationName() {
        return "Uchambuzi Analytics";
    }

}