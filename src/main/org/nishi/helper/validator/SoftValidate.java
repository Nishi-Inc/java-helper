package org.nishi.helper.validator;

/**
 * Simple validation methods. Designed for jsoup internal use
 * @author Nishi Inc.
 * @since v1.0.0
 */
public final class SoftValidate {

    // Singleton
    private SoftValidate() {}

    /**
     * Validates that the object is null
     * @param obj object to test
     */
    public static boolean isNull(Object obj) {
        return !SoftValidate.notNull(obj);
    }

    /**
     * Validates that the object is not null
     * @param obj object to test
     */
    public static boolean notNull(Object obj) {
        if (obj == null) {
            return false;
        }
        return true;
    }

    /**
     * Validates that the value is true
     * @param val object to test
     */
    public static boolean isTrue(boolean val) {
        if (!val) {
            return false;
        }
        return true;
    }

    /**
     * Validates that the value is false
     * @param val object to test
     */
    public static boolean isFalse(boolean val) {
        return !SoftValidate.isTrue(val);
    }

    /**
     * Validates that the array contains no null elements
     * @param objects the array to test
     */
    public static boolean noNullElements(Object[] objects) {
        for (Object obj : objects) {
            if (SoftValidate.isNull(obj)) {
                return false;
            }
        }
        return true;
    }

}
