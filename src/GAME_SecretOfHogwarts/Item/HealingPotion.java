package GAME_SecretOfHogwarts.Item;

public class HealingPotion extends Potion{
    public int 체력회복, 마력회복;

    public HealingPotion(String 아이템이름, int 아이템가격, String 아이템등급, String 포션종류, int 체력회복, int 마력회복) {
        super(아이템이름, 아이템가격, 아이템등급, 포션종류);
        this.체력회복 = 체력회복;
        this.마력회복 = 마력회복;
    }
}
