package filereconciler;

public class SimpleFileMatcher {

    public boolean matches(FileDetail left, FileDetail right) {
        return left.size() == right.size()
                && left.name().equals(right.name());
    }
}
