import {Observable} from "rxjs/Observable";
import {Movie} from "../models/movie.model";
import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import 'rxjs/add/operator/map'

@Injectable()
export class MovieService {
    constructor(private http: Http) {
    }

    getAllMovies(): Observable<Movie[]> {
        return this.http.get("/movies").map((response: any) => response.json());
    }
}