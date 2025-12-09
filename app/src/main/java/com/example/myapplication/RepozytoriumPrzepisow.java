package com.example.myapplication;

import java.util.ArrayList;

public class RepozytoriumPrzepisow {

    private static ArrayList<Przepis> przepisy;

    private static void generujPrzepisy() {
        if(przepisy !=null) return;
        Przepis.setLicznikPrzepisow(0);
        przepisy = new ArrayList<>();
        przepisy.add(new Przepis("Pizza", "Kuchnia Wloska", R.drawable.pizza, "maka, drodze, woda, sol, pomidory, ser", "wyrosnij drodze, wyrob ciasto, dodaj skladniki na gore",1));
        przepisy.add(new Przepis("Bento Box", "Kuchnia Japonska", R.drawable.bento_box, "ryz, niggiri, sos rybny, sos sojowy, kurczak, maka, przyprawy", "ugotuj ryz w szybkowarze, dodaj sos sojowy, kurczaka pokroj i zapanieruj",2));
        przepisy.add(new Przepis("Zeberka Wieprzowe", "BBQ", R.drawable.pork_ribs, "zeberka wieprzowe, sos BBQ, dry rub, miod, whisky", "zeberka zamarynuj przez 24h, dodaj suche przyprawy na gore i piecz przez conajmiej 8h",3));
        przepisy.add(new Przepis("Ciasteczka z dżemem", "Desery", R.drawable.jam_cookies, "dżem wyboru, maka do ciast, cukier bialy/brazowy, woda, jajka", "wyrob ciasto, schlodz a nastepnie piecz prze 30 minut, dodaj dzem i schlodz w lodowce przez conajmiej 2h",4));
        przepisy.add(new Przepis("Czekolada", "Desery", R.drawable.chocolate, "kakao, mleko, cukier, maslo", "dodaj mleko cukie i rozpuszczone maslo do kakao, wszystko razem gotuj w kapieli wodnej i schlodz przez 24h w zamrazalce",5));
    }

    public static ArrayList<Przepis> getPrzepisy() {
        generujPrzepisy();
        return przepisy;
    }
    public static Przepis zwrocPrzepisOId(int id){
        generujPrzepisy();
        for (Przepis przepis: przepisy){
            if(przepis.getIdPrzepisu()== id ){
                return przepis;
            }
        }
        return przepisy.get(0);
    }
    public static ArrayList<Przepis> ZwrocPrzepisyKategori(String kategoria){
        ArrayList<Przepis> przepisyZKategori = new ArrayList<>();
        generujPrzepisy();
        for(Przepis przepis : przepisy) {
            if(przepis.getKategoria().equals(kategoria)){
                przepisyZKategori.add(przepis);
            }
        }
        return przepisyZKategori;
    }
}
