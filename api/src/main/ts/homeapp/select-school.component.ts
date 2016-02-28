import{Component, OnInit}from 'angular2/core';
import {Router, RouteParams}from 'angular2/router';
import {School}from './school'

@Component({
	selector: 'home-select-city',
	templateUrl: 'homeapp/select-school.component.html',
	styleUrls: ['homeapp/select-school.component.css']
})
export class SelectSchoolComponent implements OnInit {
	title = "Select school";
	city :string;
	schools: School[] = [
		{"id": 1, "name": "St. Paul’S English School", "address1": "3rd Phase", "address2": "JP Nagar", "city": "Bengaluru", "state": "Karnataka", "pan": "abcd"},
		{"id": 2, "name": "Bishop Cotton Boys School", "address1": "St Marks Road, Residency Road" , "address2": "Richmond Town", "city": "Bengaluru", "state": "Karnataka", "pan": "abcd"},
	];
	
	constructor(
		private _router: Router,
		private _routeParams: RouteParams){}
	ngOnInit() {
		this.city = this._routeParams.get('city');
		console.log(this.city);
	}
	goBack() {
		 window.history.back()
	}
}