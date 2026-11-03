# Legacy C++ Implementation (Outdated)

This folder contains the original C++/CMake implementation preserved for reference while Java/Maven is now the primary runtime.

## Scope

- Source files: `src/`
- Headers: `include/`
- Build config: `CMakeLists.txt`, `CMakePresets.json`

## Build (Legacy)

From this folder:

```bash
cmake -S . -B build
cmake --build build
```

## Notes

- This implementation is retained for historical parity and comparison.
- New development should target the Java code under `../src/main/java`.
