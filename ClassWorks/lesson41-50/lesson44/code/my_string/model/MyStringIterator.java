package my_string.model;

import java.util.Iterator;

public class MyStringIterator implements Iterator <Character> {

    private StringBuilder str;
    private int size;
    private int currentPosition;

    public MyStringIterator(StringBuilder str){
        this.str = str;
        size = str.length();
      //  currentPosition = 0;
    }


    @Override //проверяет есть ли следующий
    public boolean hasNext() {
        return currentPosition < size;
    }

    @Override //возвращает элемент
    public Character next() {
      Character currCharacter = str.charAt(currentPosition);
      currentPosition++;
      return currCharacter;
    }

    @Override
    public void remove() {
        str.deleteCharAt(--currentPosition);
        size--;
    }
}
