package yatzyGameCategories.Impl.specialCategories;

import yatzyGameCategories.famillyCategories.DoublonsFamilyCategory;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FullHouseGameCategory extends DoublonsFamilyCategory {
    @Override
    public int calculateScore(List<Integer> dices) {
        List<Integer> allDoublons = dices.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(element -> element.getValue()>=2)
            .map(element -> (int) (element.getKey() * element.getValue()))
            .collect(Collectors.toList());
        return allDoublons.size() == 2 ? allDoublons.stream().mapToInt(i->i).sum(): 0;
    }
}
