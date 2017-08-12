import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule ,JsonpModule} from '@angular/http';
import { MODULE_COMPONENTS, MODULE_ROUTES } from './dashboard.routes';


import {InstructorService} from './services/instructor.service';

@NgModule({
    imports: [
        RouterModule.forChild(MODULE_ROUTES),
        CommonModule,
        BrowserModule,
        HttpModule,
        RouterModule,
        JsonpModule,
        FormsModule,
        ReactiveFormsModule
    ],
    declarations: [ MODULE_COMPONENTS ],
    providers : [
        InstructorService
    ]
})

export class DashboardModule{}
