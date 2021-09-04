package filereconciler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeepFileEquatorTest {
    DeepFileEquator validDependenciesFileEquator;
    DeepFileEquator invalidDependenciesFileEquator;

    @BeforeEach
    void beforeEach() {
        validDependenciesFileEquator = new DeepFileEquator((l,r)->true);
        invalidDependenciesFileEquator = new DeepFileEquator((l,r)->false);
    }

    @Test
    void equates_invalidDependenciesChecksumsMatch_false() {
        FileDetail first = createFileDetailWithCheckSum(1234L);
        FileDetail second = createFileDetailWithCheckSum(1234L);

        assertThat(invalidDependenciesFileEquator.equates(first,second)).isFalse();
    }

    @Test
    void equates_invalidDependenciesChecksumsDifferent_false() {
        FileDetail first = createFileDetailWithCheckSum(1234L);
        FileDetail second = createFileDetailWithCheckSum(1234L);

        assertThat(invalidDependenciesFileEquator.equates(first,second)).isFalse();
    }

    @Test
    void equates_validDependenciesChecksumsMatch_true() {
        FileDetail first = createFileDetailWithCheckSum(1234L);
        FileDetail second = createFileDetailWithCheckSum(1234L);

        assertThat(validDependenciesFileEquator.equates(first,second)).isTrue();
    }

    @Test
    void equates_validDependenciesChecksumsDifferent_false() {
        FileDetail first = createFileDetailWithCheckSum(1234L);
        FileDetail second = createFileDetailWithCheckSum(4444L);

        assertThat(validDependenciesFileEquator.equates(first,second)).isFalse();
    }

    private FileDetail createFileDetailWithCheckSum(long checksum) {
        return new FileDetail("name", 1111L, true, checksum);
    }
}