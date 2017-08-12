import {Injectable} from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';


@Injectable()
export class InstructorService {
	
	private listAnnotation_endPoint = "";
	private addAnnotation_endPoint = "";
	private editAnnotation_endPoint = "";
	private deleteAnnotation_endPoint = "";
	private listCourses_endPoint = "";
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
	
	listCourses () {
		
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