package filereconciler;

public record FileDetail(String name, long size, boolean checksumCalculated, long checksum) {
}
