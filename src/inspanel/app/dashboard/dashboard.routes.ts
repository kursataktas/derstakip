import { Route } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { HomeComponent } from './home/home.component';
import { CourseComponent } from './courses/course.component';

export const MODULE_ROUTES: Route[] =[
    { path: 'home', component: HomeComponent },
    { path: 'courses', component: CourseComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }

]

export const MODULE_COMPONENTS = [
    HomeComponent,
    CourseComponent
]
