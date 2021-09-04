package filereconciler;

public interface Equator<T> {
    boolean equates(T firstFileDetail, T secondFileDetail);
}
