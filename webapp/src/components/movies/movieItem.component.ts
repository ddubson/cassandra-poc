import {Component, Input} from "@angular/core";
import {Movie} from "../../models/movie.model";

@Component({
    selector: 'movie-item',
    template: `
        <h4 class="list-group-item-heading">{{movie.name}} ({{movie.yearReleased}})</h4>
        <p class="list-group-item-text">directed by {{movie.directedBy}}</p>
    `
})
export class MovieItem {
    @Input() movie: Movie;
}