package filereconciler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleFileEquatorTest {

    SimpleFileEquator fileEquator;

    @BeforeEach
    void beforeEach() {
        fileEquator = new SimpleFileEquator();
    }

    @Test
    void equates_nameDifferentSizeDifferent_noMatch() {
        FileDetail firstFile = createFileDetail("name1", 0L);
        FileDetail secondFile = createFileDetail("name2", 111L);

        assertThat(fileEquator.equates(firstFile, secondFile)).isFalse();
    }

    @Test
    void equates_nameDifferentSizeMatch_noMatch() {
        FileDetail firstFile = createFileDetail("name1", 111L);
        FileDetail secondFile = createFileDetail("name2", 111L);

        assertThat(fileEquator.equates(firstFile, secondFile)).isFalse();
    }

    @Test
    void equates_nameMatchesSizeDifferent_noMatch() {
        FileDetail firstFile = createFileDetail("name", 0L);
        FileDetail secondFile = createFileDetail("name", 111L);

        assertThat(fileEquator.equates(firstFile, secondFile)).isFalse();
    }

    @Test
    void equates_nameAndSizeSame_matches() {
        FileDetail firstFile = createFileDetail("name", 111L);
        FileDetail secondFile = createFileDetail("name", 111L);

        assertThat(fileEquator.equates(firstFile, secondFile)).isTrue();
    }

    private FileDetail createFileDetail(String name, long size) {
        return new FileDetail(name, size, false, 0);
    }
}