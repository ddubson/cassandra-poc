import {Component} from "@angular/core";
import {Movie} from "../../models/movie.model";

@Component({
    selector: 'movie-list',
    template: `
        <div>
            <div>Movies</div>
            <div>
                <movie-item *ngFor="let movie of movies" [movie]="movie"></movie-item>
            </div>
        </div>
    `
})
export class MovieList {
    movies: Movie[];
}