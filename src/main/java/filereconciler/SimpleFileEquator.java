package filereconciler;

public class SimpleFileEquator {

    public boolean equates(FileDetail firstFileDetail, FileDetail secondFileDetail) {
        return firstFileDetail.size() == secondFileDetail.size()
                && firstFileDetail.name().equals(secondFileDetail.name());
    }
}
