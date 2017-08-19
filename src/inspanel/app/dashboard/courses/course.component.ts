import { Component,state,style,animate,transition, trigger, keyframes } from '@angular/core';
import { NgModule } from '@angular/core';

import { Course } from "../../classes/course";
import { Student } from "../../classes/student";
import { InstructorService } from "../services/instructor.service";

@Component({
    moduleId: module.id,
    selector: 'course-cmp',
    templateUrl: 'course.component.html',
})

export class CourseComponent{

    courses: Course[];
    students : Student[];
    courseCode: String;
    errorMessage: string;

    constructor (private service: InstructorService ) {
        this.listAll();
    }

    listAll() {
        this.service.listCourses()
            .subscribe(
                courses => this.courses = courses,
                error =>  this.errorMessage = <any>error);



    }

    listStudents (course : Course) {
        console.log(course.studentList);
        document.getElementById("course_table").style.display="none";
        this.courseCode = course.courseCode;
        document.getElementById("student_table").style.display="block";
        this.students = course.studentList;

    }


}
