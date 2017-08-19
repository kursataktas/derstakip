"use strict";
var home_component_1 = require('./home/home.component');
var course_component_1 = require('./courses/course.component');
exports.MODULE_ROUTES = [
    { path: 'home', component: home_component_1.HomeComponent },
    { path: 'courses', component: course_component_1.CourseComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }
];
exports.MODULE_COMPONENTS = [
    home_component_1.HomeComponent,
    course_component_1.CourseComponent
];
//# sourceMappingURL=dashboard.routes.js.map