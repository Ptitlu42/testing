
public class ISBN {
    private String isbnValue;
    private int isbnSize;

    public ISBN() {
        this.isbnValue = "";
        this.isbnSize = 0;
    }

    public ISBN(String initialISBN) {
        setISBN(initialISBN);
    }

    public void setISBN(String inputISBN) {
        String normalizedISBN = Normalize(inputISBN);
        if (isValid(normalizedISBN)) {
            this.isbnValue = inputISBN;
            this.isbnSize = getSize(normalizedISBN);
        } else {
            throw new IllegalArgumentException("Invalid ISBN");
        }
    }

    public String getISBN() {
        return this.isbnValue;
    }

    public int getSize() {
        return this.isbnSize;
    }

    public int getSize(String inputISBN) {
        return inputISBN.replaceAll("[^0-9X]", "").length();
    }

    public boolean isValid() {
        return isValid(this.isbnValue);
    }

    public boolean isValid(String inputISBN) {
        int size = getSize(inputISBN);
        if (size == 10) {
            return isValidISBN10(inputISBN);
        } else if (size == 13) {
            return isValidISBN13(inputISBN);
        }
        return false;
    }

    public String Normalize(String inputISBN) {
        return inputISBN.replaceAll("[^0-9X]", "");
    }

    private boolean isValidISBN10(String isbnToValidate) {
        if (isbnToValidate == null || isbnToValidate.length() != 10) {
            return false;
        }

        
        try {
            int total = 0;
            for (int i = 0; i < 9; i++) {
                int digit = Integer.parseInt(isbnToValidate.substring(i, i + 1));
                total += ((10 - i) * digit);
            }
            
            char lastChar = isbnToValidate.charAt(9);
            if (lastChar != 'X' && (lastChar < '0' || lastChar > '9')) {
                return false;
            }

            total += (lastChar == 'X' ? 10 : Integer.parseInt(String.valueOf(lastChar)));

            return (total % 11 == 0);
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private boolean isValidISBN13(String isbnToValidate) {
        if (isbnToValidate == null || isbnToValidate.length() != 13) {
            return false;
        }

        int total = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(isbnToValidate.charAt(i));
            total += (i % 2 == 0) ? digit : digit * 3;
        }

        int checksum = 10 - (total % 10);
        if (checksum == 10) {
            checksum = 0;
        }

        return checksum == Character.getNumericValue(isbnToValidate.charAt(12));
    }
}
