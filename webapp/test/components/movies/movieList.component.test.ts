import {Movie} from "../../../src/models/movie.model";
import {ComponentFixtureAutoDetect, TestBed} from "@angular/core/testing";
import {MovieList} from "../../../src/components/movies/movieList.component";
import {MovieItem} from "../../../src/components/movies/movieItem.component";
import {FixtureHelper} from "../../helpers/fixtureHelper";
import {MovieService} from "../../../src/services/movie.service";
import {MovieFactory} from "../../helpers/factories/movieFactory";
import {Observable} from "rxjs/Observable";
import "rxjs/add/observable/of";
import "rxjs/add/observable/empty";
import {ServiceMocks} from "../../helpers/serviceMocks";

describe("Component: MovieList", () => {
    let fixtureHelper: FixtureHelper<MovieList>;
    let movieServiceMock: any = ServiceMocks.createMovieService();

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [MovieList, MovieItem],
            providers: [
                {provide: MovieService, useValue: movieServiceMock},
                {provide: ComponentFixtureAutoDetect, useValue: true}
            ]
        });
    });

    describe("rendering", () => {
        beforeEach(() => {
            fixtureHelper = new FixtureHelper(TestBed.createComponent(MovieList));
        });

        it("should render all movies", () => {
            const movie1 = MovieFactory.build({
                name: "Pulp Fiction",
                yearReleased: 1994,
                directedBy: "Quentin Tarantino"
            });
            const movie2 = MovieFactory.build({name: "GoodFellas", yearReleased: 1990, directedBy: "Martin Scorsese"});

            const component = fixtureHelper.getComponent();
            component.movies = [movie1, movie2];
            fixtureHelper.refresh();

            const movieItems: MovieItem[] = fixtureHelper.getInjectedComponents(MovieItem);
            const movies = movieItems.map(movieItem => movieItem.movie);

            expect(movies).toEqual([movie1, movie2]);
        })
    });

    describe("on init", () => {
        it("calls the movieService to fetch all movies", () => {
            spyOn(movieServiceMock, 'getAllMovies').and.returnValue(Observable.of([MovieFactory.build()]));
            fixtureHelper = new FixtureHelper(TestBed.createComponent(MovieList));
            expect(movieServiceMock.getAllMovies).toHaveBeenCalled();
        });

        it("updates the movies array", () => {
            const movie1: Movie = MovieFactory.build();
            spyOn(movieServiceMock, 'getAllMovies').and.returnValue(Observable.of([movie1]));
            fixtureHelper = new FixtureHelper(TestBed.createComponent(MovieList));
            expect(fixtureHelper.getComponent().movies).toEqual([movie1]);
        })
    });
});