
package GAME_SecretOfHogwarts.Item;

public class Potion extends Item{
    String 포션종류;

    public Potion(String 아이템이름, int 아이템가격, String 아이템등급, String 포션종류) {
        super(아이템이름, 아이템가격, 아이템등급);
        this.포션종류 = 포션종류;
    }


    public void 능력치향상정보() {}

}
