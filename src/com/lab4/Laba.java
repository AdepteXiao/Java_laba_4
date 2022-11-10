package com.lab4;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Класс запуска программы
 */
public class Laba {
  public static void main(String[] args) {

    UI myUI = new UI();

    myUI.menu();
  }

}


/**
 * Интерфейс, реализующий нумерацию вариантов выбора для switch()
 */
interface menuEnum {

  int INPUT_STRING = 1,
      PRINT_STRING = 2,
      GET_VOWELS_COUNT = 3,
      GET_CONSONANTS_COUNT = 4,
      EXIT = 5;
}

/**
 * Основной класс интерфейса
 */
class UI implements menuEnum {

  /**
   * Поток вывода, поддерживающий русские символы
   */
  private final PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8);

  /**
   * Экземпляр класса содержащего методы ввода разных типов
   */
  private final Inputer inp = new Inputer();

  /**
   * Строка для анализа на количество гласных и согласных
   */
  String strToAnalyse = null;

  /**
   * Метод основного меню работы
   */
  public void menu() {

    int choice;

    do {
      this.out.println("""
          1. Ввести строку
          2. Вывести строку
          3. Вывести количество гласных
          4. Вывести количество согласных
          5. Выход
          """);

      choice = inp.getInt();
      switch (choice) {
        case INPUT_STRING -> getString();
        case PRINT_STRING -> printStr();
        case GET_VOWELS_COUNT -> printVowelsCount();
        case GET_CONSONANTS_COUNT -> printConsonantsCount();
        default -> {
          if (choice != EXIT) {
            this.out.println("Неверный ввод");
          }
        }
      }

    } while (choice != EXIT);

  }

  /**
   * Метод получения строки
   */
  private void getString(){
    String newStr = inp.getString();
    if (newStr == null){
      out.println("Неверный ввод");
    }
    this.strToAnalyse = newStr;
  }

  /**
   * Метод проверки строки на вводе
   * @return true, если строка задана, false в обратном случае
   */
  private boolean checkStr(){
    return this.strToAnalyse != null;
  }

  /**
   * Метод вывода строки
   */
  private void printStr(){
    if (checkStr()){
      out.println(this.strToAnalyse);
    } else {
      out.println("Вы не ввели строку");
    }
  }

  /**
   * Метод вывода количества гласных
   */
  private void printVowelsCount(){
    if (checkStr()){
      out.printf("Количество гласных: %d\n", new VowelsGetter().analyse(this.strToAnalyse));
    } else {
      out.println("Вы не ввели строку");
    }
  }

  /**
   * Метод вывода количества согласных
   */
  private void printConsonantsCount(){
    if (checkStr()){
      out.printf("Количество согласных: %d\n", new ConsonantsGetter().analyse(this.strToAnalyse));
    } else {
      out.println("Вы не ввели строку");
    }
  }

}