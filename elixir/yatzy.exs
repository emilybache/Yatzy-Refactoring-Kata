defmodule Yatzy do
  def chance(d1, d2, d3, d4, d5) do
    total = 0
    total = total + d1
    total = total + d2
    total = total + d3
    total = total + d4
    total = total + d5

    total
  end

  def yatzy(dice) do
    if Enum.all?(dice, fn die -> Enum.at(dice, 0) == die end) do
      50
    else
      0
    end
  end

  def ones( d1, d2, d3, d4, d5 ) do
    sum = 0
    sum = if d1 == 1, do: sum + 1, else: sum
    sum = if d2 == 1, do: sum + 1, else: sum
    sum = if d3 == 1, do: sum + 1, else: sum
    sum = if d4 == 1, do: sum + 1, else: sum
    sum = if d5 == 1, do: sum + 1, else: sum

    sum
  end

  def twos( d1, d2, d3, d4, d5 ) do
    sum = 0
    sum = if d1 == 2, do: sum + 2, else: sum
    sum = if d2 == 2, do: sum + 2, else: sum
    sum = if d3 == 2, do: sum + 2, else: sum
    sum = if d4 == 2, do: sum + 2, else: sum
    sum = if d5 == 2, do: sum + 2, else: sum

    sum
  end

  def threes( d1, d2, d3, d4, d5 ) do
    sum = 0
    sum =
      if d1 == 3,
        do: sum + 3,
        else: sum
    sum =
      if d2 == 3,
        do: sum + 3,
        else: sum
    sum =
      if d3 == 3,
        do: sum + 3,
        else: sum
    sum =
      if d4 == 3,
        do: sum + 3,
        else: sum
    sum =
      if d5 == 3,
        do: sum + 3,
        else: sum

    sum
  end

  def fours(dice) do
    for die <- dice do
      cond do
        die == 4 -> 4
        true -> 0
      end
    end
    |> Enum.sum()
  end

  def fives(dice) do
    Enum.reduce(Enum.filter(dice, &(&1 == 5)), 0, fn _, x -> x+5 end)
  end

  def sixes(d1,d2,d3,d4,d5), do: count_sixes([d1,d2,d3,d4,d5])

  defp count_sixes(dice) do
    dice
    |> Enum.map(fn die ->
      case die do
        6 -> 6
        _ -> 0
      end
    end)
    |> Enum.reject(fn die -> die == 0 end)
    |> Enum.sum()
  end

  def score_pair( d1, d2, d3, d4, d5 ) do
    try do
      {die, _} =
        Enum.max(
          Enum.filter(
            Enum.group_by(
              [d1, d2, d3, d4, d5],
              fn die -> die end
            ),
            fn {_k,v} ->
              length(v) >= 2
            end
          )
        )

      cond do
        die -> die * 2
        true -> 0
      end
    rescue
      Enum.EmptyError -> 0
    end
  end

  def two_pair( d1, d2, d3, d4, d5 ) do
    score = 0
    dice = []
    dice = dice ++ [d1]
    dice = dice ++ [d2]
    dice = dice ++ [d3]
    dice = dice ++ [d4]
    dice = dice ++ [d5]

    dice
    |> Enum.group_by(&(&1))
    |> Enum.filter(&(length(elem(&1,1)) >= 2))
    |> Enum.reduce(score, &(&2 + elem(&1,0)*2))
  end

  def three_of_a_kind( d1, d2, d3, d4, d5 ) do
    score = 0
    dice = [d1, [d2], [d3, d4, d5]]

    dice
    |> List.flatten()
    |> Enum.group_by(&(&1))
    |> Enum.filter(&((&1 |> elem(1) |> Enum.count()) >= 3))
    |> Enum.reduce(score, fn {die, _dice}, score ->
      score + die * 3
    end)
  end

  def four_of_a_kind(d1,d2,d3,d4,d5) do
    import List
    dice = [d1 | [d2 | [d3 | [d4 | [d5]]]]]

    {four_of_a_kind, _} =
      dice
      |> flatten()
      |> Enum.group_by(&(&1))
      |> Enum.reject(fn {_die, dice} -> length(dice) < 4 end)
      |> first()

    four_of_a_kind * 4
  end

  @small_straight [1,2,3,4,5]
  def smallStraight( d1, d2, d3, d4, d5 ) do
    dice = [d1, d2, d3, d4, d5]

    cond do
      @small_straight == Enum.sort(dice) -> 15
      true -> 0
    end
  end

  @large_straight [2,3,4,5,6]
  def largeStraight( d1, d2, d3, d4, d5 ) do
    dice =
      [d1, d2, d3, d4, d5]
      |> Enum.sort()

    if @large_straight == dice do
      20
    else
      0
    end
  end

  def fullHouse( d1, d2, d3, d4, d5 ) do
    dice = [d1, d2, d3, d4, d5] |> Enum.sort()

    case dice do
      [a, a, b, b, b] -> a * 2 + b * 3
      [b, b, b, a, a] -> a * 2 + b * 3
      _ -> 0
    end
  end
end
