package GAME_SecretOfHogwarts.Item;

import GAME_SecretOfHogwarts.GameProcess.GameAssist;

public abstract class Item {
    GameAssist GA = new GameAssist();
    public String 아이템이름,아이템등급;
    public int 아이템가격;

    public Item(String 아이템이름, int 아이템가격, String 아이템등급) {
        this.아이템이름 = 아이템이름;
        this.아이템가격 = 아이템가격;
        this.아이템등급 = 아이템등급;
    }
    public abstract void 능력치향상정보();
}
