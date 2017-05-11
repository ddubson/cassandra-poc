import {Movie} from "../../../src/models/movie.model";
export class MovieFactory {
    public static build({
                            name = "Movie Name",
                            yearReleased = 2000,
                            directedBy = "Director"
                        } = {}) {
        return new Movie(name, yearReleased, directedBy);
    }
}