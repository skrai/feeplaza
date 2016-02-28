import{Component, OnInit}from 'angular2/core';
import {Router}from 'angular2/router';

@Component({
	selector: 'home-select-city',
	templateUrl: 'homeapp/select-city.component.html',
	styleUrls: ['homeapp/select-city.component.css']
})
export class SelectCityComponent implements OnInit {
	title = "Select city";
	cities: string[] = [
		"Bengaluru",
		"Mysuru",
		"Hyderabad",
		"Chennai",
		"Mumbai",
		"Tumkuru",
		"New Delhi",
		"Bhopal",
		"Chandigarh",
		"Patiala"
	];
	constructor(private _router: Router){}
	ngOnInit() {}
	gotoCity(city:string) {
		let link = ['SelectSchool', {city: city}];
		this._router.navigate(link);
	}
}