package yatzykata.yatzy.domain.category.model;

import yatzykata.yatzy.domain.roll.model.Roll;

public interface Category {
  int calculateScore(Roll roll);
}
