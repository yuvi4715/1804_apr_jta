import { Component } from '@angular/core';

@Component({
    selector: 'app-interpolation',
    templateUrl: './interpolation.component.html'
})

export class InterpolationComponent{

    

    public componentVariable = "robert";
    public someObject = {
        author: 'My name',
        age: 78
    }

    public styleObject = {
        color: 'blue',
        fontFamily: 'Comic Sans MS'
    }
    //:datatype to enforce a datatype
    public num:number = 2;

    public doubleNum(){
        this.num = this.num * 2;
    }

    public changeStyle(){
        if(this.styleObject.color == 'blue'){
            this.styleObject.color = 'red';
        }
        else if(this.styleObject.color == 'red'){
            this.styleObject.color = 'yellow';
        }
        else if(this.styleObject.color == 'yellow'){
            this.styleObject.color = 'green';
        }
        else if(this.styleObject.color == 'green'){
            this.styleObject.color = 'blue';
        }
        
    }
}