package filereconciler;

public class SimpleFileMatcher {

    public boolean matches(FileDetail firstFileDetail, FileDetail secondFileDetail) {
        return firstFileDetail.size() == secondFileDetail.size()
                && firstFileDetail.name().equals(secondFileDetail.name());
    }
}
