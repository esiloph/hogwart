package GAME_SecretOfHogwarts.Info;

import GAME_SecretOfHogwarts.GameProcess.GameLogic;
import GAME_SecretOfHogwarts.Player.Player;

public class Calculation {
    public void 체력증가계산(Player player){
        if(player.풀체-GameLogic.초기풀체>=0){
            System.out.println("+"+Math.abs(player.풀체-GameLogic.초기풀체));
        }else {
            System.out.println("-"+Math.abs(player.풀체-GameLogic.초기풀체));
        }
    }
    public void 마력증가계산(Player player){
        if(player.풀마-GameLogic.초기풀마>=0){
            System.out.println("+"+Math.abs(player.풀마-GameLogic.초기풀마));
        }else {
            System.out.println("-"+Math.abs(player.풀마-GameLogic.초기풀마));
        }
    }
    public void 공격력증가계산(Player player){
        if(player.공격력-GameLogic.초기공격력>=0){
            System.out.println("+"+Math.abs(player.공격력-GameLogic.초기공격력));
        }else {
            System.out.println("-"+Math.abs(player.공격력-GameLogic.초기공격력));
        }
    }
    public void 방어력증가계산(Player player){
        if(player.방어력-GameLogic.초기방어력>=0){
            System.out.println("+"+Math.abs(player.방어력-GameLogic.초기방어력));
        }else {
            System.out.println("-"+Math.abs(player.방어력-GameLogic.초기방어력));
        }
    }
    public void 마법공격력증가계산(Player player){
        if(player.마법공격력-GameLogic.초기마법공격력>=0){
            System.out.println("+"+Math.abs(player.마법공격력-GameLogic.초기마법공격력));
        }else {
            System.out.println("-"+Math.abs(player.마법공격력-GameLogic.초기마법공격력));
        }
    }

}
