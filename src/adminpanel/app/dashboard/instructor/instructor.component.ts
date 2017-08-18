import { Component,state,style,animate,transition, trigger, keyframes } from '@angular/core';
import { NgModule } from '@angular/core';

import { Instructor } from "../../classes/instructor";
import { InstructorService } from "../services/instructor.service";

@Component({
    moduleId: module.id,
    selector: 'instructor-cmp',
    templateUrl: 'instructor.component.html',
})

export class InstructorComponent{

    instructors: Instructor[];

    errorMessage: string;

    constructor (private service: InstructorService ) {
        this.listAll();
    }

    listAll() {
        this.service.listCourses()
            .subscribe(
                instructors => this.instructors = instructors ['instructors'],
                error =>  this.errorMessage = <any>error);
    }


}
