# vocab

A simple vocabulary builder and tester.

## Use

Vocab is a simple Java application that accumulates vocabulary words and 
definitions, and allows re-playing them to test knowledge of the collected
terms.

To begin, add a few vocabulary words, with their definitions. You may also start
with an XML file. Look at [XML Structure](#xml-structure) for more information
about the XML file.

With the data loaded, you can add words to the current list of vocabulary words,
or you can test your knowledge of the current set of words by pressing the
"Start" button in the lower right.

### Testing

When you decide to test yourself, the status bar will report the percentage of
words that you have guessed correctly.

## XML Structure

The simplest example of an acceptable word list for "vocab" is:

    <vocabularylist>
        <word value="cavalcade">
            <def>A procession of riders or carriages</def>
            <def>A procession of vehicles or ships</def>
            <def>A dramatic sequence or procession</def>
        </word>
    </vocabularylist>

## Issues

Please track issues in the [issue tracker](https://github.com/dzwarg/vocab).