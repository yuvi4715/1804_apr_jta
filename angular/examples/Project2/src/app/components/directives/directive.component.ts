import { Component } from '@angular/core';
import { CustomDirective } from '../../directives/custom.directive';

@Component({
    selector: 'app-directive',
    templateUrl: './directive.component.html'
})
/*
    There is a tool called 'Augery' that can be used to 
    analyze and debug Angular applications form the front end.
*/
export class DirectiveComponent{
    public buttonValue = "Show Answer";
    public visible = false;
    public toggleAnswer(){
        this.visible = !this.visible;
        if(this.visible){
            this.buttonValue = "Hide Answer";
        }else{
            this.buttonValue = "Show Answer";
        }
    }
    public styleObject = {
        color:"red",
        //Can use the html version of the key if you use quotes.
        "background-color": "red"
    }
    public emps = [
        {name:"robert",
        id:15},
        {name:"ryan",
        id:2},
        {name:"rebecca",
        id:31}
    ]
}