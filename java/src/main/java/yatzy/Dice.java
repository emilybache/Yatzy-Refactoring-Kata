package yatzy;

import java.util.List;

public record Dice(int d1, int d2, int d3, int d4, int d5 ) {
public List<Integer> getRollAsList(){
    return List.of(d1,d2,d3,d4,d5);
}
public int sum(){
    return this.getRollAsList().stream().mapToInt(x->x).sum();
}

    public boolean areAllTheSame() {
    return  this.getRollAsList().stream().allMatch(getRollAsList().get(0)::equals);
    }
    public int getSumOfNumbersXInDiceWhenPlacedOnCategoryX(int x) {
        return Math.toIntExact(getRollAsList()
            .stream()
            .filter(number -> number == x)
            .count() * x);
    }
}
