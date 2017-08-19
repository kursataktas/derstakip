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
var http_1 = require('@angular/http');
var Observable_1 = require('rxjs/Observable');
require('rxjs/add/operator/catch');
require('rxjs/add/operator/map');
var InstructorService = (function () {
    function InstructorService(http) {
        this.http = http;
        this.app_setting = "http://localhost:8080/api/instructor/";
        this.listAnnotation_endPoint = "";
        this.addAnnotation_endPoint = "";
        this.editAnnotation_endPoint = "";
        this.deleteAnnotation_endPoint = "";
        this.listCourses_endPoint = this.app_setting + "courses/1";
        this.addCourses_endPoint = "";
    }
    InstructorService.prototype.addAnnotation = function (ann, code) {
    };
    InstructorService.prototype.deleteAnnotation = function () {
    };
    InstructorService.prototype.updateAnnotation = function () {
    };
    InstructorService.prototype.listAnnotations = function () {
    };
    InstructorService.prototype.listCourses = function () {
        return this.http.get(this.listCourses_endPoint)
            .map(function (res) { return res.json(); })
            .catch(this.handleError);
    };
    InstructorService.prototype.addCourse = function () {
    };
    InstructorService.prototype.handleError = function (error) {
        var errMsg;
        if (error instanceof http_1.Response) {
            var body = error.json() || '';
            var err = body.error || JSON.stringify(body);
            errMsg = error.status + " - " + (error.statusText || '') + " " + err;
        }
        else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(error);
        return Observable_1.Observable.throw(errMsg);
    };
    InstructorService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], InstructorService);
    return InstructorService;
}());
exports.InstructorService = InstructorService;
//# sourceMappingURL=instructor.service.js.map