import java.util.HashSet;
import java.util.Set;

public class exo3 {
    public boolean isBinarySumInArray(int[] integers,int val) {
        Set<Integer> seen = new HashSet<>();

        for (int i :integers){
            if (seen.contains(val - 1)){
                return true;
            }
            seen.add(i);
        }
        return false;
    }
}


