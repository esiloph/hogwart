package GAME_SecretOfHogwarts.Item;

public class RareItem extends Item {
    public int 체력증가, 마력증가 ,공격력증가, 방어력증가;

    public RareItem(String 아이템이름, int 아이템가격, String 아이템등급, int 체력증가, int 마력증가, int 공격력증가, int 방어력증가) {
        super(아이템이름, 아이템가격, 아이템등급);
        this.체력증가 = 체력증가;
        this.마력증가 = 마력증가;
        this.공격력증가 = 공격력증가;
        this.방어력증가 = 방어력증가;
    }

    @Override
    public void 능력치향상정보() {
        GA.게임진행대사(아이템이름+"을 착용했다\n" +
                "               체력 "+체력증가+" 만큼 증가했다.\n"+
                "               마력 "+마력증가+" 만큼 증가했다.\n" +
                "               공격력 "+공격력증가+" 만큼 증가했다.\n" +
                "               공격력 "+방어력증가+" 만큼 증가했다.");
        GA.아무키나();
    }
}
