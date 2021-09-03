package filereconciler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleFileMatcherTest {

    SimpleFileMatcher fileMatcher;

    @BeforeEach
    void beforeEach() {
        fileMatcher = new SimpleFileMatcher();
    }

    @Test
    void nameDifferentSizeDifferent_noMatch() {
        FileDetail firstFile = createFileDetail("name1", 0L);
        FileDetail secondFile = createFileDetail("name2", 111L);

        assertThat(fileMatcher.matches(firstFile, secondFile)).isFalse();
    }

    @Test
    void nameDifferentSizeMatch_noMatch() {
        FileDetail firstFile = createFileDetail("name1", 111L);
        FileDetail secondFile = createFileDetail("name2", 111L);

        assertThat(fileMatcher.matches(firstFile, secondFile)).isFalse();
    }

    @Test
    void nameMatchesSizeDifferent_noMatch() {
        FileDetail firstFile = createFileDetail("name", 0L);
        FileDetail secondFile = createFileDetail("name", 111L);

        assertThat(fileMatcher.matches(firstFile, secondFile)).isFalse();
    }

    @Test
    void nameAndSizeSame_matches() {
        FileDetail firstFile = createFileDetail("name", 111L);
        FileDetail secondFile = createFileDetail("name", 111L);

        assertThat(fileMatcher.matches(firstFile, secondFile)).isTrue();
    }

    private FileDetail createFileDetail(String name, long size) {
        return new FileDetail(name, size);
    }
}