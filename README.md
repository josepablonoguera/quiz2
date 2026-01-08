# Quiz2 (Java + Ant)

Proyecto Java sin Maven/Gradle, listo para compilar con **Ant** y compatible con **NetBeans** o ejecución por consola.

## Estructura

```
src/
  quiz/Main.java
  quiz/io/ConsoleIO.java
  quiz/core/QuizMode.java
  quiz/a/BracketBalancer.java
  quiz/a/Stack.java
  quiz/a/ArrayStack.java
  quiz/b/SparseVector.java
  quiz/b/Node.java
  quiz/b/SparseVectorOps.java
  quiz/eval/AutoGrader.java
  quiz/eval/TestCase.java
  quiz/eval/GradeReport.java
build.xml
README.md
```

## Compilación y ejecución (Ant)

Desde la raíz del proyecto:

```bash
ant clean
ant compile
ant run
```

Para generar un JAR ejecutable:

```bash
ant jar
```

El JAR se crea en `dist/quiz2.jar`.

## Archivos que **NO** deben modificar

El estudiantado solo debe editar los métodos marcados con `// TODO_ESTUDIANTE: implementar`.
No modifique estos archivos:

- `src/quiz/Main.java`
- `src/quiz/io/ConsoleIO.java`
- `src/quiz/core/QuizMode.java`
- `src/quiz/a/Stack.java`
- `src/quiz/a/ArrayStack.java`
- `src/quiz/b/SparseVector.java`
- `src/quiz/b/Node.java`
- `src/quiz/eval/AutoGrader.java`
- `src/quiz/eval/TestCase.java`
- `src/quiz/eval/GradeReport.java`

Los únicos métodos a completar están en:

- `src/quiz/a/BracketBalancer.java`
- `src/quiz/b/SparseVectorOps.java`
