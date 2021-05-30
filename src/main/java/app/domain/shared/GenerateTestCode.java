package app.domain.shared;

public class GenerateTestCode {
    private static final long MAXNUMTEST = 1000000000000L;

    private final String code;

    public GenerateTestCode(long numTests) {
        this.code = generateTestCode(numTests);
    }

    private String generateTestCode(long numTests) {
        long num = numTests;
        if(num + 1 == MAXNUMTEST) {
            throw new IllegalArgumentException("Reached maximum number of Tests.");
        }
        // acrescentar zeros entre as letras e o numero
        String fillZeros = "";
        for (int i=0;i< 12;i++) {

            if (num % 10 == 0) {
                fillZeros += "0";
            }
            num = num / 10;
        }
        return fillZeros + "" + (numTests + 1);
    }

    public String getCode() {
        return this.code;
    }

}

