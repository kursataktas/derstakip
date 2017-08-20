import { Course } from "./course";

export class Student {
    id : number;
    firstName : string;
    lastName : string;
    mail : string;
    password:string;
    studentNo : number;
    courseList : Course[];
}