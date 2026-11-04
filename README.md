# custom-q-grid

Custom Q-Learning grid world, currently migrating from C++ to Java.

## Java (Primary)

This repository now uses Maven as the primary build path.

### Requirements

- Java 17+
- Maven 3.9+

### Build

```bash
mvn clean compile
```

### Test

```bash
mvn test
```

### Run

```bash
mvn -q compile
java -cp target/classes com.greasenbrine.qgrid.CustomQGridApplication
```

## C++ (Legacy)

The original C++ implementation is preserved in [outdated-cpp/](outdated-cpp/) for reference.

- Legacy C++ source: `outdated-cpp/src`
- Legacy C++ headers: `outdated-cpp/include`
- Legacy C++ build config: `outdated-cpp/CMakeLists.txt`

New development should target Java under `src/main/java`.
