

// create a movie array
let movies = ["Interstellar", "Collateral", "21 Jump Street"];

// create a loop that prompts the user for their fav movies
for (let i = 1; i <= 3; i++) {
    let movie = prompt("Enter your favorite movie");
    movies.push(movie);
}
movies.forEach(function(movie) {
    alert("Favorite movie: " + movie);
});