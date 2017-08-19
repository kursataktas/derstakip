import {Injectable} from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import {Course} from '../../classes/course';
import {Student} from "../../classes/student";

@Injectable()
export class InstructorService {

	private app_setting = "http://localhost:8080/api/instructor/";
	private listAnnotation_endPoint = "";
	private addAnnotation_endPoint = "";
	private editAnnotation_endPoint = "";
	private deleteAnnotation_endPoint = "";
	private listCourses_endPoint = this.app_setting + "courses/1";
	private listStudents_endPoint = this.app_setting + "students/{{course_id}}";
	private addCourses_endPoint = "";
	

	constructor (private http: Http) {}
	
	addAnnotation (ann: string , code : string) {
		
	}
	
	deleteAnnotation () {
		
	}
	
	updateAnnotation () {
		
	}
	
	listAnnotations () {
		
	}
	
	public listCourses () : Observable<Course[]> {
		return this.http.get(this.listCourses_endPoint)
			.map(res => res.json())
			.catch(this.handleError)
	}

	public listStudentsofCourse () : Observable<Student[]> {
		return this.http.get(this.listStudents_endPoint)
            .map(res => res.json())
            .catch(this.handleError)
	}
	
	addCourse () {
		
	}
	
	private handleError (error: Response | any) {
		let errMsg: string;
		
		if (error instanceof Response) {
		  const body = error.json() || '';
		  const err = body.error || JSON.stringify(body);
		  errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
		} else {
		  errMsg = error.message ? error.message : error.toString();
		}
		
		console.error(error);
		return Observable.throw(errMsg);
	}
}