package com.example.jora.test.utils;

import java.lang.reflect.Field;
import java.util.Arrays;

public class EnumUtil {
    public static <E extends Enum> Enum parseByValue(Class<E> sourceEnum, Object value, String reflectiveFieldName) {
        Enum[] enumConstants = sourceEnum.getEnumConstants();
        return Arrays.stream(enumConstants).filter(anEnum -> {
            try {
                Field declaredField = anEnum.getClass().getDeclaredField(reflectiveFieldName);
                declaredField.setAccessible(true);
                Object object = declaredField.get(anEnum);
                return object.equals(value);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return false;
        })
                .findAny()
                .get();
    }
}
