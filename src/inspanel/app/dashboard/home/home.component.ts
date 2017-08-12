import {Component, OnInit,trigger,state,style,transition,animate,keyframes, group} from '@angular/core';
import initDemo = require('../../../assets/js/charts.js');
import initNotify = require('../../../assets/js/notify.js');

import { InstructorService } from '../services/instructor.service';

declare var $:any;

@Component({
    moduleId: module.id,
    selector: 'home-cmp',
    templateUrl: 'home.component.html',
    animations: [
        trigger('cardtasks', [
            state('*', style({
                '-ms-transform': 'translate3D(0px, 0px, 0px)',
                '-webkit-transform': 'translate3D(0px, 0px, 0px)',
                '-moz-transform': 'translate3D(0px, 0px, 0px)',
    '-o-transform':'translate3D(0px, 0px, 0px)',
    transform:'translate3D(0px, 0px, 0px)',
    opacity: 1})),
transition('void => *', [
    style({opacity: 0,
        '-ms-transform': 'translate3D(0px, 150px, 0px)',
        '-webkit-transform': 'translate3D(0px, 150px, 0px)',
        '-moz-transform': 'translate3D(0px, 150px, 0px)',
        '-o-transform':'translate3D(0px, 150px, 0px)',
        transform:'translate3D(0px, 150px, 0px)',
    }),
    animate('0.3s 0.75s ease-out')
])
])
]
})

export class HomeComponent {

    constructor() {}
	
	//addAnnotation(newAnnotation : string) {
	//	this.service.addAnnotation(newAnnotation,"bbm203");
		
	//}
}
