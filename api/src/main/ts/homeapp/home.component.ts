import{Component}from'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS}from 'angular2/router';
import {SelectCityComponent}from './select-city.component';
import {SelectSchoolComponent} from './select-school.component';

@Component({
	selector: 'home-app',
	directives: [ROUTER_DIRECTIVES],
	providers: [ROUTER_PROVIDERS],
	template: `
		<h1>{{title}}</h1>
		<router-outlet></router-outlet>
	`,
	styleUrls: ['homeapp/home.component.css']
})
@RouteConfig([
	{
		path: 'select-city',
		name: 'SelectCity',
		component: SelectCityComponent,
		useAsDefault: true
	},
	{
		path: 'select-school/:city',
		name: 'SelectSchool',
		component: SelectSchoolComponent,
	}
])
export class HomeComponent {
	title = 'Fee Plaza';
}
