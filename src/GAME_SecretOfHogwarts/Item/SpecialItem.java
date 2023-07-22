package GAME_SecretOfHogwarts.Item;

import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpellList;
import GAME_SecretOfHogwarts.Player.Player;

public class SpecialItem extends UniqueItem {
    public int 체력증가, 마력증가, 공격력증가, 방어력증가, 마법공격력증가;
    public String 적용기숙사;
    MagicSpell 마법주문추가;
    public SpecialItem(String 아이템이름, int 아이템가격, String 아이템등급, int 체력증가, int 마력증가, int 공격력증가, int 방어력증가, int 마법공격력증가, String 적용기숙사, MagicSpell 마법주문추가) {
        super(아이템이름, 아이템가격, 아이템등급, 체력증가, 마력증가, 공격력증가, 방어력증가, 마법공격력증가);
        this.체력증가 = 체력증가;
        this.마력증가 = 마력증가;
        this.공격력증가 = 공격력증가;
        this.방어력증가 = 방어력증가;
        this.마법공격력증가 = 마법공격력증가;
        this.적용기숙사=적용기숙사;
        this.마법주문추가=마법주문추가;
    }

    @Override
    public void 능력치향상정보() {
        GA.게임진행대사(아이템이름+"을 착용했다.\n"+
                "               체력 "+체력증가*100+"% 만큼 증가했다.\n"+
                "               마력 "+마력증가*100+"% 만큼 증가했다.\n" +
                "               공격력 "+공격력증가*100+"% 만큼 증가했다.\n" +
                "               방어력 "+방어력증가*100+"% 만큼 증가했다.\n" +
                "               마법공격력 "+마법공격력증가*100+"% 만큼 증가했다.");
        GA.아무키나();
        GA.게임진행대사("         강력한 힘이 느껴진다 !!!");
        GA.아무키나();
    }
    public void 마법주문추가(Player player){
        if(player.기숙사이름.equals(적용기숙사)){
            player.마법주문슬롯.add(마법주문추가);
            GA.게임진행대사("이제부터 "+마법주문추가.이름+"마법을 사용할 수 있습니다.");
        }else{
            GA.게임진행대사("아무 능력도 발현하지 않았습니다. (플레이어와 알맞지 않은 기숙사)");
        }
        GA.아무키나();
    }
    public void 마법주문제거(Player player){
        if (player.마법주문슬롯.contains(마법주문추가)) {
            player.마법주문슬롯.remove(마법주문추가);
            GA.게임진행대사("스페셜 아이템의 효과가 사라집니다.");
        }
        GA.아무키나();

    }
}
