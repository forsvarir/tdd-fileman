package filereconciler;

public record DeepFileEquator(Equator<FileDetail> baseEquator) implements Equator<FileDetail> {

    @Override
    public boolean equates(FileDetail firstFileDetail, FileDetail secondFileDetail) {
        return baseEquator.equates(firstFileDetail, secondFileDetail)
                && firstFileDetail.checksum() == secondFileDetail.checksum();
    }
}
