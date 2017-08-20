import {Injectable} from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import {Course} from '../../classes/course';
import {Instructor} from "../../classes/instructor";

@Injectable()
export class InstructorService {
	private app_setting = "http://localhost:8080/api/admin/";
	private listInstructors_URL = this.app_setting + "list/instructor";
	private addCourse_URL = this.app_setting + "add/course";
	private listAnnotation_endPoint = "";
	private addAnnotation_endPoint = "";
	private editAnnotation_endPoint = "";
	private deleteAnnotation_endPoint = "";

	private addCourses_endPoint = "";
	

	constructor (private http: Http) {}

	
	listAnnotations () {
		
	}

	public listInstructors() : Observable<Instructor[]> {
		return this.http.get(this.listInstructors_URL)
            .map(res => res.json())
            .catch(this.handleError)
	}

	
	addCourse (course : Course) {
		let headers = new Headers({ 'Content-Type': 'application/json' });
		let options = new RequestOptions({ headers: headers });
		console.log("hslsllsl"+ course.courseCode);
		return this.http.post(this.addCourse_URL, course, options)
            .map(res => res.json())
            .catch(this.handleError);
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