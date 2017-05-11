import {Observable} from "rxjs/Observable";

export class ServiceMocks {
    public static createMovieService() {
        return {
            getAllMovies: () => Observable.empty()
        }
    }
}