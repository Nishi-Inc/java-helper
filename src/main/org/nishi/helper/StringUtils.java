package org.nishi.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Nishi Inc
 * @since v0.0.1
 */
public final class StringUtils extends org.apache.commons.lang3.StringUtils {

    // Singleton
    private StringUtils(){}

    /**
     *
     * @param strings
     * @return <code>true</code> if all of the given strings are null or containing of only whitespaces else <code>false</code>
     */
    public static boolean isBlank(CharSequence[]  strings) {
        for(CharSequence str : strings) {
            if(org.apache.commons.lang3.StringUtils.isBlank(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param strings
     * @return <code>true</code> if all of the given string is not null or not containing of only whitespaces else <code>false</code>
     */
    public static boolean isNotBlank(CharSequence[] strings) {
        return !StringUtils.isBlank(strings);
    }

    /**
     * <code>BETA</code> to be used with caution
     * @param str
     * @param reg
     * @return String chopped from the given regex
     */
    public static String chop(String str, String reg) {
        if(StringUtils.isBlank(reg)) {
            return str;
        }

        String[] strArray = str.split(reg);
        if(StringUtils.isBlank(strArray[strArray.length-1])) {
            strArray[strArray.length-1] = null;
        }
        StringBuilder result = new StringBuilder(strArray[0]);
        for(int i=1; i<strArray.length; i++) {
            result.append(reg + strArray[i]);
        }
        return result.toString();
    }

    /**
     *
     * @param charList
     * @param repeatingString
     * @return
     */
    public static String combine(List<Character> charList, String repeatingString) {
        List<CharSequence> strList = new ArrayList<CharSequence>();
        StringBuilder strBuilder = new StringBuilder();
        for(Character dummy : charList) {
            strBuilder.delete(0, strBuilder.length());
            strBuilder.append(dummy);
            strList.add(strBuilder.toString());
        }
        return StringUtils.combine(strList, repeatingString);
    }



    /**
     *
     * @param strList
     * @param repeatingString
     * @return
     */
    public static String combine(Collection<? extends CharSequence> strList, String repeatingString) {
        StringBuilder result = new StringBuilder();
        for(CharSequence charSequence : strList) {
            result.append(charSequence + repeatingString);
        }
        return StringUtils.chop(result.toString(), repeatingString);
    }

    /**
     *
     * @param strArray An array containing elements of any subclass of CharSequence
     * @param repeatingString String to be inserted between each element of array
     * @param <E extends Char>
     * @return Combines the fragments in a single string. strArray ["ab", "ba"] with repeatingString "the" would <br/>
     * return "abtheba"
     */
    public static <E extends CharSequence> String combine(E[] strArray, String repeatingString) {
        StringBuilder result = new StringBuilder(strArray[0]);
        for(int i=1; i<strArray.length; i++) {
            result.append(repeatingString + strArray[i]);
        }
        return result.toString();
    }
}
