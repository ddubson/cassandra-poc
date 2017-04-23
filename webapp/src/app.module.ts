import {NgModule} from "@angular/core";
import {FilmFoxAppComponent} from "./components/filmfoxapp.component";
import {BrowserModule} from "@angular/platform-browser";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {ROUTES} from "./app.routes";
import {Hello} from "./components/hello.component";
import {MovieList} from "./components/movies/movieList.component";
import {MovieItem} from "./components/movies/movieItem.component";

@NgModule({
    declarations: [
        FilmFoxAppComponent,
        MovieList,
        MovieItem
    ],
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        RouterModule.forRoot(ROUTES, {useHash: true})
    ],
    bootstrap: [FilmFoxAppComponent]
})
export class AppModule {

}