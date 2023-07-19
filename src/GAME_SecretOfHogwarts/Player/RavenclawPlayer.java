package GAME_SecretOfHogwarts.Player;
import GAME_SecretOfHogwarts.Item.Item;
import GAME_SecretOfHogwarts.BattleProcess.MagicSpell;
import java.util.ArrayList;
import java.util.Scanner;

public class RavenclawPlayer extends Player {
    public RavenclawPlayer(String 이름, int 풀체, int 풀마, int 경험치, int 골드, int 공격력, int 방어력, int 마법공격력) {
        super(이름, 풀체, 풀마, 경험치, 골드, 공격력, 방어력, 마법공격력);
        this.기숙사이름 = "래번클로";
    }

    public void 기숙사출입() {
        Scanner scanner = new Scanner(System.in);

        //상식 문제
        String[] 문제 = {
                "현재 대한민국 대통령은 누구인가?",
                "해리포터의 라이벌 인물이며, 헤르미온느의 닥쳐 XXX는 누구일까?",
                "신비한 동물사전의 저자 뉴트 스캐맨더의 기숙사는 어디인가?",
                "용서받지 못하는 저주들 중 타인의 정신을 지배하는 주문은 무엇인가?"
        };
        String[] 정답 = {"윤석열", "말포이", "후플푸프", "임페리오"};

        // 문제 출제
        int 문제번호 = (int) (Math.random() * 문제.length);
        String 문제내용 = 문제[문제번호];
        String 정답내용 = 정답[문제번호];

        // 문제 출력
        GA.절취선(50);
        System.out.println("\n       문제: " + 문제내용+"\n\n" +
                "\n        정답을 입력하세요\n\n");
        GA.절취선(50);
        GA.중간띄우기();
        String 사용자답변 = scanner.nextLine();
        // 정답 확인
        if (사용자답변.equalsIgnoreCase(정답내용)) {
            GA.게임진행대사("               어서 들어오게");
            GA.아무키나();
            기숙사출입허용 = true;
        } else {
            GA.게임진행대사("틀렸어! 래번클로 기숙사 출입할 수 없어!!!");
            GA.아무키나();
            기숙사출입허용 = false;
        }
    }

}

