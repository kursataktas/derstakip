import { Component,state,style,animate,transition, trigger, keyframes } from '@angular/core';
import { NgModule } from '@angular/core';

import { Course } from "../../classes/course";
import { InstructorService } from "../services/instructor.service";
import {Instructor} from "../../classes/instructor";
import {queue} from "rxjs/scheduler/queue";

@Component({
    moduleId: module.id,
    selector: 'course-cmp',
    templateUrl: 'course.component.html',
})

export class CourseComponent{

    courses: Course[];
    instructors: Instructor[];
    instructor: Instructor;
    errorMessage: string;
    newCourse: Course;

    constructor (private service: InstructorService ) {
        this.newCourse = new Course();
        this.getInstructors();
    }

    getInstructors () {
        this.service.listInstructors ()
            .subscribe(
                instructors => this.instructors = instructors,
                error => this.errorMessage = <any>error);
    }

    chooseIns (instructor) {
        this.instructor = instructor;
    }

    addCourse (courseCode:string , courseName:string) {
        console.log(courseCode + "   " + courseName + "  " + this.instructor.firstName);
        if(!courseCode || !courseName || !this.instructor) return;

        this.newCourse.courseCode = courseCode;
        this.newCourse.name = courseName;
        this.newCourse.studentList = null;
        this.newCourse.instructor = this.instructor;

        this.service.addCourse(this.newCourse)
            .subscribe(
                error =>  this.errorMessage = <any>error);
    }



}
