import {Component, Input} from "@angular/core";
import {Movie} from "../../models/movie.model";

@Component({
    selector: 'movie-item',
    template: ``
})
export class MovieItem {
    @Input() movie: Movie;
}