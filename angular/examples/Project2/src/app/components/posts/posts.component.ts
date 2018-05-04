import { Component, OnInit } from '@angular/core';
import { Post } from './post';
import { POSTS } from './posts';
import { PostsService } from '../../services/posts.service';

@Component({
    selector: 'app-posts',
    templateUrl: './posts.component.html'
})

export class PostsComponent implements OnInit{
    posts: Post[];

    /*
        here, in the constructor, we provide it with a variable container
        for our service. Angular sees this and chooses to inject an instance
        of PostsService into this class. No where in the application do 
        we create an instance of PostsComponent with our own input of a 
        PostsService method. Instantiation and injection is all done by 
        angular.
    */
    constructor(private postsService: PostsService){
        
    }

    ngOnInit(){
        this.getPosts();
    }

    getPosts():void {
        this.postsService.getPosts().subscribe(
            posts => this.posts = posts
        );
        /*
            Subscribe is a method that makes all of this asynchronous.
            It waits for the observable to emit data back to it once it has
            been called. Here it takes a varibale called posts and waits for
            it to get populated through the emitter. Once it's been populated,
            we will take the contents (stored in method variable 'posts') and
            assign them to our local posts variable.
        */
    }


}