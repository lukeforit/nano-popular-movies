# nano-popular-movies
The application for browsing movies from **themoviedb.org** website.  

To use this app you will need API key from
https://developers.themoviedb.org/3 .
    
Create a system environment variable which will be storing your API key. The name of the variable 
should be exactly `MOVIE_DB_API_KEY`. 

For Windows 7 or later you can use command  
 
    setx MOVIE_DB_API_KEY api_key_value

For Linux you can edit file 

    ~/.bash_proflle
    
and append `$PATH` with 

    export PATH=${PATH}:${HOME}/bin