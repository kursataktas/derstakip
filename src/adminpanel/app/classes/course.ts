import { Student } from "./student";
import { Instructor } from "./instructor";





export class Course {
    id : number;
    courseCode: string;
    name: string;
    studentList: Student[];
    instructor: Instructor;
}