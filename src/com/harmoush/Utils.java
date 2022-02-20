package com.harmoush;

import com.harmoush.ds.Collection;

public class Utils {

    public static <T> void printCollection(Collection<T> collection) {
        StringBuilder builder = new StringBuilder("[");
        for (T element : collection) {
            builder.append(element).append(", ");
        }
        if (collection.isEmpty()) {
            builder.append("]");
        } else {
            int lastCommaIdx = builder.lastIndexOf(",");
            builder.replace(lastCommaIdx, lastCommaIdx + 1, "]");
        }
        System.out.println(collection.getClass().getSimpleName() + " = " + builder);

    }
}
