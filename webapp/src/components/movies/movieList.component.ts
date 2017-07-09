import {Component, OnInit} from "@angular/core";
import {Movie} from "../../models/movie.model";
import {MovieService} from "../../services/movie.service";

@Component({
    selector: 'movie-list',
    template: `
        <div class="panel panel-primary">
            <h3 class="panel-heading">Movies</h3>
            <div class="panel-body">
                <div class="list-group">
                    <movie-item *ngFor="let movie of movies" [movie]="movie"></movie-item>
                </div>
            </div>
        </div>
    `
})
export class MovieList implements OnInit {
    movies: Movie[];

    constructor(private movieService: MovieService) {
    }

    ngOnInit(): void {
        this.movieService.getAllMovies().subscribe((movies: Movie[]) => {
            this.movies = movies;
        });
    }
}
