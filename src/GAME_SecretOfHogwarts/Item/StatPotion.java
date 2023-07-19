package GAME_SecretOfHogwarts.Item;

public class StatPotion extends Potion{
    int 공격력증가, 방어력증가, 마법공격력증가;

    public StatPotion(String 아이템이름, int 아이템가격, String 아이템등급, String 포션종류, int 공격력증가, int 방어력증가, int 마법공격력증가) {
        super(아이템이름, 아이템가격, 아이템등급, 포션종류);
        this.공격력증가 = 공격력증가;
        this.방어력증가 = 방어력증가;
        this.마법공격력증가 = 마법공격력증가;
    }

    @Override
    public void 능력치향상정보() {
        GA.게임진행대사(아이템이름+"을 착용했다.\n"+
                "               공격력 "+공격력증가+" 만큼 증가했다.\n" +
                "               방어력 "+방어력증가+" 만큼 증가했다.\n" +
                "               마법공격력 "+마법공격력증가+" 만큼 증가했다.");
        GA.아무키나();
    }
}
