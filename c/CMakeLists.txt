cmake_minimum_required(VERSION 3.16)
set(CMAKE_VERBOSE_MAKEFILE ON)
project(Sample VERSION 1.0
        DESCRIPTION "Sample repo to build code and tests in.")

set(CMAKE_C_STANDARD 99)

# uncomment these lines to enable coverage measurements using gcov
#set(CMAKE_CXX_FLAGS "--coverage")

enable_testing()
add_subdirectory(src)
add_subdirectory(test-gtest)

