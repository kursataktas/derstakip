"use strict";
var home_component_1 = require('./home/home.component');
var course_component_1 = require('./courses/course.component');
var icons_component_1 = require('./icons/icons.component');
var table_component_1 = require('./table/table.component');
var maps_component_1 = require('./maps/maps.component');
exports.MODULE_ROUTES = [
    { path: 'home', component: home_component_1.HomeComponent },
    { path: 'courses', component: course_component_1.CourseComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'table', component: table_component_1.TableComponent },
    { path: 'icons', component: icons_component_1.IconsComponent },
    { path: 'maps', component: maps_component_1.MapsComponent },
];
exports.MODULE_COMPONENTS = [
    home_component_1.HomeComponent,
    course_component_1.CourseComponent,
    table_component_1.TableComponent,
    icons_component_1.IconsComponent,
    maps_component_1.MapsComponent
];
//# sourceMappingURL=dashboard.routes.js.map