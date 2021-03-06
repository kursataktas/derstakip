"use strict";
var home_component_1 = require('./home/home.component');
var course_component_1 = require('./courses/course.component');
//import { StudentComponent } from './student/student.component';
var instructor_component_1 = require('./instructor/instructor.component');
var icons_component_1 = require('./icons/icons.component');
var table_component_1 = require('./table/table.component');
var notifications_component_1 = require('./notifications/notifications.component');
var typography_component_1 = require('./typography/typography.component');
var maps_component_1 = require('./maps/maps.component');
var upgrade_component_1 = require('./upgrade/upgrade.component');
exports.MODULE_ROUTES = [
    { path: 'home', component: home_component_1.HomeComponent },
    { path: 'courses', component: course_component_1.CourseComponent },
    // { path: 'student', component: StudentComponent },
    { path: 'instructor', component: instructor_component_1.InstructorComponent },
    { path: 'table', component: table_component_1.TableComponent },
    { path: 'icons', component: icons_component_1.IconsComponent },
    { path: 'notifications', component: notifications_component_1.NotificationsComponent },
    { path: 'typography', component: typography_component_1.TypographyComponent },
    { path: 'maps', component: maps_component_1.MapsComponent },
    { path: 'upgrade', component: upgrade_component_1.UpgradeComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }
];
exports.MODULE_COMPONENTS = [
    home_component_1.HomeComponent,
    course_component_1.CourseComponent,
    //  StudentComponent,
    instructor_component_1.InstructorComponent,
    table_component_1.TableComponent,
    icons_component_1.IconsComponent,
    notifications_component_1.NotificationsComponent,
    typography_component_1.TypographyComponent,
    maps_component_1.MapsComponent,
    upgrade_component_1.UpgradeComponent
];
//# sourceMappingURL=dashboard.routes.js.map