import {ReflectiveInjector} from "@angular/core";
import {MovieService} from "../../src/services/movie.service";
import {Http, ResponseOptions, Response, RequestOptions, BaseRequestOptions, ConnectionBackend} from "@angular/http";
import {MockBackend} from "@angular/http/testing";
import {MovieFactory} from "../helpers/factories/movieFactory";
import {Observable} from "rxjs/Observable";

describe("Service: MovieService", () => {
    let http: Http, movieService: MovieService;

    beforeEach(() => {
        const injector = ReflectiveInjector.resolveAndCreate([
            {provide: ConnectionBackend, useClass: MockBackend},
            {provide: RequestOptions, useClass: BaseRequestOptions},
            Http, MovieService
        ]);
        http = injector.get(Http);
        movieService = injector.get(MovieService);
    });

    describe("fetching all movies", () => {
        it("should fetch movies", () => {
            const movie1 = MovieFactory.build();
            const fakeResponse = new Response(new ResponseOptions({body: [movie1]}));

            spyOn(http, 'get').and.returnValue(Observable.of(fakeResponse));

            movieService.getAllMovies();

            expect(http.get).toHaveBeenCalled();
        });
    })

});