import { Directive, ElementRef, AfterViewInit } from '@angular/core';

@Directive({
    //Use brackets on selector to indicate it will be used as a property for
    //an element, and not just as the direct element name.
    selector: '[custom-directive]'
})

export class CustomDirective implements AfterViewInit{
    constructor(private el: ElementRef){

    }
    ngAfterViewInit(): void{
        this.el.nativeElement.style.background="red";//="'background-color':red";
    }
}