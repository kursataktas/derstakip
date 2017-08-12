import { Component,state,style,animate,transition, trigger, keyframes } from '@angular/core';
import { NgModule } from '@angular/core';

import { Course } from "../../classes/course";
import { InstructorService } from "../services/instructor.service";

@Component({
    moduleId: module.id,
    selector: 'course-cmp',
    templateUrl: 'course.component.html',
})

export class CourseComponent{
    courses: Course[];
    service: InstructorService;


}
