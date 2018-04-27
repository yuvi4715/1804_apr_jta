import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

//Import all components used by the Angular application here
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { InterpolationComponent } from './components/interpolation/interpolation.component';
import { appRoutes } from './routing';
import { HomeComponent } from './components/home/home.component';
import { PokeapiComponent } from './components/pokeapi/pokeapi.component';
import { DirectiveComponent} from './components/directives/directive.component'
import { PipesComponent } from './components/pipes/pipes.component';
import { PostsComponent} from './components/posts/posts.component';

//Services
import { PostsService } from './services/posts.service';

//Pipes
import { CustomPipe } from './pipes/custom.pipe';

//Directives
import { CustomDirective } from './directives/custom.directive';
@NgModule({
  //Have angular declare all classes to be used
  declarations: [
    AppComponent,
    NavbarComponent,
    InterpolationComponent,
    HomeComponent,
    PokeapiComponent,
    DirectiveComponent,
    PipesComponent,
    PostsComponent,

    //Pipes
    CustomPipe,

    //Directives
    CustomDirective

  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule
    
  ],
  /*
    Services typically are classes that supply data a services. 
    Therefore, they are considered providers. Any providers brought in
    can be considered singletons since there will ever only be 1 instance
    of each.
    Note: Anything inside the app,module provider sections is visible to the entire
    application. Should you want to only provide the provider to a specific scope more nested into
    the application, then you would have to create an inner module and provide it there.
  */
  providers: [PostsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
