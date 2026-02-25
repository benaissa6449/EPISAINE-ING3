package fr.upec.sirius.episaine.episaine_generate_notification.utils;

public class Utils {
    public static boolean hasbeen24h(long epochSeconds) {
        long now = System.currentTimeMillis() / 1000;
        return (now - epochSeconds) >= 24 * 3600;
    }
}
