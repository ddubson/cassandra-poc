import {Component, Input} from "@angular/core";
import {Movie} from "../../models/movie.model";

@Component({
    selector: 'movie-item',
    template: `
        <div>
            <div>{{movie.name}}</div>
            <div>{{movie.directedBy}}</div>
            <div>{{movie.yearReleased}}</div>
        </div>`
})
export class MovieItem {
    @Input() movie: Movie;
}