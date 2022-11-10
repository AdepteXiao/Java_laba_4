package com.lab4;

import java.util.Locale;

/**
 * Класс реализации метода analyse интерфейса IAnalise
 */
public class ConsonantsGetter implements IAnalyse {

  /**
   * Метод, реализующий абстрактный метод analyse интерфейса IAnalyse,
   * находит количество согласных букв в строке
   *
   * @param strToAnalyse полученная из консоли строка
   * @return количество согласных строки
   */
  @Override
  public int analyse(String strToAnalyse) {
    IAnalyse implement = (String str) -> {
      str = str.toLowerCase(Locale.ROOT);
      int res = 0;
      for (int i = 0; i < str.length(); i++){
        if (checkIn(str.charAt(i))) {
          res++;
        }
      }
      return res;
    };
    return implement.analyse(strToAnalyse);
  }

  /**
   * Метод проверки символа строки на его наличие
   * в множестве согласных букв английского алфавите
   *
   * @return true если символ принадлежит множеству
   * согласных букв английского алфавите, иначе false
   */
  private boolean checkIn(char letter){
    String consonants = "bcdfghjklmnpqrstvwxz";
    for (int i = 0; i < consonants.length(); i++){
      if (consonants.charAt(i) == letter){
        return true;
      }
    }
    return false;
  }

}
