cmake_minimum_required(VERSION 3.16)

project(custom_q_grid VERSION 0.1.0 LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

include_directories(
    ${CMAKE_CURRENT_SOURCE_DIR}/include
    ${CMAKE_CURRENT_SOURCE_DIR}/include/agent
    ${CMAKE_CURRENT_SOURCE_DIR}/include/environment
    ${CMAKE_CURRENT_SOURCE_DIR}/include/movement
)

add_executable(custom_q_grid
    src/entry.cpp
    src/agent/bidimensional_discrete_agent.cpp
    src/environment/bidimensional_environment.cpp
    src/environment/obstacle.cpp
    src/movement/bidimensional_discrete_movement.cpp
)

target_include_directories(custom_q_grid
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}/include
        ${CMAKE_CURRENT_SOURCE_DIR}/include/agent
        ${CMAKE_CURRENT_SOURCE_DIR}/include/environment
        ${CMAKE_CURRENT_SOURCE_DIR}/include/movement
)
