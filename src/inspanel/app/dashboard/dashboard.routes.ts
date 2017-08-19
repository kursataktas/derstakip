import { Route } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { HomeComponent } from './home/home.component';
import { CourseComponent } from './courses/course.component';
import { IconsComponent } from './icons/icons.component';
import { TableComponent } from './table/table.component';
import { MapsComponent } from './maps/maps.component';


export const MODULE_ROUTES: Route[] =[
    { path: 'home', component: HomeComponent },
    { path: 'courses', component: CourseComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'table', component: TableComponent },
    { path: 'icons', component: IconsComponent },
    { path: 'maps', component: MapsComponent },

]

export const MODULE_COMPONENTS = [
    HomeComponent,
    CourseComponent,

    TableComponent,
    IconsComponent,
    MapsComponent

]
