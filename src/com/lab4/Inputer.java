package com.lab4;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс предназначенный для получения значений с клавиатуры
 */
public class Inputer {

  private final Scanner sc = new Scanner(System.in); // Считыватель текста с клавиатуры

  /**
   * Метод получения целочисленного значения
   *
   * @return -1 если ввод некорректен, иначе число типа int
   */
  public int getInt() {
    int res;
    try {
      res = Integer.parseInt(this.sc.nextLine());
    } catch (Exception e) {
      res = -1;
    }
    return res;
  }

  /**
   * Метод получения строки
   *
   * @return null если ввод некорректен, иначе строку
   */
  public String getString() {
    String res;
    res = sc.nextLine();
    if (Objects.equals(res, "") || Objects.equals(res, "\n")) return null;
    String checkRes = res.toLowerCase(Locale.ROOT);
    for (int i = 0; i < checkRes.length(); i++) {
      if (checkIn(checkRes.charAt(i))) {
        return null;
      }
    }
    return res;
  }

  /**
   * Метод проверки символа строки на его наличие в русском алфавите
   *
   * @return true если символ есть в русском алфавите, иначе false
   */
  private boolean checkIn(char letter){
    String alph = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    for (int i = 0; i < alph.length(); i++){
      if (alph.charAt(i) == letter){
        return true;
      }
    }
    return false;
  }

}
