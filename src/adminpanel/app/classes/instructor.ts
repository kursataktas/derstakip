
import {Course} from "./course";

export class Instructor {
    id : number;
    firstName : string;
    lastName : string;
    password : string;
    mail : string;
    courseList: Course[];
}