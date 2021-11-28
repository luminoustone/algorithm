package list;

import java.util.NoSuchElementException;

public class ArrList <E> {
    private E a[];      // 리스트의 항목들을 저장할 배열
    private int size;   // 리스트의 항목 수

    public ArrList() {  // 생성자
        this.a = (E[]) new Object[1];   // 최초로 1개의 원소를 가진 배열 생성
        this.size = 0;                  // 항목 숙를 0으로 초기화
    }

    public E peek(int k) {  // k번째 항목을 리턴, 단순히 읽기만 한다.
        if ( size == 0 )
            throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
        return a[k];
    }
}
