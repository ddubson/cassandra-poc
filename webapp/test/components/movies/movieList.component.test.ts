import {Movie} from "../../../src/models/movie.model";
import {ComponentFixture, ComponentFixtureAutoDetect, TestBed} from "@angular/core/testing";
import {MovieList} from "../../../src/components/movies/movieList.component";
import {By} from "@angular/platform-browser";
import {MovieItem} from "../../../src/components/movies/movieItem.component";

describe("Component: MovieList", () => {
    let component: MovieList,
        fixture: ComponentFixture<MovieList>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [MovieList, MovieItem],
            providers: [{provide: ComponentFixtureAutoDetect, useValue: true}]
        });

        fixture = TestBed.createComponent(MovieList);
        component = fixture.componentInstance;
    });

    describe("rendering", () => {
        it("should render all movies", () => {
            const movie1 =  new Movie("Pulp Fiction", 1994, "Quentin Tarantino");
            const movie2 = new Movie("Goodfellas", 1990, "Martin Scorsese");
            component.movies = [movie1, movie2];
            fixture.detectChanges();

            const movieItems: MovieItem[] = fixture.debugElement.queryAll(By.directive(MovieItem)).map(mi => mi.injector.get(MovieItem));

            expect(movieItems.length).toEqual(2);
            expect(movieItems[0].movie).toEqual(movie1);
            expect(movieItems[1].movie).toEqual(movie2);
        })
    });

    describe("on init", () => {
       it("fetch latest movies", () => {

       });
    });
});