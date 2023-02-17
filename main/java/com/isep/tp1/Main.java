package com.isep.tp1;

public static boolean isBinarySumInArray(int[] integers, int val) {
        Set<Integer> seen = new HashSet<>();

        for (int i : integers) {
        if (seen.contains(val - i)) {
        return true;
        }
        seen.add(i);
        }

        return false;
        }

}