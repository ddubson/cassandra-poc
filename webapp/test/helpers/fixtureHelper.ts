import {ComponentFixture} from "@angular/core/testing";
import {Type} from "@angular/core";
import {By} from "@angular/platform-browser";

export class FixtureHelper<T> {
    constructor(private fixture: ComponentFixture<T>) {
    }

    getComponent(): T {
        return this.fixture.componentInstance;
    }

    getInjectedComponents(directive: Type<any>): any {
        return this.fixture.debugElement.queryAll(By.directive(directive)).map(mi => mi.injector.get(directive));
    }

    refresh(): void {
        this.fixture.detectChanges();
    }
}