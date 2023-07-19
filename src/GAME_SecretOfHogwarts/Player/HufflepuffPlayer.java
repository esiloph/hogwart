package GAME_SecretOfHogwarts.Player;

import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;

import java.util.ArrayList;
import java.util.Scanner;

public class HufflepuffPlayer extends Player {
    public HufflepuffPlayer(String 이름, int 풀체, int 풀마, int 경험치, int 골드, int 공격력, int 방어력, int 마법공격력) {
        super(이름, 풀체, 풀마, 경험치, 골드, 공격력, 방어력, 마법공격력);
        this.기숙사이름= "후플푸프";
    }

    @Override
    public void 기숙사출입() {
        GA.게임진행대사("수학 문제를 풀어야 기숙사 출입이 가능합니다.");
        GA.아무키나();
        // 수학 문제
        int a = (int) (Math.random() * 10) + 1;
        int b = (int) (Math.random() * 10) + 1;
        int c = (int) (Math.random() * 10) + 1;
        int 정답 = a * b + c;

        GA.게임진행대사("문제: " + a + " X " + b + " + " + c + " = ?");
        GA.게임진행대사("         정답을 입력하세요:");
        Scanner scanner = new Scanner(System.in);
        int 입력정답 = scanner.nextInt();

        if (입력정답 == 정답) {
            기숙사출입허용 = true;
            GA.게임진행대사("         어서 들어오게!!");
            GA.아무키나();
        } else {
            기숙사출입허용 = false;
            GA.게임진행대사("      틀렸어! 기숙사 출입할 수 없네!");
            GA.아무키나();
        }
    }
}


