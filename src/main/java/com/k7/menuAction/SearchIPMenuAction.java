package com.k7.menuAction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchIPMenuAction implements MenuAction {
    @Override
    public void doAction() {
        String text = "Итого, 192.168.5.0/24 означает диапазон адресов\n" +
                "хостов от 192.168.5.1 до192.168.5.254, а также 192.168.5.0 — адрес\n" +
                "сети и 192.168.5.255 — широковещательный адрес сети.В сети 192.168.5.0\n" +
                "с маской 255.255.255.0 пакет с адресом\n" +
                "192.168.5.255 доставляется всем узлам этой сети. 10.121.30.11";
        System.out.println(text);
        System.out.println("---------Search result----------");
        String regex = "\\d{1,3}\\w[.]\\d{1,3}\\w[.]\\d{1,3}\\W\\d{1,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find())
            System.out.println(matcher.group());
        System.out.println("---------------------------------");


    }

    @Override
    public String getName() {
        return "Search IP";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
