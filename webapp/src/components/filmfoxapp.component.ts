import {Component} from "@angular/core";

@Component({
    selector: 'ff-app',
    template: `
        <ff-top-nav></ff-top-nav>
        <div class="container" style="margin-top: 60px;">
            <router-outlet></router-outlet>
        </div>
    `
})
export class FilmFoxApp {

}