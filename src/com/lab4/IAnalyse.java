package com.lab4;

/** Интерфейс, производящий анализ строки */
@FunctionalInterface
public interface IAnalyse {

  /**
   * Абстрактный метод, который может быть реализован для различного анализа строки
   * @param str строка для анализа
   * @return результат анализа строки
   */
  int analyse(String str);

}
