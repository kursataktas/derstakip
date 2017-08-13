"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var instructor_service_1 = require("../services/instructor.service");
var CourseComponent = (function () {
    function CourseComponent(service) {
        this.service = service;
        this.listAll();
    }
    CourseComponent.prototype.listAll = function () {
        var _this = this;
        this.service.listCourses()
            .subscribe(function (courses) { return _this.courses = courses['courses']; }, function (error) { return _this.errorMessage = error; });
    };
    CourseComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'course-cmp',
            templateUrl: 'course.component.html',
        }), 
        __metadata('design:paramtypes', [instructor_service_1.InstructorService])
    ], CourseComponent);
    return CourseComponent;
}());
exports.CourseComponent = CourseComponent;
//# sourceMappingURL=course.component.js.map