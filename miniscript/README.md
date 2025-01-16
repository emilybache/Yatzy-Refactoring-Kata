# Miniscript translation of the kata

To run the script you can either use MiniMicro(https://miniscript.org/MiniMicro/index.html#about) or command line Miniscript(https://miniscript.org/). Testing uses the "qa" module which already should come with your installation.

Running the tests is done with the `miniscript yatzy.ms` command in the terminal or using the `run yatzy.ms` command in MiniMicro.

If all test ran sucessfully you will see `Ran all test.`

If the a test fail you will see a message similar to:

```
Assert failed: expected `0`, but got `1`
Call stack:
  0. (current program) line 314
  1. (current program) line 332
(To clear this display, enter: qa.clear)
```