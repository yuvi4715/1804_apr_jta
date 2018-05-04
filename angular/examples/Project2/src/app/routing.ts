import { Routes } from '@angular/router';
//To create routes, we will use the Routes class from angulars router library

//Import every component you want to inject via routing
import { InterpolationComponent } from './components/interpolation/interpolation.component'
import { HomeComponent } from './components/home/home.component';
import { PokeapiComponent } from './components/pokeapi/pokeapi.component';
import { DirectiveComponent } from './components/directives/directive.component';
import { PipesComponent } from './components/pipes/pipes.component';
import { PostsComponent} from './components/posts/posts.component';

//Here we create the different inject mappings for our routes
export const appRoutes: Routes = [
    {
        path: 'interpolation', //The url that will trigger the injection
        component: InterpolationComponent //the component to be injected.
    },
    {
        path: 'home', //The url that will trigger the injection
        component: HomeComponent //the component to be injected.
    },
    {
        path: 'pokeapi', //The url that will trigger the injection
        component: PokeapiComponent //the component to be injected.
    },
    {
        path: 'directives', //The url that will trigger the injection
        component: DirectiveComponent //the component to be injected.
    },
    {
        path: 'pipes', //The url that will trigger the injection
        component: PipesComponent //the component to be injected.
    },
    {
        path: 'posts', //The url that will trigger the injection
        component: PostsComponent //the component to be injected.
    },
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {   //We can setup a url path to be used in situations where one is not found.
        path: '**', 
        component: InterpolationComponent 
    },
]

