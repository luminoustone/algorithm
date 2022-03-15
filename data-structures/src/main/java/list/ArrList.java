package list;

import java.util.NoSuchElementException;

public class ArrList<E> {

    private E a[];      // 리스트의 항목들을 저장할 배열
    private int size;   // 리스트의 항목 수

    public ArrList() {  // 생성자
        this.a = (E[]) new Object[1];   // 최초로 1개의 원소를 가진 배열 생성
        this.size = 0;                  // 항목 숙를 0으로 초기화
    }

    public E peek(int k) {  // k번째 항목을 리턴, 단순히 읽기만 한다.
        if (size == 0) {
            throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
        }
        return a[k];
    }

    public void insertLast(E newItem) {
        if (size == a.length) {     // 배열에 빈 공간이 없으면 배열 크기 확장
            resize(2 * a.length);
        }
        a[size++] = newItem;        // 새 항목 삽입
    }

    public void insert(E newItem, int k) {  // 새 항목을 k-1번째 항목 다음에 삽입
        if (size == a.length) {
            resize(2 * a.length);
        }
        for (int i = size - 1; i >= k; i--) {   // 한칸씩 뒤로 이동
            a[i + 1] = a[i];
        }
        a[k] = newItem;
        size++;
    }

    private void resize(int newSize) {      // 배열 크기 조절
        Object[] t = new Object[newSize];   // newSize 크기의 새로운 배열 t 생성
        for (int i = 0; i < size; i++) {
            t[i] = a[i];                    // 배열 s를 배열 t로 복사
        }
        a = (E[]) t;                        // 배열 t를 배열 s로
    }
}
