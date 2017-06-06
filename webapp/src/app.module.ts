import {NgModule} from "@angular/core";
import {FilmFoxApp} from "./components/filmfoxapp.component";
import {BrowserModule} from "@angular/platform-browser";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {ROUTES} from "./app.routes";
import {MovieList} from "./components/movies/movieList.component";
import {MovieItem} from "./components/movies/movieItem.component";
import {MovieService} from "./services/movie.service";
import {HttpModule} from "@angular/http";

@NgModule({
    declarations: [
        FilmFoxApp,
        MovieList,
        MovieItem
    ],
    providers: [
        MovieService
    ],
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpModule,
        RouterModule.forRoot(ROUTES, {useHash: true})
    ],
    bootstrap: [FilmFoxApp]
})
export class AppModule {

}