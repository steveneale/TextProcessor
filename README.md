# TextProcessor

*TextProcessor* is a program that performs simple natural language processing (NLP) tasks on input text, written in [Java](https://www.java.com/en/download/faq/develop.xml) and making use of [OpenNLP](https://opennlp.apache.org/).

Tasks that *TextProcessor* performs include:

* Sentence splitting


## Building

*TextProcessor* is built using [Gradle](https://gradle.org/), which takes care of all the required dependencies. The Gradle Wrapper has also been included, which will automatically download the latest version of Gradle before building.

To build the project from the command line, type the following command from *TextProcessor*'s root directory:

```bash
./gradlew build
```

Once the build is complete, the `TextProcessor.jar` file will be available in `build/libs/`.


## Usage

To process text using the `TextProcessor.jar`, run the jar from the command line providing the following arguments:

* `-i`/`--input` - Relative path to an input file to be processed
* `-l`/`--language` - Language of the text to be processed (currently supported: `"en"`)

For example:

```bash
java -jar build/libs/TextProcessor.jar --input "relative/path/to/input.txt" --language "en"
```