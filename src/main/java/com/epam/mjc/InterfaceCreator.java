package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String iter : x) {
                if (!Character.isUpperCase(iter.charAt(0)))
                    return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> added = new ArrayList<>();
            for (Integer iter : x) {
                if (iter % 2 == 0) {
                    added.add(iter);
                }
            }
            x.addAll(added);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> removal = new ArrayList<>();
            for (String iter : values) {
                if (!(Character.isUpperCase(iter.charAt(0))) || !iter.endsWith(".") || iter.split(" ").length <= 3) {
                    removal.add(iter);
                }
            }
            values.removeAll(removal);
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for (String iter : x) {
                result.put(iter, iter.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return new ArrayList(list1);
        };
    }
}
