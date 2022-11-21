## word-square-api-2

<ins>App Info:

This application will generate a valid Word Square given:
- the size of the grid (n)
- the pool of characters to generate words from

<ins>Disclaimer:

NOTE: The characters provided in the pool MUST equal to the grid size squared (n<sup>2</sup>).

<ins>App Instructions:

Run the application either in the IDE (Run button), or in the command line using:

``` shell
java -jar target/<jarFileName>.jar
```

Before running this command, ensure you are in the jar files working directory.

Use POSTMAN to make a POST request to the URI:

``` 
http://localhost:8080/api/v2/wordsquare/
```

with a JSON body in the form of: 
```
{
"gridSize": 4,
"charPool": "aaccdeeeemmnnnoo"
}
```

OR

You can include the POST parameters in the URI:
``` 
http://localhost:8080/api/v2/wordsquare/7/aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy
```
