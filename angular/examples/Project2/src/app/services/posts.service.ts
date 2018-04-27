import { Injectable } from '@angular/core';
import { POSTS } from '../components/posts/posts';
import { Post } from '../components/posts/post';
import { Observable } from 'rxjs/observable';
import { of } from 'rxjs/observable/of';

/*
    The injectable decarator marks this class as one that may have injected
    dependencies elsewhere.
    It is a matter of convention and safety to inclde it for all service classes.
*/
@Injectable()
export class PostsService{
    constructor(){

    }

    /*
        Using Observables we can create asynchronous retrievals of data
        since Observables work in a manner where a request is taken and then awaits
        a function to be called that provides the requested content or
        an object representing an error. Either way, this callback allows us
        to be asynchronous.
    */
    getPosts(): Observable<Post[]>{
        /*
            The 'of' method returns an observable of a collection of Posts.
            Think of it as a sort of stream of data that has callback
            functionality.
        */
        return of(POSTS);
    }

}