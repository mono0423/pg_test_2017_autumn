package jp.pgtest_autumn.main;

import java.util.Scanner;

import jp.pgtest_autumn.controller.PhoneController;

/**
 * 実行クラス。(※修正不要)
 *
 * @author SYS Takahiro Mitsuoka
 */
public class Main {

	/** スキャナー */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * メインメソッド。(※修正不要)
	 *
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {

		/* コントローラを生成し、標準入力をコントローラに渡す */
		PhoneController controller = new PhoneController();

		while (true) {

			/* ボタン名入力 */
			System.out.println("\n【システム】------------------------------------");
			System.out.println("【システム】  ボタン名を入力してください。");
			System.out.print("【システム】    →");

			String input = scanner.nextLine();

			if (input.isEmpty()) {
				input = "(空文字)";
			}

			System.out.println("【システム】------------------------------------");
			System.out.println("【システム】  " + input + " が入力されました。");
			System.out.println("【システム】------------------------------------\n");

			/* ボタン名をコントローラに渡す */
			controller.exe(input);
		}
	}
}

