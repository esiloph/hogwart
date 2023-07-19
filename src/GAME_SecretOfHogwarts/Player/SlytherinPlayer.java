package GAME_SecretOfHogwarts.Player;

import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;

import java.util.ArrayList;
import java.util.Scanner;

public class SlytherinPlayer extends Player {

    public SlytherinPlayer(String 이름, int 풀체, int 풀마, int 경험치, int 골드, int 공격력, int 방어력, int 마법공격력) {
        super(이름, 풀체, 풀마, 경험치, 골드, 공격력, 방어력, 마법공격력);
        this.기숙사이름 = "슬리데린";
    }
    public void 기숙사출입(){
        GA.게임진행대사("               암호는?");
        Scanner sc= new Scanner(System.in);
        String 입력암호=sc.nextLine();

        if(입력암호.equals(기숙사암호확정)){
            기숙사출입허용 =true;
            GA.게임진행대사("                어서 들어오게!");
            GA.아무키나();
        }else{
            기숙사출입허용=false;
            GA.게임진행대사("                당장 꺼져라!");
            GA.아무키나();
        }
    }
}
