package filereconciler;

public class SimpleFileEquator implements Equator<FileDetail> {

    @Override
    public boolean equates(FileDetail firstFileDetail, FileDetail secondFileDetail) {
        return firstFileDetail.size() == secondFileDetail.size()
                && firstFileDetail.name().equals(secondFileDetail.name());
    }
}
