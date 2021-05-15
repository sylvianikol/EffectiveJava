package com.syn.item14_comparable;

import java.util.Comparator;

import static java.util.Comparator.comparingInt;

public class PhoneNumber implements Comparable<PhoneNumber> {

    private static final Comparator<PhoneNumber> COMPARATOR =
            comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    private final short areaCode;
    private final short prefix;
    private final short lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line number");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }

        return (short) val;
    }

    @Override
    public int compareTo(PhoneNumber phoneNumber) {
        // Multiple-field Comparable with primitive fields

        int result = Short.compare(areaCode, phoneNumber.areaCode);

        if (result == 0) {
            result = Short.compare(prefix, phoneNumber.prefix);
            if (result == 0) {
                result = Short.compare(lineNum, phoneNumber.lineNum);
            }
        }

//        return result;

        // Comparable with comparator construction methods
        return COMPARATOR.compare(this, phoneNumber);
    }


}
