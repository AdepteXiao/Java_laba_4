package com.lab4;

import java.util.Locale;

/**
 * Класс реализации метода analyse интерфейса IAnalyse
 */
public class VowelsGetter implements IAnalyse{

  /**
   * Метод, реализующий абстрактный метод analyse интерфейса IAnalyse,
   * находит количество гласных букв в строке
   *
   * @param strToAnalyse полученная из консоли строка
   * @return количество гласных строки
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
   * в множестве гласных букв английского алфавите
   *
   * @return true если символ принадлежит множеству
   * гласных букв английского алфавите, иначе false
   */
  private boolean checkIn(char letter){
    String vowels = "aeiouy";
    for (int i = 0; i < vowels.length(); i++){
      if (vowels.charAt(i) == letter){
        return true;
      }
    }
    return false;
  }

}

